package com.abc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Hinhthucdichuyen;
import com.abc.entity.HinhthucdichuyenId;

public interface HinhThucDiChuyenRepository extends JpaRepository<Hinhthucdichuyen, HinhthucdichuyenId> {
	@Query(value = "EXEC INSERTHTDC ?1,?2",nativeQuery = true)
	void insertHinhThucDiChuyen(String matuyen,String mapt);
	
	@Query(value = "EXEC DELETEHTDC ?1", nativeQuery = true)
	void deleteHinhThucDiChuyenTuyen(String matuyen);
	
	default void saveListHTDCTuyen(Set<Hinhthucdichuyen> hinhthucdichuyens, String matuyen)
	{
		deleteHinhThucDiChuyenTuyen(matuyen);
		for (Hinhthucdichuyen hinhthucdichuyen:hinhthucdichuyens)
		{
			insertHinhThucDiChuyen(hinhthucdichuyen.getTuyenMatuyen(), hinhthucdichuyen.getPhuongtienMapt());
		}
	}
}
