package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.dto.BoardDTO;
import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;
	
	@RequestMapping(value="/list")
	public String list(Model model, HttpSession session) {
		
		String page = "index";

		if(session.getAttribute("loginId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			ArrayList<BoardDTO> list = service.list();
			logger.info("list size : "+list.size());
			model.addAttribute("list", list);
			page = "list";
		}
				
		return page;
	}
	
	
	@RequestMapping(value="/writeForm")
	public String writeForm(Model model, HttpSession session) {
		String page = "index";
		if(session.getAttribute("loginId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			page = "writeForm";
		}				
		return page;
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(Model model, HttpSession session, 
			@RequestParam Map<String, String> params) {
		logger.info("params : "+params);
		String page = "index";
		
		if(session.getAttribute("loginId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			service.write(params);
			page = "redirect:/list";
		}
		
		return page;
	}
	
	@RequestMapping(value="/detail")
	public String detail(Model model, HttpSession session, 
			@RequestParam String idx) {
		
		String page = "index";
		
		if(session.getAttribute("loginId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			BoardDTO bbs = service.detail(idx);
			model.addAttribute("bbs", bbs);
			page = "detail";
		}
		
		return page;
	}
	
	@RequestMapping(value="/del")
	public String del(Model model, HttpSession session, @RequestParam String idx) {
		
		String page = "index";
		if(session.getAttribute("loginId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}else {
			page = "redirect:/list";
			service.del(idx);
		}
				
		return page;
	}











}
