package com.abc.converter;

import com.abc.dto.DTO_DatTour;
import com.abc.entity.Dattour;
import com.abc.entity.Khachhang;
import com.abc.entity.Tour;

public class Converter_DatTour {
	public static DTO_DatTour convertDatTourToDTODto_DatTour(Dattour dattour)
	{
		DTO_DatTour dto_DatTour = new DTO_DatTour();
		
		dto_DatTour.setMakh(dattour.getKhachhang().getId());
		dto_DatTour.setMatour(dattour.getTour().getMatour());
		dto_DatTour.setTrangthai(dattour.getTrangthai());
		dto_DatTour.setHttt(dattour.getHttt());
		dto_DatTour.setSoluong(dattour.getSoluong());
		
		return dto_DatTour;
	}
	
	public static Dattour convertDTO_DatTourToDattour(DTO_DatTour dto_DatTour)
	{
		Dattour dattour = new Dattour();
		
		Khachhang khachhang = new Khachhang();
		khachhang.setId(dto_DatTour.getMakh());
		dattour.setKhachhang(khachhang);
		Tour tour = new Tour();
		tour.setMatour(dto_DatTour.getMatour());
		dattour.setTrangthai(dto_DatTour.getTrangthai());
		dattour.setHttt(dto_DatTour.getHttt());
		dattour.setSoluong(dto_DatTour.getSoluong());
		
		return dattour;
	}
}
