package com.jsp.service;

import java.sql.SQLException;

import com.jsp.dao.qrDAO;
import com.jsp.dto.QrVO;

public class qrServiceImpl implements qrService {
	private qrDAO qrDAO;
	public void setQrDAO(qrDAO qrDAO) {
		this.qrDAO = qrDAO;
	}
	
	@Override
	public void insertQr(QrVO qr) throws SQLException {
		qrDAO.insertQr(qr);
	}

}
