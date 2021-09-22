package com.abc.controller;

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

import com.abc.entity.Diadiem;
import com.abc.repository.DiaDiemRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class DiaDiemController {
	@Autowired
	DiaDiemRepository repo;
	
	@GetMapping("/diadiem")
	public ResponseEntity<Object> getAllDiaDiem()
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
	
	@GetMapping("/diadiem/{id}")
	public ResponseEntity<Object> getOneDiaDiem(@PathVariable int id)
	{
		try
		{			
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			return new ResponseEntity<Object>(repo.getById(id),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/diadiem")
	public ResponseEntity<Object> insertDiaDiem(@RequestBody Diadiem diadiem)
	{
		try
		{
			
			repo.save(diadiem);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/diadiem")
	public ResponseEntity<Object> updateDiaDiem(@RequestBody Diadiem diadiem)
	{
		try
		{
			if (!repo.existsById(diadiem.getId())) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			Diadiem temp = repo.getById(diadiem.getId());
			diadiem.setLichtrinh(temp.getLichtrinh());
			repo.save(diadiem);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/diadiem/{id}")
	public ResponseEntity<Object> deleteDiaDiem(@PathVariable int id)
	{
		try
		{
			if (!repo.existsById(id)) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			Diadiem diadiem = repo.getById(id);
			if (!diadiem.getLichtrinh().isEmpty()) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.CANTDELETE),HttpStatus.NOT_ACCEPTABLE);
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
}
