package com.models;

public class sach {
	private int masach;
	private String tensach;
	private int slsach;
	private String ngaynhap;
	private String mathuthu;
	private String theloai;
	public sach() {
		super();
	}
	public sach(int masach, String tensach, int slsach, String ngaynhap, String mathuthu, String theloai) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.slsach = slsach;
		this.ngaynhap = ngaynhap;
		this.mathuthu = mathuthu;
		this.theloai = theloai;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSlsach() {
		return slsach;
	}
	public void setSlsach(int slsach) {
		this.slsach = slsach;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getMathuthu() {
		return mathuthu;
	}
	public void setMathuthu(String mathuthu) {
		this.mathuthu = mathuthu;
	}
	public String getTheloai() {
		return theloai;
	}
	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}
	
	
}
