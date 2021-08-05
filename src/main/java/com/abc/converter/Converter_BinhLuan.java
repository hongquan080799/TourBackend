package com.abc.converter;

import com.abc.dto.DTO_BinhLuan;
import com.abc.entity.Binhluan;
import com.abc.entity.Khachhang;
import com.abc.entity.Tour;

public class Converter_BinhLuan {
	public static DTO_BinhLuan convertBinhLuanToDto_BinhLuan(Binhluan binhluan)
	{
		DTO_BinhLuan dto_BinhLuan = new DTO_BinhLuan();
		
		dto_BinhLuan.setId(binhluan.getId());
		dto_BinhLuan.setMakh(binhluan.getKhachhang().getId());
		dto_BinhLuan.setMatour(binhluan.getTour().getMatour());
		dto_BinhLuan.setNoidung(binhluan.getNoidung());
		
		return dto_BinhLuan;
	}
	
	public static Binhluan convertDTO_BinhLuanToBinhluan(DTO_BinhLuan dto_BinhLuan)
	{
		Binhluan binhluan = new Binhluan();
		
		binhluan.setId(dto_BinhLuan.getId());
		Khachhang khachhang = new Khachhang();
		khachhang.setId(dto_BinhLuan.getMakh());
		binhluan.setKhachhang(khachhang);
		binhluan.setNoidung(dto_BinhLuan.getNoidung());
		Tour tour = new Tour();
		tour.setMatour(dto_BinhLuan.getMatour());
		binhluan.setTour(tour);
		
		return binhluan;
	}
}
