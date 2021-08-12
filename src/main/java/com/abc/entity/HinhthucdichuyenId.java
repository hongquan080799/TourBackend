package com.abc.entity;

import java.io.Serializable;

public class HinhthucdichuyenId implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Phuongtien phuongtien;
     Tuyen tuyen;
     
	public Phuongtien getPhuongtien() {
		return phuongtien;
	}
	public void setPhuongtien(Phuongtien phuongtien) {
		this.phuongtien = phuongtien;
	}
	public Tuyen getTuyen() {
		return tuyen;
	}
	public void setTuyen(Tuyen tuyen) {
		this.tuyen = tuyen;
	}
     
}
