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

import com.abc.converter.Converter_NhaHang;
import com.abc.dto.DTO_NhaHang;
import com.abc.entity.Nhahang;
import com.abc.repository.NhaHangRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;


@RestController
@CrossOrigin
public class NhaHangControler 
{
	@Autowired
	NhaHangRepository repo;
	
	@GetMapping("/nhahang")
	public ResponseEntity<Object> getAllNhaHang()
	{
		List<DTO_NhaHang> dto_NhaHangs = new ArrayList<DTO_NhaHang>();
		List<Nhahang> nhahangs = repo.findAll();
		for (Nhahang nhahang:nhahangs)
		{
			dto_NhaHangs.add(Converter_NhaHang.convertNhahangToDto_NhaHang(nhahang));
		}
		return new ResponseEntity<Object>(dto_NhaHangs,HttpStatus.OK);
	}
	
	@GetMapping("nhahang/{id}")
	public ResponseEntity<Object> getOneNhaHang(@PathVariable String id)
	{
		if (!repo.existsById(id))
		{
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.OK);
		}
		
		
		Nhahang nhahang = repo.getById(id);
		return new ResponseEntity<Object>(Converter_NhaHang.convertNhahangToDto_NhaHang(nhahang),HttpStatus.OK);
	}
	
	@PostMapping("/nhahang")
	public ResponseEntity<Object> insertNhaHang(@RequestBody DTO_NhaHang dto_NhaHang)
	{
		String manh = "KS" +  System.currentTimeMillis() % 100000000;
		dto_NhaHang.setManh(manh);
		Nhahang nhahang = Converter_NhaHang.convertDTO_NhahangToNhahang(dto_NhaHang);
		repo.save(nhahang);
		
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
	
	@PutMapping("/nhahang")
	public ResponseEntity<Object> updateNhaHang(@RequestBody DTO_NhaHang dto_NhaHang)
	{
		if (!repo.existsById(dto_NhaHang.getManh()))
		{
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		
		Nhahang nhahang = Converter_NhaHang.convertDTO_NhahangToNhahang(dto_NhaHang);
		repo.save(nhahang);
		
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
	
	@DeleteMapping("nhahang/{id}")
	public ResponseEntity<Object> deleteNhaHang(@PathVariable String id)
	{
		if (!repo.existsById(id))
		{
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			Nhahang nhahang = repo.getById(id);
			if (!nhahang.getDatnhahang().isEmpty()) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.CANTDELETE),HttpStatus.NOT_ACCEPTABLE);
				
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		repo.deleteById(id);
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
	}
}
