package com.abc.converter;

import com.abc.dto.DTO_LichTrinh;
import com.abc.entity.Diadiem;
import com.abc.entity.Lichtrinh;
import com.abc.entity.Tuyen;

public class Converter_LichTrinh {
	public static DTO_LichTrinh convertLichTrinhToDTOLichTrinh(Lichtrinh lichtrinh)
	{
		DTO_LichTrinh dto_LichTrinh = new DTO_LichTrinh();
		
		dto_LichTrinh.setMatuyen(lichtrinh.getTuyen().getMatuyen());
		dto_LichTrinh.setMadiadiem(lichtrinh.getDiadiem().getId());
		
		return dto_LichTrinh;
	}
	
	public static Lichtrinh convertDTO_LichTrinhToLichtrinh(DTO_LichTrinh dto_LichTrinh)
	{
		Lichtrinh lichtrinh = new Lichtrinh();
		
		Tuyen tuyen = new Tuyen();
		tuyen.setMatuyen(dto_LichTrinh.getMatuyen());
		lichtrinh.setTuyen(tuyen);
		Diadiem diadiem = new Diadiem();
		diadiem.setId(dto_LichTrinh.getMadiadiem());
		lichtrinh.setDiadiem(diadiem);
		
		return lichtrinh;
	}
}
