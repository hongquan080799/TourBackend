package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Taikhoan;

public interface TaikhoanRepository extends JpaRepository<Taikhoan, String>{
	Taikhoan findByUsername(String username);
	
	Taikhoan findByUsernameAndStatus(String username, int status);
	
	Taikhoan findByVerificationCode(String verificationCode);
}
