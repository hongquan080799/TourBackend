package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Tour;
import com.abc.repository.TourRepository;

@RestController
public class TourController {
	
	@Autowired
	TourRepository repo;
	@GetMapping("/tour")
	public List<Tour> getListTour(){
		return repo.findAll();
	}
	@PostMapping("/tour")
	public ResponseEntity<Boolean> insertTour(@Validated @RequestBody Tour tour){
		try {
			if(!isMatchMaTour(tour.getMatour())) {
				repo.save(tour);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/tour/{matour}")
	public ResponseEntity<Boolean> deleteTour(@PathVariable("matour") String matour){
		try {
			repo.deleteById(matour);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/tour")
	public ResponseEntity<Boolean> updateTour(@Validated @RequestBody Tour tour){
		try {
			if(isMatchMaTour(tour.getMatour())) {
				repo.save(tour);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	public Boolean isMatchMaTour(String matour) {
		List<Tour> list = repo.findAll();
		for(Tour tour : list) {
			if(tour.getMatour().equalsIgnoreCase(matour)) {
				return true;
			}
		}
		return false;
	}
}
