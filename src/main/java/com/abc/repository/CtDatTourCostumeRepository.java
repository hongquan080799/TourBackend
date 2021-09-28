package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.CtDatTourCostume;

public interface CtDatTourCostumeRepository extends JpaRepository<CtDatTourCostume, Integer> {
	@Query(value = "EXEC SP_GIACHITIETDATTOUR ?1,?2", nativeQuery = true)
	List<CtDatTourCostume> getCtDatTour(int makh, String matour);
}
