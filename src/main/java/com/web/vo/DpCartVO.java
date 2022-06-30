package com.web.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DpCartVO {
	
	String ptitle, pcontent, pfile, psfile, pprice, popid, popprice;
	
	public String getPopprice() {
		return popprice;
	}
	public void setPopprice(String popprice) {
		this.popprice = popprice;
	}
	public String getPopid() {
		return popid;
	}
	public void setPopid(String popid) {
		this.popid = popid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPfile() {
		return pfile;
	}
	public void setPfile(String pfile) {
		this.pfile = pfile;
	}
	public String getPsfile() {
		return psfile;
	}
	public void setPsfile(String psfile) {
		this.psfile = psfile;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	
	
	
	
	
	String  canum, pnum, id, cadate, cacount, mnum;
	
	
	public String getMnum() {
		return mnum;
	}
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public String getCanum() {
		return canum;
	}
	public void setCanum(String canum) {
		this.canum = canum;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCadate() {
		return cadate;
	}
	public void setCadate(String cadate) {
		this.cadate = cadate;
	}
	public String getCacount() {
		return cacount;
	}
	public void setCacount(String cacount) {
		this.cacount = cacount;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	int rno;
	
}