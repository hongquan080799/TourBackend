package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Tour;

public interface TourRepository extends JpaRepository<Tour, String>{

}
