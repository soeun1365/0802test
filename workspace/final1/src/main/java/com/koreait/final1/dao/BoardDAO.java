package com.koreait.final1.dao;

import java.util.List;

import com.koreait.final1.dto.Board;

public interface BoardDAO {
	public int countBoard();
	public List<Board> boardList();
	public int insertBoard(Board board);
	public Board selectBoardByIdx(long bidx);
	public int updateBoard(long bidx);
	public int deleteBoard(long bidx);
}
