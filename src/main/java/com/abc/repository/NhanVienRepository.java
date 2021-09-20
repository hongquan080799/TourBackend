package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Nhanvien;

public interface NhanVienRepository  extends JpaRepository<Nhanvien, String> {
	@Query(value = "select * from nhanvien nv join taikhoan tk on nv.username = tk.username where status = 1", nativeQuery = true)
	List<Nhanvien> getListNV();
}
