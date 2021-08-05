package com.abc.converter;

import com.abc.dto.DTO_DatKhachSan;
import com.abc.entity.Datkhachsan;
import com.abc.entity.Khachsan;
import com.abc.entity.Tuyen;

public class Converter_DatKhachSan {
	public static DTO_DatKhachSan convertDatKhachSanToDTO_DatKhachSan(Datkhachsan datkhachsan)
	{
		DTO_DatKhachSan dto_DatKhachSan = new DTO_DatKhachSan();
		
		dto_DatKhachSan.setMaks(datkhachsan.getKhachsan().getMaks());
		dto_DatKhachSan.setMatuyen(datkhachsan.getTuyen().getMatuyen());
		
		return dto_DatKhachSan;
	}
	
	public static Datkhachsan convertDTO_DatKhachSanToDatkhachsan(DTO_DatKhachSan dto_DatKhachSan)
	{
		Datkhachsan datkhachsan = new Datkhachsan();
		
		Khachsan khachsan = new Khachsan();
		khachsan.setMaks(dto_DatKhachSan.getMaks());
		datkhachsan.setKhachsan(khachsan);
		Tuyen tuyen = new Tuyen();
		tuyen.setMatuyen(dto_DatKhachSan.getMatuyen());
		datkhachsan.setTuyen(tuyen);
		
		return datkhachsan;
	}
}
