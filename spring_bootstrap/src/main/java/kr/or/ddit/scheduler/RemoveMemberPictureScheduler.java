package kr.or.ddit.scheduler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dao.MemberDAOBean;

public class RemoveMemberPictureScheduler {
	private MemberDAOBean memberDAO;
	public void setMemberDAOBean(MemberDAOBean memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	private String picturePath;
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(RemoveMemberPictureScheduler.class);
	
	public void removePicture() throws Exception {
		File dir = new File(picturePath);
		File[] files = dir.listFiles();
		
		if (files != null) {
			for (File file : files) {
				if(memberDAO.selectMemberByPicture(file.getName()) == null) {
					file.delete();
					logger.info("delete file : " + file.getName());
				}
			}
		}
	}
}
