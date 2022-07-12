package com.jsp.dao;

import java.sql.SQLException;

import com.jsp.dto.QrVO;

public interface qrDAO {
	public void insertQr(QrVO qr) throws SQLException;
}
