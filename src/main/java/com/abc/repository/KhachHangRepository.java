package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Khachhang;
import com.abc.entity.Nhanvien;

public interface KhachHangRepository extends JpaRepository<Khachhang,Integer> {
	@Query(value = "select * from khachhang nv join taikhoan tk on nv.username = tk.username where status = 1", nativeQuery = true)
	List<Khachhang> getListKH();
	
	@Query(value = "SELECT * FROM KHACHHANG WHERE CMND = ?1", nativeQuery = true)
	Khachhang getKhachHang(String cmnd);
}
