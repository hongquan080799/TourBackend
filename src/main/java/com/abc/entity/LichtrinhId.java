package com.abc.entity;

import java.io.Serializable;

public class LichtrinhId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tuyen tuyen;
	Diadiem diadiem;
  
	public Tuyen getTuyen() {
		return tuyen;
	}
	public void setTuyen(Tuyen tuyen) {
		this.tuyen = tuyen;
	}
	public Diadiem getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(Diadiem diadiem) {
		this.diadiem = diadiem;
	}
  
}
