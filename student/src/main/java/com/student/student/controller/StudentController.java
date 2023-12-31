package com.student.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.student.vo.StudentVO;

public interface StudentController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ResponseEntity addMember(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception;
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView modMember(String id, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView login(@ModelAttribute("member")StudentVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception;
	ModelAndView updateMember(@ModelAttribute("member")StudentVO member, MultipartHttpServletRequest multipartrequest,
			HttpServletResponse response) throws Exception;
}
