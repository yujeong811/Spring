package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.QrVO;

public class qrDAOImpl implements qrDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertQr(QrVO qr) throws SQLException {
		session.update("Qr-Mapper.insertQr",qr);
	}

}
