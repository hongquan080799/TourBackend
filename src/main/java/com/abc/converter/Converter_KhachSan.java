package com.abc.converter;

import com.abc.dto.DTO_KhachSan;
import com.abc.entity.Khachsan;

public class Converter_KhachSan {
	public static DTO_KhachSan convertKhachSanToDTO_KhachSan(Khachsan khachsan)
	{
		DTO_KhachSan dto_KhachSan = new DTO_KhachSan();
		
		dto_KhachSan.setMaks(khachsan.getMaks());
		dto_KhachSan.setTenks(khachsan.getTenks());
		
		return dto_KhachSan;
	}
	
	public static Khachsan convertDTO_KhachSanToKhachsan(DTO_KhachSan dto_KhachSan)
	{
		Khachsan khachsan = new Khachsan();
		
		khachsan.setMaks(dto_KhachSan.getMaks());
		khachsan.setTenks(dto_KhachSan.getTenks());
		
		return khachsan;
	}
}
