package com.abc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.KhachHangCostume;
import com.abc.entity.CtDatTourCostume;
import com.abc.entity.CtDattour;
import com.abc.entity.Dattour;
import com.abc.entity.Khachhang;
import com.abc.entity.Taikhoan;
import com.abc.entity.Tour;
import com.abc.repository.CtDatTourCostumeRepository;
import com.abc.repository.CtDatTourRepository;
import com.abc.repository.DatTourRepository;
import com.abc.repository.KhachHangRepository;
import com.abc.repository.TaikhoanRepository;
import com.abc.repository.TourRepository;
import com.abc.request.DatTourRequest;
import com.abc.responsecode.responseCode;
import com.abc.responsecode.responseCodeEntity;

import javassist.expr.NewArray;

@RestController
@CrossOrigin
public class DatTourController {
	
	@Autowired
	DatTourRepository repo;
	
	@Autowired
	KhachHangRepository repoKhachHang;
	
	@Autowired
	TourRepository repoTour;
	
	@Autowired
	CtDatTourRepository repoCtDatTour;
	
	@Autowired
	TaikhoanRepository repoTaiKhoan;
	
	@Autowired
	CtDatTourCostumeRepository repoCtDattourCostume;
	
	
	
	@GetMapping("/dattour/{idtour}")
	public ResponseEntity<Object> getDanhSachDatTour(@PathVariable String idtour)
	{
		try
		{
			repo.findAll();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/dattour")
	public ResponseEntity<Object> datTour(Principal principal,@RequestBody DatTourRequest datTourRequest)
	{
		Taikhoan taikhoan = repoTaiKhoan.getById(principal.getName());
		
		Khachhang khDatTour = taikhoan.getListKH().get(0);
		
		try
		{
			repo.insertDatTour(datTourRequest.getIdTour(),khDatTour.getId(), datTourRequest.getTrangthai(), datTourRequest.getSoluong(),datTourRequest.getHttt());
			
			
			
			
			repoCtDatTour.deleteCtDattourTour(datTourRequest.getIdTour(), taikhoan.getListKH().get(0).getId());
			
			Khachhang khachhang;
			for (KhachHangCostume khachHangCostume :datTourRequest.getThamgias())
			{
				if (khachHangCostume.getCmnd() == null)
				{
					// tạo
					int makh = (int) System.currentTimeMillis() % 100000000;
					khachhang = new Khachhang();
					khachhang.setId(makh);
					khachhang.setTenkh(khachHangCostume.getName());
					khachhang.setCmnd(khachHangCostume.getCmnd());
					khachhang.setSdt(khachHangCostume.getSdt());
					khachhang.setEmail(khachHangCostume.getEmail());
					repoKhachHang.save(khachhang);
				}
				else
				{
					khachhang = repoKhachHang.getKhachHang(khachHangCostume.getCmnd());
					if (khachhang == null)
					{
						// tạo
						int makh = (int) System.currentTimeMillis() % 100000000;
						khachhang = new Khachhang();
						khachhang.setId(makh);
						khachhang.setTenkh(khachHangCostume.getName());
						khachhang.setCmnd(khachHangCostume.getCmnd());
						khachhang.setSdt(khachHangCostume.getSdt());
						khachhang.setEmail(khachHangCostume.getEmail());
						repoKhachHang.save(khachhang);
					}
				}
				repoCtDatTour.insertCtDatTour(datTourRequest.getIdTour(),datTourRequest.getIdkh(),khachhang.getId(), khachHangCostume.getLoaive());
			}
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("dattour/chitiet/{idkh}/{idtour}")
	public ResponseEntity<Object> getCtDatTour(@PathVariable("idkh") int idkh, @PathVariable("idtour") String idtour)
	{
		try
		{
			List<Dattour> dattours = repo.findAll();
			
			for (Dattour dattour:dattours)
			{
				if (dattour.getKhachhang().getId() == idkh && dattour.getTour().getMatour().equalsIgnoreCase(idtour))
				{
					List<CtDatTourCostume> costumes = repoCtDattourCostume.getCtDatTour(idkh, idtour);
					return new ResponseEntity<Object>(costumes,HttpStatus.OK);
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
