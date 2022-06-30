package com.web.service;

import java.util.List;

import com.web.vo.DpCommentVO;

public interface DpCommentService extends DpObjectService{
	public List<Object> getListResult1(int startCount, int endCount, String num);
}
