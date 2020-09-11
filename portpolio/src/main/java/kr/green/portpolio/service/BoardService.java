package kr.green.portpolio.service;

import java.util.ArrayList;

import kr.green.portpolio.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

}
