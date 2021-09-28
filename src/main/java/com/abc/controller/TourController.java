package com.abc.controller;

import java.io.File;
import java.util.ArrayList;
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

import com.abc.entity.CtDattour;
import com.abc.entity.Dattour;
import com.abc.entity.Khachhang;
import com.abc.entity.Tour;
import com.abc.entity.Tuyen;
import com.abc.repository.CtDatTourRepository;
import com.abc.repository.TourRepository;
import com.abc.repository.TuyenRepository;
import com.abc.response.TourResponse;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

@RestController
@CrossOrigin
public class TourController {
	
	@Autowired
	TourRepository repo;
	
	@Autowired
	CtDatTourRepository repoCtDatTour;
	
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
	
	@GetMapping("/tour/{matour}")
	public TourResponse getTourById(@PathVariable String matour) {
		Tour tour = repo.findById(matour).get();
		TourResponse tourResponse = new TourResponse();
		
		tourResponse.setMatour(tour.getMatour());
		tourResponse.setTentour(tour.getTuyen().getTentuyen());
		tourResponse.setNgaydi(tour.getTgbd());
		tourResponse.setNgayve(tour.getTgkt());
		tourResponse.setGianguoilon(tour.getGianguoilon());
		tourResponse.setGiatreem(tour.getGiatreem());
		tourResponse.setThoigian(tour.getTuyen().getThoigian());
		tourResponse.setPhoto(tour.getTuyen().getPhoto().get(0).getPicture());
		return tourResponse;
		
	}
	
//	@GetMapping("tour/{id}/danhsach")
//	public ResponseEntity<Object> getDanhSachThamGiaTour(@PathVariable String id)
//	{
//		try
//		{
//			Tour tour = repo.getById(id);
//			List<CtDattour> ctDattours = repoCtDatTour.findAll();
//			List<Khachhang> khachhangs = new ArrayList<Khachhang>();
//			for (Dattour dattour:tour.getDattour())
//			{
//				for (CtDattour ctDattour:ctDattours)
//				{
//					if (ctDattour.getKhachhang().getId() == dattour.getKhachhang().getId() && ctDattour.getMatour().equalsIgnoreCase(id))
//					{
//						khachhangs.add(ctDattour.getKhachhang());
//					}
//					khachhangs.add(dattour.getKhachhang());
//				}
//			}
//			
//			return new  ResponseEntity<Object>(khachhangs,HttpStatus.OK);
//			
//		}
//		catch (Exception e) 
//		{
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
//				
//	}
	
	
	@PostMapping("/hongquan")
	public String getFile(@Validated @RequestParam("file") MultipartFile hinhanh) {
		System.out.println(hinhanh.toString());
		return "ok";
	}
}
