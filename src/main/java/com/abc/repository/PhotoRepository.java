package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	@Query(value = "EXEC INSERTHINHANH ?1,?2",nativeQuery = true)
	void insertHinhAnh(String matuyen,String path);
	
	@Query(value = "EXEC DELETEHINHANH ?1",nativeQuery = true)
	void deleteHinhAnhTuyen(String matuyen);
	
	default void saveListHinhAnhTuyen(List<Photo> photos, String matuyen)
	{
		deleteHinhAnhTuyen(matuyen);
		for (Photo photo:photos)
		{
			insertHinhAnh(matuyen, photo.getPicture());
		}
	}
	
}
