package com.koreait.final1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.final1.command.DeleteBoardCommand;
import com.koreait.final1.command.InsertBoardCommand;
import com.koreait.final1.command.SelectBoardByIdxCommand;
import com.koreait.final1.command.SelectBoardListCommand;
import com.koreait.final1.command.UpdateBoardCommand;

@Controller
public class BoardController {
	private SqlSession sqlSession;
	private SelectBoardListCommand selectBoardListCommand;
	private InsertBoardCommand insertBoardCommand;
	private SelectBoardByIdxCommand selectBoardByIdxCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	
	@Autowired
	public BoardController(SqlSession sqlSession,
			SelectBoardListCommand selectBoardListCommand,
			InsertBoardCommand insertBoardCommand,
			SelectBoardByIdxCommand selectBoardByIdxCommand,
			UpdateBoardCommand updateBoardCommand,
			DeleteBoardCommand deleteBoardCommand) {
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.selectBoardByIdxCommand = selectBoardByIdxCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
	}
	
	// method
	@GetMapping(value= "/")
	public String selectContactList(Model model) {
		return "index";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(sqlSession, model);
		return "board/boardList";
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		return "board/insertPage";
	}
	
	@GetMapping(value="insertBoard.do")
	public String insertBoard(HttpServletRequest request,
							  HttpServletResponse response,
							  Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		insertBoardCommand.execute(sqlSession, model);
		return null; 
	}
	
	@GetMapping(value="selectBoardByIdx.do")
	public String selectBoardByIdx(HttpServletRequest request,
								   HttpServletResponse response,
								   Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		selectBoardByIdxCommand.execute(sqlSession, model);
		return "board/boardView";
	}
	
	@GetMapping(value="updateBoard.do")
	public void updateBoard(HttpServletRequest request,
			   				HttpServletResponse response,
			   				Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		updateBoardCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="deleteBoard.do")
	public void deleteBoard(HttpServletRequest request,
			   				HttpServletResponse response,
			   				Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		deleteBoardCommand.execute(sqlSession, model);
	}
	
}
