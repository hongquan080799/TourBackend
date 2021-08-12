package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Datkhachsan;
import com.abc.entity.DatkhachsanId;

public interface DatKhachSanRepository extends JpaRepository<Datkhachsan, DatkhachsanId> {

}
