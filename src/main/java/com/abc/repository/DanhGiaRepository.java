package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Danhgia;
import com.abc.entity.DanhgiaId;

public interface DanhGiaRepository extends JpaRepository<Danhgia, DanhgiaId> {

}
