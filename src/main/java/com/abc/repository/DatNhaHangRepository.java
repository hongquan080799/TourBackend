package com.abc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Datnhahang;
import com.abc.entity.DatnhahangId;

public interface DatNhaHangRepository extends JpaRepository<Datnhahang, DatnhahangId> {
	@Query(value = "EXEC INSERTDATNHAHANG ?1,?2", nativeQuery =  true)
	void insertDatNhaHang(String matuyen,String manh);
	
	@Query(value = "EXEC DELETEDATNHAHANG ?1", nativeQuery =  true)
	void deleteDatNhaHangTuyen(String matuyen);
	
	default void saveListDatNhaHangTuyen(Set<Datnhahang> datnhahangs, String matuyen)
	{
		deleteDatNhaHangTuyen(matuyen);
		for (Datnhahang datnhahang:datnhahangs)
		{
			insertDatNhaHang(matuyen, datnhahang.getNhahangManh());
		}
	}
}
