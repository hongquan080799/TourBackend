package com.abc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DattourId implements Serializable {
	Khachhang khachhang;
    Tour tour;
    LocalDateTime thoigian;
    
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
	public LocalDateTime getThoigian() {
		return thoigian;
	}
	public void setThoigian(LocalDateTime thoigian) {
		this.thoigian = thoigian;
	}
    
}
