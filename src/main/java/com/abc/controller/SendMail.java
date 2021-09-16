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
		msg.setTo("vanthanhnguyen43@gmail.com");
		msg.setSubject("This is subject");
		msg.setText("This is content");
		javaMailSender.send(msg);
		return "ok";
	}

}
