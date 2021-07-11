package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Photo;
import com.abc.entity.Tuyen;
import com.abc.repository.PhotoRepository;
import com.abc.repository.TuyenRepository;

@RestController
@CrossOrigin
public class TuyenController {
	
	@Autowired
	TuyenRepository repo;
	
	@Autowired
	PhotoRepository photoRepo;
	
	@GetMapping("/tuyen")
	public List<Tuyen> getListTuyen(){
		return repo.findAll();
	}
	
	@PostMapping("/tuyen")
	public ResponseEntity<String> insertTuyen(@Validated @RequestBody Tuyen tuyen){
		//System.out.println(tuyen);
		List<Tuyen> listTuyen = repo.findAll();
		for(Tuyen tt : listTuyen) {
			if(tt.getMatuyen().equalsIgnoreCase(tuyen.getMatuyen())) {
				return new ResponseEntity<String>("Can't not insert tuyen " ,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		List<Photo> listPhoto = tuyen.getPhoto();
		try {
			repo.save(tuyen);
			for(Photo p : listPhoto) {
				p.setTuyen(tuyen);
				photoRepo.save(p);
			}
			return new ResponseEntity<String>("Successfully \n",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Can't not insert tuyen \n" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
