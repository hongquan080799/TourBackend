package com.abc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.converter.Converter_BinhLuan;
import com.abc.dto.DTO_BinhLuan;
import com.abc.entity.Binhluan;
import com.abc.repository.BinhLuanRepository;

@RestController
public class BinhLuanConrtoller {
	@Autowired
	BinhLuanRepository repoBinhLuan;
	
	@GetMapping("/binhluan")
	public ResponseEntity<Object> getListBinhLuan()
	{
		try
		{
			List<Binhluan> binhluans = repoBinhLuan.findAll();
			List<DTO_BinhLuan> dto_BinhLuans = new ArrayList<DTO_BinhLuan>(); 
			
			for(Binhluan binhluan:binhluans)
			{
				dto_BinhLuans.add(Converter_BinhLuan.convertBinhLuanToDto_BinhLuan(binhluan));
			}
			return new ResponseEntity<Object>(dto_BinhLuans,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
