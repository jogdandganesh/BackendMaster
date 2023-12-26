package com.shopvista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	
	@Autowired
	private MailSender sender;
	
	
	@Override
	public void sendMails(String to, String sub, String msg) {
		System.out.println("   "+to+"  "+sub+"  "+msg);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("ganesh.198j@gmail.com");
		mail.setTo(to);
		mail.setSubject(sub);
		mail.setText("Your Shopvista UserId :"+to+" \n and password is :"+msg+"\n Thank you for shopping with us");
		
		sender.send(mail);
		System.out.println("Mail Sent");
	}
}
