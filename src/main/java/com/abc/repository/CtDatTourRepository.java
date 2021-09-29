package com.abc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.CtDatTourID;
import com.abc.entity.CtDattour;

public interface CtDatTourRepository  extends JpaRepository<CtDattour, CtDatTourID>{
	
	@Query(value = "EXEC INSERTCTDATTOUR ?1,?2,?3,?4,?5", nativeQuery = true)
	void insertCtDatTour(String matour,int idnguoidat, int idkh,int loaigia,LocalDateTime thoigian);
	
	@Query(value = "EXEC DELETECTDATTOUR ?1,?2,?3",nativeQuery = true)
	void deleteCtDattourTour(String matour, int makhdat, LocalDateTime thoigian);
	
	
}
