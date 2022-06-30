package com.web.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.web.vo.DpBoardVO;
import com.web.vo.DpNoticeVO;
import com.web.vo.DpPackageVO;
import com.web.vo.DpRecipeVO;

public class FileServiceImpl {
		
	// NOTICE------------------------------------------------------------------------------
	/**
	 * 파일 체크 후 psfile 생성 ---> VO 리턴
	 */
	public DpNoticeVO fileCheck(DpNoticeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	/**
	 * 파일 저장
	 */
	public void fileSave(DpNoticeVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * 파일 저장 - 기존 파일 삭제
	 */
	public void fileSave(DpNoticeVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
			
			//기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
			// package
			/**
			 * 파일 체크 후 psfile 생성 ---> VO 리턴
			 */
			public DpPackageVO fileCheck(DpPackageVO vo) {
				
				UUID uuid = UUID.randomUUID();		
				
				if(vo != null) {
					if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
						vo.setPfile(vo.getFile1().getOriginalFilename());
						vo.setPsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
					}
				}
						
				return vo;
			}
			
			/**
			 * 파일 저장
			 */
			public void fileSave(DpPackageVO vo, HttpServletRequest request) throws Exception{
				
				if(!vo.getFile1().getOriginalFilename().equals("")) {
				
					//파일저장 위치 확인
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//파일저장
					File file = new File(root_path + vo.getPsfile());			
					vo.getFile1().transferTo(file);
				}
					
			}
			
			/**
			 * 파일 저장 - 기존 파일 삭제
			 */
			public void fileSave(DpPackageVO vo, HttpServletRequest request, String fname) throws Exception{
				
				if(!vo.getFile1().getOriginalFilename().equals("")) {
				
					//파일저장 위치 확인
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//파일저장
					File file = new File(root_path + vo.getPsfile());			
					vo.getFile1().transferTo(file);
					
					//기존 파일이 존재하는 경우 삭제처리
					File ofile = new File(root_path+fname);
					if(ofile.exists()) {
						ofile.delete();
					}
				}
			}
			
	
	//-----------------------------------------------------------------------------------------------------------------
	// board
	/**
	 * 파일 체크 후 bsfile 생성 ---> VO 리턴
	 */
	public DpBoardVO fileCheck(DpBoardVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
				vo.setBfile(vo.getFile1().getOriginalFilename());
				vo.setBsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	/**
	 * 파일 저장
	 */
	public void fileSave(DpBoardVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * 파일 저장 - 기존 파일 삭제
	 */
	public void fileSave(DpBoardVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
			
			//기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------
	// recipe
	
	
	/**
	 * 파일 체크 후 rsfile 생성 ---> VO 리턴
	 */
	public DpRecipeVO fileCheck(DpRecipeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
				vo.setRfile(vo.getFile1().getOriginalFilename());
				vo.setRsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	
	/**
	 * 파일 저장
	 */
	public void fileSave(DpRecipeVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getRsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * 파일 저장 - 기존 파일 삭제
	 */
	public void fileSave(DpRecipeVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getRsfile());			
			vo.getFile1().transferTo(file);
			
			//기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

