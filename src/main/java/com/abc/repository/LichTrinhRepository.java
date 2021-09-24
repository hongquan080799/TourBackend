package com.abc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Lichtrinh;
import com.abc.entity.LichtrinhId;

public interface LichTrinhRepository extends JpaRepository<Lichtrinh, LichtrinhId> {
	@Query(value = "EXEC INSERTLICHTRINH ?1,?2,?3",nativeQuery = true)
	void insertLichTrinh(String matuyen, int madiadiem, String mota);
	
	
	@Query(value = "EXEC DELETELICHTRINH ?1",nativeQuery = true)
	void deleteLichTrinhTuyen(String matuyen);
	
	
	default void saveListLichTrinhTuyen(Set<Lichtrinh> lichtrinhs,String matuyen)
	{
		deleteLichTrinhTuyen(matuyen);
		for (Lichtrinh lichtrinh:lichtrinhs)
		{
			insertLichTrinh(lichtrinh.getTuyenMatuyen(), lichtrinh.getDiadiemId(), lichtrinh.getMota());
		}
	}
}
