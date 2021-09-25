package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Photo;
import com.abc.entity.Tuyen;
import com.abc.repository.DatKhachSanRepository;
import com.abc.repository.DatNhaHangRepository;
import com.abc.repository.HinhThucDiChuyenRepository;
import com.abc.repository.LichTrinhRepository;
import com.abc.repository.PhotoRepository;
import com.abc.repository.TuyenRepository;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class TuyenController {
	
	@Autowired
	TuyenRepository repo;
	
	@Autowired
	PhotoRepository photoRepo;
	
	@Autowired
	LichTrinhRepository repoLichtrinh;
	
	@Autowired
	HinhThucDiChuyenRepository repoHinhThucDiChuyen;
	
	@Autowired
	DatKhachSanRepository repoDaKhachSan;
	
	@Autowired
	DatNhaHangRepository repoDatNhaHang;
	
	@Autowired
	PhotoRepository repoPhoto;
	
	@GetMapping("/tuyen")
	public List<Tuyen> getListTuyen(){
		return repo.findAll();
	}
	
	@GetMapping("/tuyen/detail")
	public Tuyen getTuyenByMatuyen(@RequestParam("matuyen") String matuyen){
		return repo.findById(matuyen).get();
	}
	
	@PostMapping("/tuyen")
	public ResponseEntity<Object> insertTuyen(@Validated @RequestBody Tuyen tuyen){
		//System.out.println(tuyen);
		List<Tuyen> listTuyen = repo.findAll();
		for(Tuyen tt : listTuyen) {
			if(tt.getMatuyen().equalsIgnoreCase(tuyen.getMatuyen())) {
				return new ResponseEntity<Object>(new responseCodeEntity(responseCode.DUPLICATE),HttpStatus.NOT_ACCEPTABLE);
			}
		}
		List<Photo> listPhoto = tuyen.getPhoto();
		try {
			repo.save(tuyen);
			for(Photo p : listPhoto) {
				p.setTuyen(tuyen);
				photoRepo.save(p);
			}
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/tuyen")
	public ResponseEntity<Object> updateTuyen(@RequestBody Tuyen tuyen)
	{
		try
		{
			if (!repo.existsById(tuyen.getMatuyen())) return new ResponseEntity<Object>(new responseCodeEntity(responseCode.NOTFOUND),HttpStatus.NOT_FOUND);
			
			Tuyen tuyen1 = repo.getById(tuyen.getMatuyen());
			tuyen1.updateTuyen(tuyen);
			
			repo.save(tuyen1);
			
			if (tuyen.getLichtrinh() != null)
			{
				repoLichtrinh.saveListLichTrinhTuyen(tuyen.getLichtrinh(), tuyen.getMatuyen());
			}
			
			if (tuyen.getHinhthucdichuyen() != null)
			{
				repoHinhThucDiChuyen.saveListHTDCTuyen(tuyen.getHinhthucdichuyen(), tuyen.getMatuyen());
			}
			
			if (tuyen.getDatkhachsan() != null)
			{
				repoDaKhachSan.saveListDatKhachSanTuyen(tuyen.getDatkhachsan(),tuyen.getMatuyen());
			}
			
			if (tuyen.getDatnhahang() != null)
			{
				repoDatNhaHang.saveListDatNhaHangTuyen(tuyen.getDatnhahang(), tuyen.getMatuyen());
			}
			if (tuyen.getPhoto() != null)
			{
				repoPhoto.saveListHinhAnhTuyen(tuyen.getPhoto(), tuyen.getMatuyen());
			}
			return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SUCCESS),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("tuyen/{id}")
	public ResponseEntity<Object> getOneTuyen(@PathVariable String id)
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
}
