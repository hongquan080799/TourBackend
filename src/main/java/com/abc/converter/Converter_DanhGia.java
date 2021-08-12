package com.abc.converter;

import com.abc.dto.DTO_DanhGia;
import com.abc.entity.Danhgia;
import com.abc.entity.Khachhang;
import com.abc.entity.Tour;

public class Converter_DanhGia {
	public static DTO_DanhGia convertDanhGiaToDTODto_DanhGia(Danhgia danhgia)
	{
		DTO_DanhGia dto_DanhGia = new DTO_DanhGia();
		
		dto_DanhGia.setDanhgia(danhgia.getDanhgia());
		dto_DanhGia.setMakh(danhgia.getKhachhang().getId());
		dto_DanhGia.setMatour(danhgia.getTour().getMatour());
		
		return dto_DanhGia;
	}
	public static Danhgia convertDTODanhGiaToDanhgia(DTO_DanhGia dto_DanhGia)
	{
		Danhgia danhgia = new Danhgia();
		
		danhgia.setDanhgia(dto_DanhGia.getDanhgia());
		Khachhang khachhang = new Khachhang();
		khachhang.setId(dto_DanhGia.getMakh());
		danhgia.setKhachhang(khachhang);
		Tour tour = new Tour();
		tour.setMatour(dto_DanhGia.getMatour());
		danhgia.setTour(tour);
		return danhgia;
	}
}
