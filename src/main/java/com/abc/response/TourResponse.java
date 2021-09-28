package com.abc.response;

import java.time.LocalDateTime;
import java.util.Date;

public class TourResponse {
	String tentour;
	String matour;
	LocalDateTime ngaydi;
    LocalDateTime ngayve;
	String thoigian;
	Double gianguoilon;
	Double giatreem;
	String photo;
	public String getTentour() {
		return tentour;
	}
	public LocalDateTime getNgaydi() {
		return ngaydi;
	}
	public void setTentour(String tentour) {
		this.tentour = tentour;
	}
	public String getMatour() {
		return matour;
	}
	public void setMatour(String matour) {
		this.matour = matour;
	}
	
	
	public LocalDateTime getNgayve() {
		return ngayve;
	}
	public void setNgayve(LocalDateTime ngayve) {
		this.ngayve = ngayve;
	}
	public void setNgaydi(LocalDateTime ngaydi) {
		this.ngaydi = ngaydi;
	}
	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public Double getGianguoilon() {
		return gianguoilon;
	}
	public void setGianguoilon(Double gianguoilon) {
		this.gianguoilon = gianguoilon;
	}
	public Double getGiatreem() {
		return giatreem;
	}
	public void setGiatreem(Double giatreem) {
		this.giatreem = giatreem;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
