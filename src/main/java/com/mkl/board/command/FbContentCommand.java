package com.mkl.board.command;

import com.mkl.board.dao.FreeBoardDao;
import com.mkl.board.dto.FboardDto;

public class FbContentCommand {

	public FboardDto execute(String fbnum) {
		FreeBoardDao freeBoardDao = new FreeBoardDao();
		FboardDto fboardDto = freeBoardDao.content_view(fbnum);
		
		return fboardDto;
		
	}
}
