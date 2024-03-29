package kr.co.gudi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, 
			@RequestParam String id, @RequestParam String pw) {
		String page = "index";
		
		boolean success = service.login(id,pw);
		logger.info("success : "+success);
		
		if(success) {
			// page = "list";				<- list.jsp
			// page = "redirect:/list";	<- controller 의 /list 요청을 해라
			page = "redirect:/list";
			session.setAttribute("loginId", id);
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인 하세요!");
		}
		
		return page;
	}

}
