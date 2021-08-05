package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Nhanvien;
import com.abc.repository.NhanVienRepository;

@RestController
public class NhanVienController {
	@Autowired
	NhanVienRepository repoNhanVien;
	
	@GetMapping("/nhanvien")
	public ResponseEntity<Object> getAllNhanVien()
	{
		try
		{
			List<Nhanvien> nhanViens =  repoNhanVien.findAll();
			return new ResponseEntity<Object>(nhanViens,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("/nhanvien")
	public ResponseEntity<Object> insertNhanVien(@RequestBody Nhanvien nhanvien)
	{
		try
		{
			if (!repoNhanVien.existsById(nhanvien.getManv())) return new ResponseEntity<Object>("3",HttpStatus.NOT_ACCEPTABLE);
			repoNhanVien.save(nhanvien);
			return new ResponseEntity<Object>("ok",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/nhanvien/{id}")
	public ResponseEntity<Object> deleteNhanVien(@PathVariable String id)
	{
		try
		{
			if (!repoNhanVien.existsById(id)) return new ResponseEntity<Object>("3",HttpStatus.NOT_ACCEPTABLE);
			repoNhanVien.deleteById(id);
			return new ResponseEntity<Object>("ok",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/nhanvien?id={id}")
	public ResponseEntity<Object> getNhanVien(@Param("id") String id)
	{
		try
		{
			if (!repoNhanVien.existsById(id)) return new ResponseEntity<Object>("3",HttpStatus.NOT_ACCEPTABLE);
			Nhanvien nhanvien = repoNhanVien.getById(id);
			return new ResponseEntity<Object>(nhanvien,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("2",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
