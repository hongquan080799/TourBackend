package com.abc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Datkhachsan;
import com.abc.entity.DatkhachsanId;

public interface DatKhachSanRepository extends JpaRepository<Datkhachsan, DatkhachsanId> {
	@Query(value = "EXEC INSERTDATKHACHSAN ?1,?2", nativeQuery = true)
	void  insertDatKhachSan(String matuyen, String maks);
	
	@Query(value = "EXEC DELETEDATKHACHSAN ?1", nativeQuery = true)
	void deleteDatKhachSan(String matuyen);
	
	default void saveListDatKhachSanTuyen(Set<Datkhachsan> datkhachsans, String matuyen)
	{
		deleteDatKhachSan(matuyen);
		for (Datkhachsan datkhachsan:datkhachsans)
		{
			insertDatKhachSan(matuyen,datkhachsan.getKhachsanMaks());
		}
	}
}
