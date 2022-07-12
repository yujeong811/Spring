package com.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.command.MailRequestCommand;
import com.spring.mail.MimeAttachNotifier;

@Controller
public class MailController {
	@Autowired
	private MimeAttachNotifier notifier;
	
	@RequestMapping(value="/toMail", method=RequestMethod.GET)
	public void mailGet() throws Exception{}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String mailPost(MailRequestCommand mailReq, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		
		String url = "redirect:/mail/success";
		
		MultipartFile attach = mailReq.getFile();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/mail_attach");
		
		// 파일유무
		if(attach != null && !attach.isEmpty()) {
			// 파일의 크기
			if(attach.getSize() < 1024 * 1024 * 5) {
				// 파일 저장
				File file = new File(uploadPath, attach.getOriginalFilename());
				file.mkdirs();
				
				attach.transferTo(file);
			} else { // 용량초과
				url = "redirect:/mail/fail";
				rttr.addFlashAttribute("message", "첨부파일이 용량초과 입니다.");
				
				return url;
			}
		}
		
		// 메일 메세지 보내기
		try {
			notifier.sendMail(mailReq, uploadPath);
			rttr.addFlashAttribute("mailRequest", mailReq);
			
		} catch(Exception e) {
			e.printStackTrace();
			url = "redirect:/mail/fail";
			rttr.addFlashAttribute("message", "메일 보내기를 실패했습니다..");
		}
			
		return url;
	}
	
	@RequestMapping("/mail/success")
	public void mailSuccess() {}
	
	@RequestMapping("/mail/fail")
	public void mailFail() {}
}
