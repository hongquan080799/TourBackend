package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.repository.DatTourRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

import javassist.expr.NewArray;

@RestController
public class DatTourController {
	
	@Autowired
	DatTourRepository repo;
	
	@GetMapping("/dattour/{idtour}")
	public ResponseEntity<Object> getDanhSachDatTour(@PathVariable String idtour)
	{
		try
		{
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
