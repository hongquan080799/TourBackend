package com.abc.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Dattour;
import com.abc.entity.DattourId;

public interface DatTourRepository extends JpaRepository<Dattour, DattourId> {
	@Query(value = "EXEC INSERTDATTOUR ?1,?2,?3,?4,?5,?6",nativeQuery = true)
	void insertDatTour(String matour,int makh,int trangthai,int soluong,int httt,LocalDateTime thoigian);
	
	@Query(value = "EXEC UPDATEDATTOUR ?1,?2,?3,?4,?5,?6", nativeQuery = true)
	void updateDatTour(String matour,int makh,int trangthai,int soluong,int httt, LocalDateTime thoigian);
	
	@Query(value = "EXEC DELETEDATTOUR ?1,?2,?3",nativeQuery = true)
	void deleteDatTour(String matour, int makh, LocalDateTime thoigian);




}
