package com.abc.converter;

import com.abc.dto.DTO_DiaDiem;
import com.abc.entity.Diadiem;

public class Converter_DiaDiem {
	public static DTO_DiaDiem convertDiaDiemToDto_DiaDiem(Diadiem diadiem)
	{
		DTO_DiaDiem dto_DiaDiem = new DTO_DiaDiem();
		
		dto_DiaDiem.setId(diadiem.getId());
		dto_DiaDiem.setTendiadiem(diadiem.getTendiadiem());
		dto_DiaDiem.setMota(diadiem.getMota());
		
		return dto_DiaDiem;
	}
	
	public static Diadiem convertDTO_DiaDiemToDiadiem(DTO_DiaDiem dto_DiaDiem)
	{
		Diadiem diadiem = new Diadiem();
		
		diadiem.setId(dto_DiaDiem.getId());
		diadiem.setTendiadiem(dto_DiaDiem.getTendiadiem());
		diadiem.setMota(dto_DiaDiem.getMota());
		
		return diadiem;
	}
}
