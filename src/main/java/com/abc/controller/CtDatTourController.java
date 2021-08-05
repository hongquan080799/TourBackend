package com.abc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.converter.Converter_CtDatTour;
import com.abc.dto.DTO_CtDatTour;
import com.abc.entity.CtDattour;
import com.abc.repository.CtDatTourRepository;

@RestController
public class CtDatTourController {
	@Autowired
	CtDatTourRepository repoCtDatTour;
	
	@GetMapping("/chitietdattour")
	public ResponseEntity<Object> getListCtDatTour()
	{
		try
		{
			List<CtDattour> ctDattours = repoCtDatTour.findAll();
			List<DTO_CtDatTour> dto_CtDatTours = new ArrayList<DTO_CtDatTour>();
			
			for(CtDattour ctDattour:ctDattours)
			{
				dto_CtDatTours.add(Converter_CtDatTour.convertCtDatTourToDto_CtDatTour(ctDattour));
			}
			return new ResponseEntity<Object>(dto_CtDatTours,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
