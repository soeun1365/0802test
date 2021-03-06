package com.koreait.final1.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.final1.dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		long bidx = Long.parseLong(request.getParameter("bidx"));
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.deleteBoard(bidx);
		
		response.setContentType("text/html; charset=utf-8");
		try {
			if (count >  0) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('삭제성공')");
				response.getWriter().println("location.href='selectBoardList.do'");
				response.getWriter().println("</script>");
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('삭제실패')");
				response.getWriter().println("history.back()");
				response.getWriter().println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
