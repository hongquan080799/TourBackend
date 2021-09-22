package com.abc.controller;

import java.util.ArrayList;
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

import com.abc.converter.Converter_DatKhachSan;
import com.abc.converter.Converter_KhachSan;
import com.abc.dto.DTO_KhachSan;
import com.abc.entity.Khachhang;
import com.abc.entity.Khachsan;
import com.abc.repository.KhachHangRepository;
import com.abc.repository.KhachSanRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class KhachSanControler {
	@Autowired
	KhachSanRepository repo;
	
	@GetMapping("/khachsan")
	public ResponseEntity<Object> getAllKhachSan()
	{
		List<Khachsan> khachsans = repo.findAll();
		List<DTO_KhachSan> dto_KhachSans = new ArrayList<DTO_KhachSan>();
		
		for(Khachsan khachsan:khachsans)
		{
			dto_KhachSans.add(Converter_KhachSan.convertKhachSanToDTO_KhachSan(khachsan));
		}
		
		return new ResponseEntity<Object>(dto_KhachSans,HttpStatus.OK);
	}
	
	@GetMapping("/khachsan/{id}")
	public ResponseEntity<Object> getKhachSan(@PathVariable String id)
	{
		if (!repo.existsById(id))
		{
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		
		Khachsan khachsan = repo.getById(id);
		return new ResponseEntity<Object>(khachsan,HttpStatus.OK);
	}
	
	@PostMapping("/khachsan")
	public ResponseEntity<Object> insertKhachSan(@RequestBody DTO_KhachSan dto_KhachSan)
	{
		String maks = "KS" +  System.currentTimeMillis() % 100000000;
		dto_KhachSan.setMaks(maks);
		repo.save(Converter_KhachSan.convertDTO_KhachSanToKhachsan(dto_KhachSan));
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
	
	@PutMapping("/khachsan")
	public ResponseEntity<Object> updateKhachSan(@RequestBody DTO_KhachSan dto_KhachSan)
	{
		if (!repo.existsById(dto_KhachSan.getMaks()))
		{
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		
		repo.save(Converter_KhachSan.convertDTO_KhachSanToKhachsan(dto_KhachSan));
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
	
	@DeleteMapping("/khachsan/{id}")
	public ResponseEntity<Object> deleteKhachSan(@PathVariable String id)
	{
		if (!repo.existsById(id))
		{
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		Khachsan khachsan = repo.getById(id);
		if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.CANTDELETE),HttpStatus.NOT_ACCEPTABLE);
		
		repo.deleteById(id);
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
}
