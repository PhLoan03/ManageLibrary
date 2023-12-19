package com.models;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class muontra {
	private int mamuontra;
	private String masv;
	private int masach;
	private String ngaymuon;
	private String trangthai;
	private String mathuthu;
	public muontra() {
		super();
	}
	public muontra(int mamuontra, String masv, int masach, String mathuthu, String ngaymuon, String trangthai) {
		super();
		this.mamuontra = mamuontra;
		this.masv = masv;
		this.masach = masach;
		this.mathuthu = mathuthu;
		this.ngaymuon = ngaymuon;
		this.trangthai = trangthai;
	}
	public int getMamuontra() {
		return mamuontra;
	}
	public void setMamuontra(int mamuontra) {
		this.mamuontra = mamuontra;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public String getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getMathuthu() {
		return mathuthu;
	}
	public void setMathuthu(String mathuthu) {
		this.mathuthu = mathuthu;
	}
	public boolean isQuaHan() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date ngayMuonDate;
	    try {
	        ngayMuonDate = sdf.parse(ngaymuon);
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(ngayMuonDate);
	        calendar.add(Calendar.MONTH, 6); // Cộng thêm 6 tháng
	        Date hanTraDate = calendar.getTime();
	        return new Date().after(hanTraDate); // So sánh với thời điểm hiện tại
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return false; // Xử lý nếu có lỗi parse ngày
	    }
	}
	
}
