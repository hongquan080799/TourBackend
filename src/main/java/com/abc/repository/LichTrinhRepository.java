package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Lichtrinh;
import com.abc.entity.LichtrinhId;

public interface LichTrinhRepository extends JpaRepository<Lichtrinh, LichtrinhId> {

}
