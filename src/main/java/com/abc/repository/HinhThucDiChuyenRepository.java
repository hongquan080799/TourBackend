package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Hinhthucdichuyen;
import com.abc.entity.HinhthucdichuyenId;

public interface HinhThucDiChuyenRepository extends JpaRepository<Hinhthucdichuyen, HinhthucdichuyenId> {

}
