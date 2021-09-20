package com.abc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dto.UserDto;
import com.abc.entity.Khachhang;
import com.abc.entity.Nhanvien;
import com.abc.entity.Taikhoan;
import com.abc.repository.TaikhoanRepository;

@RestController
@CrossOrigin
public class TaikhoanController {
	
	@Autowired 
	TaikhoanRepository taikhoanRepo;
	
	@GetMapping("/user")
	public ResponseEntity<UserDto> getUser(Principal principal) {
		Taikhoan taikhoan = taikhoanRepo.findByUsername(principal.getName());
		UserDto user = new UserDto();
		if(taikhoan != null) {
			if(taikhoan.getQuyen() == 1 ) {
				user.setUsername(taikhoan.getUsername());
				user.setDisplayname("ADMIN");
				user.setQuyen("ADMIN");
			}
			else if(taikhoan.getQuyen()  == 3) {
				Khachhang kh = taikhoan.getListKH().get(0);
				user.setUsername(taikhoan.getUsername());
				
			//	user.setDiachi("");
				user.setDisplayname(kh.getTenkh());
				user.setTen(kh.getTenkh());
				user.setPhoto(kh.getPhoto());
				user.setSdt(kh.getSdt());
				user.setGioitinh(kh.getGioitinh());
				user.setQuyen("KHACHHANG");
				user.setId(kh.getId().toString());
			}else if(taikhoan.getQuyen() == 2) {
				Nhanvien nv = taikhoan.getListNV().get(0);
				user.setUsername(taikhoan.getUsername());
				user.setTen(nv.getTennv());
				//user.setDiachi("");
				user.setDisplayname(nv.getTennv());
				user.setPhoto(nv.getPhoto());
				user.setSdt(nv.getSdt());
				user.setGioitinh(nv.getGioitinh());
				user.setQuyen("KHACHHANG");
				user.setId(nv.getManv());
			}
			return new ResponseEntity<UserDto>(user,HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(new UserDto(),HttpStatus.BAD_REQUEST);
		
	}
}
