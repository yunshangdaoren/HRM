package com.lqs.hrm.service;

/**
 * 邮件Service接口
 * @author Administrator
 *
 */
public interface MailService {
	
	/**
	 * 发送文本邮件
	 * @param to 邮件接收人
	 * @param subject 邮件主题 
	 * @param content 邮件内容
	 */
	void sendSimpleMail(String to, String subject, String contentText);
	
	/**
	 * 发送HTML邮件
	 * @param to
	 * @param subject
	 * @param contentText
	 */
	void sendHtmlMail(String to, String subject, String contentText);
	
	/**
	 * 发送带附件的邮件
	 * @param to
	 * @param subject
	 * @param contentText
	 * @param filePath
	 */
	void sendAttachmentsMail(String to, String subject, String contentText, String filePath);
}
