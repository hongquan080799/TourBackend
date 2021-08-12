package com.abc.entity;

import java.io.Serializable;

public class DatnhahangId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Nhahang nhahang;
    Tuyen tuyen;
    
	public Nhahang getNhahang() {
		return nhahang;
	}
	public void setNhahang(Nhahang nhahang) {
		this.nhahang = nhahang;
	}
	public Tuyen getTuyen() {
		return tuyen;
	}
	public void setTuyen(Tuyen tuyen) {
		this.tuyen = tuyen;
	}
    
    
}
