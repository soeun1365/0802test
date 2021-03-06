package com.koreait.final1.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.final1.dao.BoardDAO;
import com.koreait.final1.dto.Board;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		Board board = new Board();
		board.setBwriter(request.getParameter("writer"));
		board.setBtitle(request.getParameter("title"));
		if(request.getParameter("content") != null) {
			board.setBcontent(request.getParameter("content"));	
		}else {
			board.setBcontent(null);
		}
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.insertBoard(board);
		
		response.setContentType("text/html; charset=utf-8");
		try {
			if (count >  0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('삽입성공')");
				response.getWriter().println("location.href='selectBoardList.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('삽입실패')");
				response.getWriter().println("location.href='selectBoardList.do'");
				response.getWriter().println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
