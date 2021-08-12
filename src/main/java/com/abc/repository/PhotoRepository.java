package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

}
