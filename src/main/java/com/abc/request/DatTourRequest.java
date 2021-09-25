package com.abc.request;

import java.util.List;

import com.abc.dto.KhachHangCostume;

public class DatTourRequest {
	int idkh;
	String idTour;
	List<KhachHangCostume> thamgias;
	int trangthai;
	int httt;
	int soluong;
	
	public int getIdkh() {
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
	
	public List<KhachHangCostume> getThamgias() {
		return thamgias;
	}
	public void setThamgias(List<KhachHangCostume> thamgias) {
		this.thamgias = thamgias;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getHttt() {
		return httt;
	}
	public void setHttt(int httt) {
		this.httt = httt;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
