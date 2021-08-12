package com.abc.converter;

import com.abc.dto.DTO_DatNhaHang;
import com.abc.entity.Datnhahang;
import com.abc.entity.Nhahang;
import com.abc.entity.Tuyen;

public class Converter_DatNhaHang {
	public static DTO_DatNhaHang convertDatNhaHangToDTO_DatNhaHang(Datnhahang datnhahang)
	{
		DTO_DatNhaHang dto_DatNhaHang = new DTO_DatNhaHang();
		
		dto_DatNhaHang.setManh(datnhahang.getNhahang().getManh());
		dto_DatNhaHang.setMatuyen(datnhahang.getTuyen().getMatuyen());
		
		return dto_DatNhaHang;
	}
	
	public static Datnhahang convertDTO_DatNhaHangToaDatNhaHang(DTO_DatNhaHang dto_DatNhaHang)
	{
		Datnhahang datnhahang = new Datnhahang();
		
		Nhahang nhahang = new Nhahang();
		nhahang.setManh(dto_DatNhaHang.getManh());
		datnhahang.setNhahang(nhahang);
		Tuyen tuyen = new Tuyen();
		tuyen.setMatuyen(dto_DatNhaHang.getMatuyen());
		datnhahang.setTuyen(tuyen);
		
		return datnhahang;
	}
}
