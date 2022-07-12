package com.spring.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.dto.QrVO;
import com.jsp.service.qrService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private qrService qrService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/qrqr")
	public String qrqr() {
		return "qrqr";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public void insert(String data) throws Exception {
		
		logger.info("insert호출");
		logger.info("data : " + data);
		
		
		//멤버아이디를
		QrVO vo = new QrVO();
		vo.setTest(data);
				
		qrService.insertQr(vo);
	}

}
