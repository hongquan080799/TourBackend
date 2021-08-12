package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Taikhoan;

public interface TaiKhoanRepository extends JpaRepository<Taikhoan,String> {

}
