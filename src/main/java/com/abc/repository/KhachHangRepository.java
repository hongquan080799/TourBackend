package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Khachhang;

public interface KhachHangRepository extends JpaRepository<Khachhang,String> {

}
