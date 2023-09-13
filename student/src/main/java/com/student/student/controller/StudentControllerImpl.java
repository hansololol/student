package com.student.student.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.student.service.StudentService;
import com.student.student.vo.StudentVO;
import com.student.student.vo.SubjectVO;

@Controller("studentController")
public class StudentControllerImpl implements StudentController {
	private static String ARTICLE_IMAGE_REPO = "C:/board/article_image";
		@Autowired
		private StudentService studentService;
		@Autowired
		private StudentVO studentVO;
		
		@RequestMapping(value = {"/", "/main.do"}, method = RequestMethod.GET)
		private ModelAndView main(HttpServletRequest request, HttpServletResponse response)throws Exception{
			//String viewName=(String)request.getAttribute("viewName");
			//System.out.println(viewName + "메인 뷰네임 출력");
			ModelAndView mav = new ModelAndView("/main");
			return mav;
			
		}
		 
		@Override
		@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
		public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			//String viewName=getViewName(request);
			/* logger.info("viewName : " + viewName); */
			/* logger.debug("viewName : " + viewName); */
			List memberList=studentService.listMembers();
			ModelAndView mav = new ModelAndView("/member/listMembers");
			mav.addObject("memberList", memberList);
			mav.addObject("admin", "admin");
			return mav;
		}

		@Override
		@RequestMapping(value = "/member/addMember.do", method=RequestMethod.POST)
		@ResponseBody
		public ResponseEntity addMember(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			
			multipartRequest.setCharacterEncoding("UTF-8");
			Map<String, Object> articleMap=new HashMap<String, Object>();
			Enumeration enu = multipartRequest.getParameterNames();
			while(enu.hasMoreElements()) {
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				articleMap.put(name, value);
			}
			String articleNO = (String)articleMap.get("id");
			String imageFileName=upload(multipartRequest);
			articleMap.put("imageFileName", imageFileName);
			String message;
			ResponseEntity resEnt=null;
			HttpHeaders responseHeaders=new HttpHeaders();
			
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			try {
				studentService.addMember(articleMap);
				
				if(imageFileName != null && imageFileName.length() !=0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO +"/" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
				message="<script>"
						+ " alert('회원가입에 성공하였습니다.');"
						+ " location.href='"
						+ multipartRequest.getContextPath()
						+ "/member/loginForm.do'; "
						+ "</script>";
				resEnt=new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}catch(Exception e) {
				File srcFile=new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
				srcFile.delete();
				message="<script>"
						+ " alert('추가 중 오류가 발생했습니다.');"
						+ " location.href='"
						+ multipartRequest.getContextPath()
						+ "/member/memberForm.do';"
						+ "</script>";
				resEnt=new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				e.printStackTrace();
			}
			
			return resEnt;
		}
			
		private String upload(MultipartHttpServletRequest multiparRequest) throws Exception {
			String imageFileName=null;
			Iterator<String> fileNames=multiparRequest.getFileNames();
			while(fileNames.hasNext()) {
				String fileName=fileNames.next();
				MultipartFile mFile = multiparRequest.getFile(fileName);
				imageFileName=mFile.getOriginalFilename();
		
				File file = new File(ARTICLE_IMAGE_REPO+"/"+"temp"+"/"+fileName);
				if(mFile.getSize()!=0) {
			if(!file.exists()) {
				file.getParentFile().mkdirs();
				mFile.transferTo(new File(ARTICLE_IMAGE_REPO+"/"+"temp"+"/"+imageFileName));
				}
			}
	}
	return imageFileName;
}
		
		@Override
		@RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
		public ModelAndView removeMember(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			
			studentService.removeMember(id);
			ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
			return mav;
		}
		@Override
		@RequestMapping(value = "/member/modMember.do", method = RequestMethod.GET)
		public ModelAndView modMember(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			StudentVO student = (StudentVO)session.getAttribute("member");
			String viewName=getViewName(request);
			studentVO = new StudentVO();
			studentVO= studentService.selectMemberById1(id);
			ModelAndView mav=new ModelAndView();
			mav.setViewName(viewName);
			mav.addObject("member", studentVO);
			return mav;
		}
		
		@RequestMapping(value = "/member/addSubject.do", method=RequestMethod.GET)
		public ModelAndView addMember(@ModelAttribute("subject") SubjectVO subjectVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			StudentVO member = (StudentVO)session.getAttribute("member");
			String id=member.getId();
			subjectVO.setId(id);
			SubjectVO result=studentService.addSubject(subjectVO);
			ModelAndView mav = new ModelAndView();
			mav.addObject("subject", result);
			mav.setViewName("/member/resultSubject");
			return mav;
		}
		@RequestMapping(value = "/member/resultSubject.do", method=RequestMethod.GET)
		public ModelAndView resultSubject(@ModelAttribute("subject") SubjectVO subjectVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			ModelAndView mav = new ModelAndView();
			String id=null;
			StudentVO member;
			SubjectVO subject;
			if(request.getParameter("id")==null) {
				HttpSession session=request.getSession();
				member= (StudentVO)session.getAttribute("member");
				id = member.getId();
				if(studentService.selectSubject(id)!=null) {
				subject = studentService.selectSubject(id);
				mav.addObject("subject", subject);
				}else {
				mav.addObject("subject", "null");
				}
			}else{
				id = request.getParameter("id");
				member= studentService.selectMemberById1(id);
				subject = studentService.selectSubject(id);
				mav.addObject("subject", subject);
				mav.addObject("member", member);
			}
			mav.setViewName("/member/resultSubject");
			return mav;
		}
		
			
		@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
		public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			String viewName=getViewName(request);
			ModelAndView mav=new ModelAndView();
			mav.setViewName(viewName);
			return mav;
		}
		private String getViewName(HttpServletRequest request)throws Exception{
			String contextPath = request.getContextPath();
			String uri=(String)request.getAttribute("javax.servlet.include.request_uri");
			if(uri==null || uri.trim().equals("")) {
				uri=request.getRequestURI();
			}
			int begin=0;
			if(!((contextPath==null)||("".equals(contextPath)))) {
				begin=contextPath.length();
			}
			int end;
			if(uri.indexOf(";")!=-1) {
				end=uri.indexOf(";");
			}else if(uri.indexOf("?")!=-1) {
				end=uri.indexOf("?");
			}else {
				end=uri.length();
			}
			String fileName =uri.substring(begin, end);
			if(fileName.indexOf(".")!=-1) {
				fileName=fileName.substring(0, fileName.lastIndexOf("."));
			}
			if(fileName.lastIndexOf("/")!=-1) {
				fileName=fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
			}
			return fileName;
		}

		@Override
		@RequestMapping(value = "/member/updateMember.do", method = RequestMethod.POST)
		public ModelAndView updateMember(@ModelAttribute("member") StudentVO member, MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			multipartRequest.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("utf-8");
			System.out.println(member.getId()+"아이디 값 확인");
			String imageFileName=upload(multipartRequest);
			System.out.println(imageFileName +"이미지 파일 명 도착 출력");
			try {
				
				if(imageFileName != null && imageFileName.length() !=0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO +"/" + member.getId());
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
			}catch (Exception e) {
						e.printStackTrace();
					}
			member.setImageFileName(imageFileName);
			studentService.updateMember(member);
			String id= member.getId();
			ModelAndView mav = new ModelAndView("redirect:/member/resultSubject.do");
			mav.addObject("id", id);
			return mav;
		}

		@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
		public ModelAndView login(@ModelAttribute("member")StudentVO member, RedirectAttributes rAttr, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				response.setCharacterEncoding("utf-8");
				HttpSession session = request.getSession();
				String action = (String)session.getAttribute("action");
				System.out.println(action + "action 출력");
				studentVO = studentService.login(member);
				ModelAndView mav = new ModelAndView();
			if(studentVO != null) {
				//HttpSession session = request.getSession();
				session.setAttribute("member", studentVO);
				session.setAttribute("isLogOn", true);
				if(studentVO.getId().equals("admin")) {
					session.setAttribute("admin", "admin");
					mav.setViewName("redirect:/member/listMembers.do?admin=admin");
				}else {
				mav.setViewName("redirect:/member/resultSubject.do");
				}
			}else {
				rAttr.addAttribute("result", "loginFailed");
				mav.setViewName("redirect:/member/loginForm.do");
			}
			return mav;
		}

		@Override
		@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
		public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			session.removeAttribute("member");
			session.removeAttribute("isLogOn");
			session.removeAttribute("admin");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/main.do");
			return mav;
		}

	}

