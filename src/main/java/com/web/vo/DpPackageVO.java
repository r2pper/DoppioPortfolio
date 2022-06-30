package com.web.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DpPackageVO {
	
	//패키지 옵션
		String popid, popname, popprice;
		int poprice;
		
		public String getPopid() {
			return popid;
		}
		public void setPopid(String popid) {
			this.popid = popid;
		}
		public String getPopname() {
			return popname;
		}
		public void setPopname(String popname) {
			this.popname = popname;
		}
		public String getPopprice() {
			return popprice;
		}
		public void setPopprice(String popprice) {
			this.popprice = popprice;
		}
		public int getPoprice() {
			return poprice;
		}
		public void setPoprice(int poprice) {
			this.poprice = poprice;
		}

	
	String pnum, pname, ptitle, psubtitle, pcontent, pdate,
	pfile, psfile, pcate, pprice, pstock;
	
	public String getPsubtitle() {
		return psubtitle;
	}
	public void setPsubtitle(String psubtitle) {
		this.psubtitle = psubtitle;
	}
	
	
	int rno, phits;
	CommonsMultipartFile file1;
	
	
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
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
	public String getPcate() {
		return pcate;
	}
	public void setPcate(String pcate) {
		this.pcate = pcate;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPstock() {
		return pstock;
	}
	public void setPstock(String pstock) {
		this.pstock = pstock;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPhits() {
		return phits;
	}
	public void setPhits(int phits) {
		this.phits = phits;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
}
