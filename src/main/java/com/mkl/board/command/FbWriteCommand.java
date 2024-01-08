package com.mkl.board.command;

import com.mkl.board.dao.FreeBoardDao;

public class FbWriteCommand {

	public void execute(String fbtitle, String fbname, String fbcontent) {
		
		FreeBoardDao freeBoardDao = new FreeBoardDao();
		
		freeBoardDao.write(fbtitle, fbname, fbcontent);
	}
}
