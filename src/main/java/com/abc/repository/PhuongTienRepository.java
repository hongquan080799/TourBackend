package com.abc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Hinhthucdichuyen;
import com.abc.entity.Phuongtien;

public interface PhuongTienRepository extends JpaRepository<Phuongtien,String> {
	
}
