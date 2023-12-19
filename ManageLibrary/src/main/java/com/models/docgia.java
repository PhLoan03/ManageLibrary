package com.models;

public class docgia {
	private String masv;
	private String ten;
	private String email;
	private String lop;
	private String khoa;
	public docgia() {
		super();
	}
	public docgia(String masv, String ten, String email, String lop, String khoa) {
		super();
		this.masv = masv;
		this.ten = ten;
		this.email = email;
		this.lop = lop;
		this.khoa = khoa;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	
}
