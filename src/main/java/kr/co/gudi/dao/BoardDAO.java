package kr.co.gudi.dao;

import java.util.ArrayList;
import java.util.Map;

import kr.co.gudi.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> list();

	int write(Map<String, String> params);

	BoardDTO detail(String idx);

	void upHit(String idx);

	void del(String idx);

}
