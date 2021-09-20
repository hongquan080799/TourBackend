package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Nhanvien;
import com.abc.entity.Taikhoan;
import com.abc.repository.NhanVienRepository;
import com.abc.repository.TaikhoanRepository;
import com.abc.request.NhanvienRequest;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class NhanVienController {
	@Autowired
	NhanVienRepository repoNhanVien;
	
	@Autowired
	TaikhoanRepository taiKhoanRepository;
	
	@GetMapping("/nhanvien")
	public ResponseEntity<Object> getAllNhanVien()
	{
		try
		{
			List<Nhanvien> nhanViens =  repoNhanVien.getListNV();
			return new ResponseEntity<Object>(nhanViens,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("/nhanvien")
	public ResponseEntity<Object> insertNhanVien(@RequestBody NhanvienRequest nhanvienRequest)
	{
		String manv = "NV" +  System.currentTimeMillis() % 100000000;
		nhanvienRequest.setManv(manv);
		Taikhoan taikhoan = new Taikhoan();
		taikhoan.setStatus(1);
		taikhoan.updateNhanvien(nhanvienRequest);
		
		try
		{
			taiKhoanRepository.save(taikhoan);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/nhanvien")
	public ResponseEntity<Object> deleteNhanVien(@RequestParam("username") String username)
	{
		
		Taikhoan taikhoan = taiKhoanRepository.findById(username).get();
		taikhoan.setStatus(0);
		try
		{
			taiKhoanRepository.save(taikhoan);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/nhanvien?id={id}")
	public ResponseEntity<Object> getNhanVien(@Param("id") String id)
	{
		try
		{
			if (!repoNhanVien.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_ACCEPTABLE);
			Nhanvien nhanvien = repoNhanVien.getById(id);
			return new ResponseEntity<Object>(nhanvien,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
