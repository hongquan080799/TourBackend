package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMail {
	@Autowired
	JavaMailSender javaMailSender;
	
	@RequestMapping("/send")
	public String sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("hongquan080799@gmail.com");
		msg.setSubject("cmn");
		msg.setText("hongqua");
		javaMailSender.send(msg);
		return "ok";
	}

}
