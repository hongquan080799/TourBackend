package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Khachhang;
import com.abc.entity.Taikhoan;
import com.abc.repository.KhachHangRepository;
import com.abc.repository.TaikhoanRepository;
import com.abc.request.KhachHangRequest;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
public class KhachHangController {
	@Autowired
	KhachHangRepository repo;
	
	@Autowired
	TaikhoanRepository repoTaiKhoan;
	
	@GetMapping("/khachhang")
	public ResponseEntity<Object> getAllKhachHang()
	{
		try
		{
			List<Khachhang> khachhangs = repo.findAll();
			return new  ResponseEntity<Object>(khachhangs,HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/khachhang?id={id}")
	public ResponseEntity<Object> getOneKhachHang(@Param(value = "id") String id)
	{
		try
		{
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<Object>(repo.getById(id),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/khachhang")
	public ResponseEntity<Object> insertKhachHang(@RequestBody KhachHangRequest khachHangRequest)
	{
		try
		{
			int makh = (int) System.currentTimeMillis() % 100000000;
			
			khachHangRequest.setId(makh);
			Taikhoan taikhoan = new Taikhoan();
			taikhoan.setStatus(1);
			taikhoan.updateKhachHang(khachHangRequest);
			
			repoTaiKhoan.save(taikhoan);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/khachhang/{id}")
	public ResponseEntity<Object> deleteKhachHang(@RequestParam String id)
	{
		try
		{
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			
			Khachhang khachhang = repo.getById(id);
			if (khachhang.getTaikhoan() != null)
			{
				repoTaiKhoan.deleteById(khachhang.getTaikhoan().getUsername());
			}
			
			repo.deleteById(id);
			
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
