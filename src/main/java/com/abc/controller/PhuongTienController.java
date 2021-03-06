package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Phuongtien;
import com.abc.repository.PhuongTienRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class PhuongTienController {
	@Autowired
	PhuongTienRepository repo;
	
	@GetMapping("/phuongtien")
	public ResponseEntity<Object> getAllPhuongTien()
	{
		try
		{
			return new ResponseEntity<Object>(repo.findAll(),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/phuong tien/{id}")
	public ResponseEntity<Object> getOnePhuongTien(@PathVariable String id)
	{
		try
		{
			return new ResponseEntity<Object>(repo.getById(id),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/phuongtien")
	public ResponseEntity<Object> insertPhuongTien(@RequestBody Phuongtien phuongtien)
	{
		String mapt =  "PT" +  System.currentTimeMillis() % 100000000;
		phuongtien.setMapt(mapt);
		
		try
		{
			repo.save(phuongtien);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@DeleteMapping("/phuongtien/{id}")
	public ResponseEntity<Object> deletePhuongTien(@PathVariable String id)
	{
		try
		{
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			
			Phuongtien phuongtien = repo.getById(id);
			if (!phuongtien.getHinhthucdichuyen().isEmpty()) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.CANTDELETE),HttpStatus.NOT_ACCEPTABLE);
			
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
	
	@PutMapping("/phuongtien")
	public ResponseEntity<Object> updatePhuongTien(@RequestBody Phuongtien phuongtien)
	{
		try
		{
			repo.save(phuongtien);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
