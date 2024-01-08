package com.mkl.board.command;

import java.util.ArrayList;

import com.mkl.board.dao.FreeBoardDao;
import com.mkl.board.dto.FboardDto;

public class FblistCommand {

	public ArrayList<FboardDto> execute() {
		FreeBoardDao freeBoardDao = new FreeBoardDao();
		ArrayList<FboardDto> dtos = freeBoardDao.list();
		
		return dtos;
	}
}
