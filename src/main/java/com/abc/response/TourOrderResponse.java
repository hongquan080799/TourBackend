package com.abc.response;

import java.util.Date;
import java.util.List;

import com.abc.entity.Khachhang;

public class TourOrderResponse {
	String matour;
	String tentour;
	Integer soluong;
	Date thoigian;
	String nguoidat;
	Integer id_nguoidat;
	List<Khachhang> listKH;
	
	
	public TourOrderResponse(Object[] list) {
		super();
		this.matour = (String) list[0];
		this.tentour = (String) list[1];
		this.soluong = (Integer) list[2];
		this.thoigian = (Date) list[3];
		this.nguoidat = (String) list[4];
		this.id_nguoidat = (Integer) list[5];
	}
	
	public List<Khachhang> getListKH() {
		return listKH;
	}

	public void setListKH(List<Khachhang> listKH) {
		this.listKH = listKH;
	}

	
	public Integer getId_nguoidat() {
		return id_nguoidat;
	}

	public void setId_nguoidat(Integer id_nguoidat) {
		this.id_nguoidat = id_nguoidat;
	}

	public String getMatour() {
		return matour;
	}
	public void setMatour(String matour) {
		this.matour = matour;
	}
	public String getTentour() {
		return tentour;
	}
	public void setTentour(String tentour) {
		this.tentour = tentour;
	}
	public Integer getSoluong() {
		return soluong;
	}
	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}
	public Date getThoigian() {
		return thoigian;
	}
	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}
	public String getNguoidat() {
		return nguoidat;
	}
	public void setNguoidat(String nguoidat) {
		this.nguoidat = nguoidat;
	}
	
	
}
