package com.abc.entity;

import java.io.Serializable;

public class PhutrachTourId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tour tour;
    Nhanvien nhanvien;
    
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public Nhanvien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}
    
}
