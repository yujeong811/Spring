package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dto.QrVO;

public interface qrService {
	public void insertQr(QrVO qr) throws SQLException;
}
