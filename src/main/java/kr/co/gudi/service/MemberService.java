package kr.co.gudi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MemberDAO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired MemberDAO dao;
	
	public boolean login(String id, String pw) {		
		String loginId = dao.login(id,pw);				
		return loginId != null;
	}

}
