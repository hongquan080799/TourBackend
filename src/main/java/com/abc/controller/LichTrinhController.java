package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Lichtrinh;
import com.abc.entity.Tuyen;
import com.abc.repository.LichTrinhRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
public class LichTrinhController {
	@Autowired
	LichTrinhRepository repo;
	
	@GetMapping("/lichtrinh")
	public ResponseEntity<Object> getAllLichTrinh()
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
	
	@GetMapping("/lichtrinh?diadiem={diadiem}&tuyen={tuyen}")
	public ResponseEntity<Object> getOneLichTrinh(@RequestParam("diadiem") int diadiem, @RequestParam("tuyen") String tuyen)
	{
		try
		{
			List<Lichtrinh> lichtrinhs = repo.findAll();
			for (Lichtrinh lichtrinh:lichtrinhs)
			{
				if (lichtrinh.getDiadiemId() == diadiem && lichtrinh.getTuyen().getMatuyen().equalsIgnoreCase(tuyen))
				{
					return new ResponseEntity<Object>(lichtrinh,HttpStatus.OK);
				}
			}
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/lichtrinh")
	public ResponseEntity<Object> insertLichTrinh(@RequestBody Lichtrinh lichtrinh)
	{
		try
		{
			List<Lichtrinh> lichtrinhs = repo.findAll();
			for (Lichtrinh i:lichtrinhs)
			{
				if (i.getDiadiemId() == lichtrinh.getDiadiemId() && i.getTuyen().getMatuyen().equalsIgnoreCase(lichtrinh.getTuyen().getMatuyen()))
				{
					return new ResponseEntity<Object>(new responseCodeEntity(responseCode.DUPLICATE),HttpStatus.NOT_ACCEPTABLE);
				}
			}
			repo.save(lichtrinh);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/lichtrinh")
	public ResponseEntity<Object> updateLichTrinh(@RequestBody Lichtrinh lichtrinh)
	{
		try
		{
			List<Lichtrinh> lichtrinhs = repo.findAll();
			for (Lichtrinh i:lichtrinhs)
			{
				if (i.getDiadiemId() == lichtrinh.getDiadiemId() && i.getTuyen().getMatuyen().equalsIgnoreCase(lichtrinh.getTuyen().getMatuyen()))
				{
					return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
				}
			}
			repo.save(lichtrinh);
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/lichtrinh?diadiem={diadiem}&tuyen={tuyen}")
	public ResponseEntity<Object> deleteLichTrinh(@RequestParam("diadiem") int diadiem, @RequestParam("tuyen") String tuyen)
	{
		try
		{
			List<Lichtrinh> lichtrinhs = repo.findAll();
			for (Lichtrinh lichtrinh:lichtrinhs)
			{
				if (lichtrinh.getDiadiemId() == diadiem && lichtrinh.getTuyen().getMatuyen().equalsIgnoreCase(tuyen))
				{
					repo.delete(lichtrinh);
					return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
				}
			}
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
