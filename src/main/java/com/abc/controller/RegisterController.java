package com.abc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Khachhang;
import com.abc.entity.Taikhoan;
import com.abc.repository.TaikhoanRepository;
import com.abc.request.RegisterRequest;
import com.abc.response.CustomResponse;
import com.abc.service.MailService;

import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin
public class RegisterController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	TaikhoanRepository repo;
	
	@Autowired
	MailService mailService;
	
	
	@PostMapping("/register")
	public ResponseEntity<CustomResponse> getRegister(HttpServletRequest httpServletRequest ,@Validated @RequestBody RegisterRequest request){
		Taikhoan tk = new Taikhoan();
		Khachhang kh = new Khachhang();
		tk.setUsername(request.getUsername());
		tk.setPassword(passwordEncoder.encode(request.getPassword()));
		tk.setQuyen(3);
		kh.setTenkh(request.getTen());
		kh.setDiachi(request.getDiachi());
		kh.setEmail(request.getEmail());
		kh.setGioitinh(request.getGioitinh());
		kh.setPhoto(request.getPhoto());
		kh.setSdt(request.getSdt());
		kh.setTaikhoan(tk);
		tk.setListKH(Arrays.asList(kh));
		
		String verificationCode = tk.getUsername() + RandomString.make(50);
		tk.setVerificationCode(verificationCode);
		String urlSite = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getServletPath(), "");
		System.out.println(urlSite);
		try {
			repo.save(tk);
			mailService.sendVerificationMail(kh.getEmail(),kh.getTenkh() , urlSite, tk.getUsername());
			return new ResponseEntity<CustomResponse>(new CustomResponse("Your account have been created successfully !!! !!!"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CustomResponse>(new CustomResponse("Failed to create an account !!!"),HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/verify")
	public void verificationTaikhoan(@RequestParam("code") String verificationCode,HttpServletResponse response) {
		String redirectURL = "localhost:3000/login";
		Taikhoan tk = repo.findByVerificationCode(verificationCode);
		tk.setStatus(1);
		try {
			repo.save(tk);
			response.sendRedirect(redirectURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
