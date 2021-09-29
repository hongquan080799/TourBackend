package com.abc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;

public class CtDatTourID  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	java.lang.String matour;
    java.lang.String id_nguoidat;
    Khachhang khachhang;
    LocalDateTime thoigian;
    
    
	public LocalDateTime getThoigian() {
		return thoigian;
	}
	public void setThoigian(LocalDateTime thoigian) {
		this.thoigian = thoigian;
	}
	public java.lang.String getMatour() {
		return matour;
	}
	public void setMatour(java.lang.String matour) {
		this.matour = matour;
	}
	public java.lang.String getCmndNguoidat() {
		return id_nguoidat;
	}
	public void setCmndNguoidat(java.lang.String cmndNguoidat) {
		this.id_nguoidat = cmndNguoidat;
	}
	public Khachhang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}
	public CtDatTourID() {
		super();
	}
    
    
}
