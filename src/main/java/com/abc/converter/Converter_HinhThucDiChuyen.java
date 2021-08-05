package com.abc.converter;

import com.abc.dto.DTO_HinhThucDiChuyen;
import com.abc.entity.Hinhthucdichuyen;
import com.abc.entity.Phuongtien;
import com.abc.entity.Tuyen;

public class Converter_HinhThucDiChuyen {
	public static DTO_HinhThucDiChuyen convertHinhthucdichuyenTODto_HinhThucDiChuyen(Hinhthucdichuyen hinhthucdichuyen)
	{
		DTO_HinhThucDiChuyen dto_HinhThucDiChuyen = new DTO_HinhThucDiChuyen();
		
		dto_HinhThucDiChuyen.setMapt(hinhthucdichuyen.getPhuongtien().getMapt());
		dto_HinhThucDiChuyen.setMatuyen(hinhthucdichuyen.getTuyen().getMatuyen() );
		
		return dto_HinhThucDiChuyen;
	}
	
	public static Hinhthucdichuyen convertDTO_HinhThucDiChuyenToHinhthucdichuyen(DTO_HinhThucDiChuyen dto_HinhThucDiChuyen)
	{
		Hinhthucdichuyen hinhthucdichuyen = new Hinhthucdichuyen();
		
		Phuongtien phuongtien = new Phuongtien();
		phuongtien.setMapt(dto_HinhThucDiChuyen.getMapt());
		hinhthucdichuyen.setPhuongtien(phuongtien);
		Tuyen tuyen = new Tuyen();
		tuyen.setMatuyen(dto_HinhThucDiChuyen.getMatuyen());
		hinhthucdichuyen.setTuyen(tuyen);
		
		return hinhthucdichuyen;
	}
}

