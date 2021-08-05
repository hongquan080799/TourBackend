package com.abc.entity;

import java.io.Serializable;

public class DatkhachsanId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Khachsan khachsan;
    Tuyen tuyen;
    
	public Khachsan getKhachsan() {
		return khachsan;
	}
	public void setKhachsan(Khachsan khachsan) {
		this.khachsan = khachsan;
	}
	public Tuyen getTuyen() {
		return tuyen;
	}
	public void setTuyen(Tuyen tuyen) {
		this.tuyen = tuyen;
	}
    
    
}
