package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Nhanvien;

public interface NhanVienRepository  extends JpaRepository<Nhanvien, String> {

}
