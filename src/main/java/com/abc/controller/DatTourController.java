package com.abc.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
import com.abc.response.TourOrderResponse;
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
	
	@Autowired
	EntityManager entityManager;
	
	@GetMapping("/dattour")
	public ResponseEntity<Object> getDanhSachDatTour()
	{
		String from = "from TOUR t join dbo.DATTOUR dt on t.MATOUR = dt.MATOUR "
				+ "JOIN dbo.TUYEN tn on tn.MATUYEN  = t.MATUYEN  "
				+ "JOIN  dbo.KHACHHANG  kh on dt.MAKH = kh.ID ";
		String select = "select dt.MATOUR as matour , tn.TENTUYEN as tentour, dt.SOLUONG as soluong , dt.THOIGIAN as thoigian , kh.TENKH , kh.id  ";
		String from_kh = "from Khachhang where id in (select id_khachhang from ct_dattour where matour = ?1 and id_nguoidat = ?2 and abs(datediff(millisecond, thoigian, ?3)) < 1000)";
		String select_kh = "select * ";
		try
		{			
			
			Query query = entityManager.createNativeQuery(select + from);
			List<TourOrderResponse> listTour = new ArrayList<>();
			List<?> list = query.getResultList();
			for(Object l : list) {
				Object[] listOb = (Object[]) l;
				TourOrderResponse t = new TourOrderResponse(listOb);
				Query queryKH = entityManager.createNativeQuery(select_kh + from_kh, Khachhang.class);
				queryKH.setParameter(1, t.getMatour());
				queryKH.setParameter(2, t.getId_nguoidat());
				queryKH.setParameter(3, t.getThoigian());
				List<Khachhang> listKH = queryKH.getResultList();
				t.setListKH(listKH);
				listTour.add(t);
			}
			return new ResponseEntity<Object>(listTour,HttpStatus.OK);
			
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
		try
		{
			Taikhoan taikhoan = repoTaiKhoan.getById(principal.getName());
			LocalDateTime thoigian = LocalDateTime.now();
			datTourRequest.setIdkh(taikhoan.getListKH().get(0).getId());
			datTourRequest.setThoigian(thoigian);
			repo.insertDatTour(datTourRequest.getIdTour(),datTourRequest.getIdkh(), datTourRequest.getTrangthai(), datTourRequest.getSoluong(),datTourRequest.getHttt(),datTourRequest.getThoigian());
			
				
			
			repoCtDatTour.deleteCtDattourTour(datTourRequest.getIdTour(), taikhoan.getListKH().get(0).getId(),datTourRequest.getThoigian());
			
			Khachhang khachhang;
			if(datTourRequest.getThamgias().size() != 0)
			{
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
							khachhang = new Khachhang();
							khachhang.setTenkh(khachHangCostume.getName());
							khachhang.setCmnd(khachHangCostume.getCmnd());
							khachhang.setSdt(khachHangCostume.getSdt());
							khachhang.setEmail(khachHangCostume.getEmail());
							khachhang = repoKhachHang.save(khachhang);
						}
					}
					repoCtDatTour.insertCtDatTour(datTourRequest.getIdTour(),datTourRequest.getIdkh(),khachhang.getId(), 1,datTourRequest.getThoigian());
				}
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
	
	
	@GetMapping("/dattour/self")
	public ResponseEntity<Object> getDatTourByMakh(Principal principal)
	{
		Taikhoan tk = repoTaiKhoan.findByUsername(principal.getName());
		Integer makh = tk.getListKH().get(0).getId();
		String from = "from TOUR t join dbo.DATTOUR dt on t.MATOUR = dt.MATOUR "
				+ "JOIN dbo.TUYEN tn on tn.MATUYEN  = t.MATUYEN  "
				+ "JOIN  dbo.KHACHHANG  kh on dt.MAKH = kh.id "
				+ "WHERE kh.id = ?1";
		String select = "select dt.MATOUR as matour , tn.TENTUYEN as tentour, dt.SOLUONG as soluong , dt.THOIGIAN as thoigian , kh.TENKH , kh.id  ";
		String from_kh = "from Khachhang where id in (select id_khachhang from ct_dattour where matour = ?1 and id_nguoidat = ?2 and abs(datediff(millisecond, thoigian, ?3)) < 1000)";
		String select_kh = "select * ";
		try
		{			
			
			Query query = entityManager.createNativeQuery(select + from);
			query.setParameter(1, makh);
			List<TourOrderResponse> listTour = new ArrayList<>();
			List<?> list = query.getResultList();
			for(Object l : list) {
				Object[] listOb = (Object[]) l;
				TourOrderResponse t = new TourOrderResponse(listOb);
				Query queryKH = entityManager.createNativeQuery(select_kh + from_kh, Khachhang.class);
				queryKH.setParameter(1, t.getMatour());
				queryKH.setParameter(2, t.getId_nguoidat());
				queryKH.setParameter(3, t.getThoigian());
				List<Khachhang> listKH = queryKH.getResultList();
				t.setListKH(listKH);
				listTour.add(t);
			}
			return new ResponseEntity<Object>(listTour,HttpStatus.OK);
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(new responseCodeEntity(responseCode.SERVERERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
