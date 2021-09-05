package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Tour;
import com.abc.entity.Tuyen;

public interface TourRepository extends JpaRepository<Tour, String>{

	List<Tour> findAlTourByTuyen(Tuyen tuyen);
}
