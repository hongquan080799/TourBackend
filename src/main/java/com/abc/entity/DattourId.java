package com.abc.entity;

import java.io.Serializable;

public class DattourId implements Serializable {
	Khachhang khachhang;
    Tour tour;
    
	public Khachhang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
    
}
