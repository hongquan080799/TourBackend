package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.CtDatTourID;
import com.abc.entity.CtDattour;

public interface CtDatTourRepository  extends JpaRepository<CtDattour, CtDatTourID>{

}
