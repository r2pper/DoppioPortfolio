package com.web.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DpRecipeVO {
	
	String rnum, rname, rtitle, rcontent1,rcontent2, rdate, rfile, rsfile, rcate, rurl;
	int rhits, rno;
	CommonsMultipartFile file1;
	
	
	public String getRcontent2() {
		return rcontent2;
	}
	public void setRcontent2(String rcontent2) {
		this.rcontent2 = rcontent2;
	}
	
	public String getRurl() {
		return rurl;
	}
	public void setRurl(String rurl) {
		this.rurl = rurl;
	}	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRcontent1() {
		return rcontent1;
	}
	public void setRcontent1(String rcontent1) {
		this.rcontent1 = rcontent1;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRfile() {
		return rfile;
	}
	public void setRfile(String rfile) {
		this.rfile = rfile;
	}
	public String getRsfile() {
		return rsfile;
	}
	public void setRsfile(String rsfile) {
		this.rsfile = rsfile;
	}
	
	public String getRcate() {
		return rcate;
	}
	public void setRcate(String rcate) {
		this.rcate = rcate;
	}
	public int getRhits() {
		return rhits;
	}
	public void setRhits(int rhits) {
		this.rhits = rhits;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
}
