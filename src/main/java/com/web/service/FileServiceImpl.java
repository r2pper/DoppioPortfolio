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
	 * ���� üũ �� psfile ���� ---> VO ����
	 */
	public DpNoticeVO fileCheck(DpNoticeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	/**
	 * ���� ����
	 */
	public void fileSave(DpNoticeVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * ���� ���� - ���� ���� ����
	 */
	public void fileSave(DpNoticeVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
			
			//���� ������ �����ϴ� ��� ����ó��
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
			// package
			/**
			 * ���� üũ �� psfile ���� ---> VO ����
			 */
			public DpPackageVO fileCheck(DpPackageVO vo) {
				
				UUID uuid = UUID.randomUUID();		
				
				if(vo != null) {
					if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
						vo.setPfile(vo.getFile1().getOriginalFilename());
						vo.setPsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
					}
				}
						
				return vo;
			}
			
			/**
			 * ���� ����
			 */
			public void fileSave(DpPackageVO vo, HttpServletRequest request) throws Exception{
				
				if(!vo.getFile1().getOriginalFilename().equals("")) {
				
					//�������� ��ġ Ȯ��
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//��������
					File file = new File(root_path + vo.getPsfile());			
					vo.getFile1().transferTo(file);
				}
					
			}
			
			/**
			 * ���� ���� - ���� ���� ����
			 */
			public void fileSave(DpPackageVO vo, HttpServletRequest request, String fname) throws Exception{
				
				if(!vo.getFile1().getOriginalFilename().equals("")) {
				
					//�������� ��ġ Ȯ��
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//��������
					File file = new File(root_path + vo.getPsfile());			
					vo.getFile1().transferTo(file);
					
					//���� ������ �����ϴ� ��� ����ó��
					File ofile = new File(root_path+fname);
					if(ofile.exists()) {
						ofile.delete();
					}
				}
			}
			
	
	//-----------------------------------------------------------------------------------------------------------------
	// board
	/**
	 * ���� üũ �� bsfile ���� ---> VO ����
	 */
	public DpBoardVO fileCheck(DpBoardVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
				vo.setBfile(vo.getFile1().getOriginalFilename());
				vo.setBsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	/**
	 * ���� ����
	 */
	public void fileSave(DpBoardVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * ���� ���� - ���� ���� ����
	 */
	public void fileSave(DpBoardVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
			
			//���� ������ �����ϴ� ��� ����ó��
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------
	// recipe
	
	
	/**
	 * ���� üũ �� rsfile ���� ---> VO ����
	 */
	public DpRecipeVO fileCheck(DpRecipeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //�������� �ϴ� ���	
				vo.setRfile(vo.getFile1().getOriginalFilename());
				vo.setRsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	
	/**
	 * ���� ����
	 */
	public void fileSave(DpRecipeVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getRsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * ���� ���� - ���� ���� ����
	 */
	public void fileSave(DpRecipeVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//�������� ��ġ Ȯ��
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//��������
			File file = new File(root_path + vo.getRsfile());			
			vo.getFile1().transferTo(file);
			
			//���� ������ �����ϴ� ��� ����ó��
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

