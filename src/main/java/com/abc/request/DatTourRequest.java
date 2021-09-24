package com.abc.request;

import java.util.List;

public class DatTourRequest {
	Integer idkh;
	String idTour;
	List<Integer> thamgias;
	
	
	public Integer getIdkh() {
		return idkh;
	}
	public void setIdkh(Integer idkh) {
		this.idkh = idkh;
	}
	public String getIdTour() {
		return idTour;
	}
	public void setIdTour(String idTour) {
		this.idTour = idTour;
	}
	public List<Integer> getThamgias() {
		return thamgias;
	}
	public void setThamgias(List<Integer> thamgias) {
		this.thamgias = thamgias;
	}

}
