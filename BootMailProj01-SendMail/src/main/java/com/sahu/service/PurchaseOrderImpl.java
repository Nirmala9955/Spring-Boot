package com.sahu.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("purchaseService")
public class PurchaseOrderImpl implements IPurchaseOrder  {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		//Calculate the bill amount
		double billAmt = 0.0;
		for (double p : prices) 
			billAmt=billAmt+p;
		String message = Arrays.toString(items)+" with prices "+Arrays.toString(prices)+" are purchased with total bill amount "+billAmt;
		//Send mail
		String status = sendMail(message, toEmails);
		return message+" ---- "+status;
	}

	private String sendMail(String message, String[] toMails) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage(); //Empty email message
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		messageHelper.setFrom(fromEmail);
		messageHelper.setCc(toMails);
		messageHelper.setSubject("Open it to know it");
		messageHelper.setSentDate(new Date());
		messageHelper.setText(message);
		//messageHelper.addAttachment("nimu.jpg", new ClassPathResource("nimu.jpg")); //place the nimu.jpg file in  src/main/resources folder
		mailSender.send(mimeMessage);
		return "Mail sent";
	}
	
}
