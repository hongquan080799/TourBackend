package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.PhutrachTour;
import com.abc.entity.PhutrachTourId;

public interface PhuTrachRepository  extends JpaRepository<PhutrachTour,PhutrachTourId> {

}
