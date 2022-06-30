package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpPackageDAO;
import com.web.vo.DpPackageVO;

public class DpPackageServiceImpl implements DpPackageService {
	
	@Autowired
	private DpPackageDAO packageDao;
	
	@Override
	public int getInsertResult(Object obj) {
		DpPackageVO vo = (DpPackageVO)obj;
		return packageDao.insert(vo);
	}
	
	@Override
	public int getListCount() {
		return packageDao.execTotalCount();
	}
	
	@Override
	public void getUpdateHits(String pnum) {
		packageDao.updateHits(pnum);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount){
		return packageDao.select(startCount, endCount);
	}
	
	@Override
	public Object getContent(String pnum) {
		return packageDao.select(pnum);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		DpPackageVO vo = (DpPackageVO)obj;
		return packageDao.update(vo);
	}
	
	@Override public int getDeleteResult(String pnum) {
		return packageDao.delete(pnum);
	}
	
	@Override
	public String getFilename(String pnum) {
		return packageDao.selectFile(pnum);
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount, String cate) {
		return packageDao.select(startCount, endCount, cate);
	}
	
	@Override
	public List<Object> getOplist(String popid) {
		return packageDao.oplist(popid);
	}
	
	public int getTotalPage(String pcate) {
		return packageDao.execTotalCount(pcate);
	}
}
