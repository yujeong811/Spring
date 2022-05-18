package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.vo.Board;

public interface BoardDao {
	List<Board> selectBoardList(SqlSession session) throws Exception;
	List<Board> selectBoardList(SqlSession session,Criteria cri) throws Exception;
	
	// 일반 리스트 전체 개수
	int selectBoardListCount(SqlSession session) throws Exception;
}
