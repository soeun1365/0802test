package com.koreait.final1.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.final1.dao.BoardDAO;
import com.koreait.final1.dto.Board;

public class UpdateBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		Board board = new Board();
		long bidx = Long.parseLong(request.getParameter("bidx"));
		board.setBidx(bidx);
		board.setBtitle(request.getParameter("title"));
		board.setBcontent(request.getParameter("content"));
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.updateBoard(board.getBidx());
		
		response.setContentType("text/html; charset=utf-8");
		try {
			if (count >  0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정성공')");
				
				response.getWriter().println("location.href='selectBoardList.do'");
				//response.getWriter().println("location.href='selectBoardByIdx.do?bidx=" + bidx + "'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('수정실패')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
