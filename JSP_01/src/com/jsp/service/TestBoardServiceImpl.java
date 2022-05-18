package com.jsp.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jsp.vo.Board;

public class TestBoardServiceImpl {
	private BoardService service = new BoardServiceImpl();
	
	@Test
	public void testGetMemberList()throws Exception{
		List<Board> boardList = service.getBoardList();
		
		Assert.assertEquals(7, boardList.size());
	}
}
