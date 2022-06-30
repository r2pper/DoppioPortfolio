package com.web.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DpNoticeVO {
	String nnum, ntitle, ncontent, id, ndate, nfile, nsfile, searchType, keyword;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	int rno, nhits;
	CommonsMultipartFile file1;
	public String getNnum() {
		return nnum;
	}
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNfile() {
		return nfile;
	}
	public void setNfile(String nfile) {
		this.nfile = nfile;
	}
	public String getNsfile() {
		return nsfile;
	}
	public void setNsfile(String nsfile) {
		this.nsfile = nsfile;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNhits() {
		return nhits;
	}
	public void setNhits(int nhits) {
		this.nhits = nhits;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
}
