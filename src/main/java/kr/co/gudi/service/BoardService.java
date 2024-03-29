package kr.co.gudi.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public ArrayList<BoardDTO> list() {		
		return dao.list();
	}

	public void write(Map<String, String> params) {
		int row = dao.write(params);
		logger.info("insert count : "+row);
	}

	public BoardDTO detail(String idx) {	
		dao.upHit(idx);
		return dao.detail(idx);
	}

	public void del(String idx) {
		dao.del(idx);
	}

}
