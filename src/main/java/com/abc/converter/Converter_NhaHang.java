package com.abc.converter;

import com.abc.dto.DTO_NhaHang;
import com.abc.entity.Nhahang;

public class Converter_NhaHang {
	public static DTO_NhaHang convertNhahangToDto_NhaHang(Nhahang nhahang)
	{
		DTO_NhaHang dto_NhaHang = new DTO_NhaHang();
		
		dto_NhaHang.setManh(nhahang.getManh());
		dto_NhaHang.setTennh(nhahang.getTennh());
		
		return dto_NhaHang;
	}
	
	public static Nhahang convertDTO_NhahangToNhahang(DTO_NhaHang dto_NhaHang)
	{
		Nhahang nhahang = new Nhahang();
		
		nhahang.setManh(dto_NhaHang.getManh());
		nhahang.setTennh(dto_NhaHang.getTennh());
		
		return nhahang;
	}
}
