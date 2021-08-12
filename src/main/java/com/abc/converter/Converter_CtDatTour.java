package com.abc.converter;

import com.abc.dto.DTO_CtDatTour;
import com.abc.entity.CtDattour;
import com.abc.entity.Khachhang;

public class Converter_CtDatTour {
	public static DTO_CtDatTour convertCtDatTourToDto_CtDatTour(CtDattour ctDattour)
	{
		DTO_CtDatTour dto_CtDatTour = new DTO_CtDatTour();
		
		dto_CtDatTour.setId_khachhang((ctDattour.getIdNguoidat()));
		dto_CtDatTour.setCmnd(ctDattour.getKhachhang().getCmnd());
		dto_CtDatTour.setLoaigia(ctDattour.getLoaigia());
		dto_CtDatTour.setMatour(ctDattour.getMatour());
		
		return dto_CtDatTour;
	}
	
	public static CtDattour convertDTO_CtDaTourToCtDattour(DTO_CtDatTour dto_CtDatTour)
	{
		CtDattour ctDattour = new CtDattour();
		
		ctDattour.setIdNguoidat(dto_CtDatTour.getId_khachhang());
		Khachhang khachhang = new Khachhang();
		khachhang.setCmnd(dto_CtDatTour.getCmnd());
		ctDattour.setKhachhang(khachhang);
		ctDattour.setLoaigia(dto_CtDatTour.getLoaigia());
		ctDattour.setMatour(dto_CtDatTour.getMatour());
		
		return ctDattour;
	}
}
