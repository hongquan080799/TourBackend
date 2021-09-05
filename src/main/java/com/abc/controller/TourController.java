package com.abc.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.entity.Tour;
import com.abc.entity.Tuyen;
import com.abc.repository.TourRepository;
import com.abc.repository.TuyenRepository;

@RestController
@CrossOrigin
public class TourController {
	
	@Autowired
	TourRepository repo;
	
	@Autowired
	TuyenRepository tuyenRepository;
	
	@GetMapping("/tour")
	public List<Tour> getListTour(@RequestParam("matuyen") String matuyen){
		Tuyen tuyen = tuyenRepository.findById(matuyen).get();
		return repo.findAlTourByTuyen(tuyen);
	}
	@PostMapping("/tour")
	public ResponseEntity<Boolean> insertTour(@Validated @RequestBody Tour tour){
		String matour = "T" + System.currentTimeMillis() % 1000000000 ;
		tour.setMatour(matour);
		try {
			repo.save(tour);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/tour")
	public ResponseEntity<Boolean> deleteTour(@RequestParam("matour") String matour){
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
			repo.save(tour);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/hongquan")
	public String getFile(@Validated @RequestParam("file") MultipartFile hinhanh) {
		System.out.println(hinhanh.toString());
		return "ok";
	}
}
