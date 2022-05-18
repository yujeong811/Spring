package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.Board;

public class BoardDaoImpl implements BoardDao{
	@Override
	public List<Board> selectBoardList(SqlSession session) throws Exception {
		List<Board> boardList = null;
		try {
			boardList = session.selectList("Member-Mapper.selectBoardList");
		} catch(Exception e) {
			//에러처리
			throw e;
		} finally {
			if(session != null) session.close();
		}
		return boardList;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<Board> BoardList = session.selectList("Member-Mapper.selectBoardList",null,rowBounds);
		
		return BoardList;
	}

	@Override
	public int selectBoardListCount(SqlSession session) throws Exception {
		int totalCount = session.selectOne("Member-Mapper.selectBoardListCount");
		
		return totalCount;
	}	
}