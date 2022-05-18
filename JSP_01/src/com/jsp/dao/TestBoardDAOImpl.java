package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.BoardDao;
import com.jsp.dataSource.OracleMybatisSqlSessionFactory;
import com.jsp.vo.Board;


public class TestBoardDAOImpl {
   private SqlSessionFactory factory = new OracleMybatisSqlSessionFactory();
   
   private BoardDao boardDAO = new BoardDaoImpl();
   
   private SqlSession session;
   
   @Before
   public void init()throws Exception{
      session = factory.openSession();
   }
   
   @After
   public void close() throws Exception{
      if(session != null) session.close();
   }
   
   @Test
   public void testSelectBoardList() throws Exception{
      List<Board> boardList = boardDAO.selectBoardList(session);
      
      Assert.assertEquals(7, boardList.size());
   }
}