package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Dattour;
import com.abc.entity.DattourId;

public interface DatTourRepository extends JpaRepository<Dattour, DattourId> {

}
