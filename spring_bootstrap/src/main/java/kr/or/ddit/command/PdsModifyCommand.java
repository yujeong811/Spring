package kr.or.ddit.command;

import com.jsp.dto.PdsVO;

public class PdsModifyCommand extends PdsRegistCommand{
	private String pno;
	private String[] deleteFile;
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(String[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public PdsVO toPdsVo() {
		PdsVO pds = super.toPdsVo();
		pds.setPno(Integer.parseInt(this.pno));
		
		return pds;
	}
}
