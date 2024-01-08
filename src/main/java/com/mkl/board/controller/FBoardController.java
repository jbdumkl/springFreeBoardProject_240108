package com.mkl.board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkl.board.command.FbContentCommand;
import com.mkl.board.command.FbWriteCommand;
import com.mkl.board.command.FblistCommand;
import com.mkl.board.dao.FreeBoardDao;
import com.mkl.board.dto.FboardDto;

@Controller
public class FBoardController {

//	DataSource dataSource;
	
	@RequestMapping(value = "/write_form")
	public String write_form() {
			return "write_form";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request) {
		
		String fbtitle = request.getParameter("fbtitle");
		String fbname = request.getParameter("fbname");
		String fbcontent = request.getParameter("fbcontent");
		
		FbWriteCommand command = new FbWriteCommand();
		
		command.execute(fbtitle, fbname, fbcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		FblistCommand command = new FblistCommand();
		ArrayList<FboardDto> dtos = command.execute();
		
		model.addAttribute("fboardDtos", dtos);
	
		return "list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		String fbnum = request.getParameter("fbnum");//클릭한 글번호
		
		FbContentCommand command = new FbContentCommand();
		FboardDto fboardDto = command.execute(fbnum);
		model.addAttribute("fboardDto", fboardDto);
		
		return "content_view";
	}
}
