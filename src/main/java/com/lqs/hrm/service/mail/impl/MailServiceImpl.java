package com.lqs.hrm.service.mail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lqs.hrm.service.mail.MailService;

@Service
public class MailServiceImpl implements MailService {
	//private final Logger loger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.from}")
	private String from;

	/**
	 * 发送简单文本邮件
	 */
	@Override
	public void sendSimpleMail(String to, String subject, String contentText) {
		//创建SimpleMailMessage对象
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件发送人
		message.setFrom(from);
		//邮件接收人
		message.setTo(to);
		//邮件主题
		message.setSubject(subject);
		//邮件内容
		message.setText(contentText);
		//发送邮件
		mailSender.send(message);
	}

	/**
	 * 发送HTML邮件
	 */
	@Override
	public void sendHtmlMail(String to, String subject, String contentText) {
		
	}

	/**
	 * 发送带附件的邮件
	 */
	@Override
	public void sendAttachmentsMail(String to, String subject, String contentText, String filePath) {
		
	}
}
