package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Datnhahang;
import com.abc.entity.DatnhahangId;

public interface DatNhaHangRepository extends JpaRepository<Datnhahang, DatnhahangId> {

}
