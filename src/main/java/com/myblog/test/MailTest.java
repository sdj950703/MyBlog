package com.myblog.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {

	// 发件人地址
	private static String fromAddress = "15236330494@163.com";

	// 收件人地址
	private static String toAddress = "1069498942@qq.com";

	// 发件人邮箱名 @符号前面的所有字符
	private static String mailUserName = "15236330494";

	// 发件人邮箱密码 一般是注册时候的密码，有可能会是邮箱的授权码或者是独立密码
	private static String mailPassWord = "s950703";

	public static MimeMessage getMimeMessage(Session session) {
		// 代表一个邮件的一个抽象对象，比如把一个文件抽象成File对象
		// session是邮件的发送环境
		MimeMessage msg = new MimeMessage(session);

		try {
			// 设置发件人地址
			msg.setFrom(new InternetAddress(fromAddress));

			// 设置收件人地址
			// TO 表示普通发送
			// CC 表示抄送 比如你写好了一篇项目进度报告，报告要交给项目小组长，再另外发送一份给项目经理
			// BCC 表示密送 = 盲抄送 收件人看不到其他收件人的地址 隐私保护
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					toAddress));

			// 设置邮件标题
			msg.setSubject("回复邮件", "UTF-8");

			// 设置邮件内容
			msg.setContent("纯文本回复", "text/html;charset=UTF-8");

			// 设置邮件发送时间
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return msg;

	}

	public static void sendMessage() {

		Properties props = new Properties();

		props.setProperty("mail.smtp.auth", "true");

		props.setProperty("mail.transport.protocol", "smtp");

		// smtp.qq.com smtp.sina.com
		props.setProperty("mail.smtp.host", "smtp.163.com");
		
		//生成邮件的发送环境
		Session session=Session.getInstance(props);
		
		session.setDebug(true);
		
		//获取邮件实例
		Message msg=getMimeMessage(session);
		
		try {
			//发送通道
			Transport transport=session.getTransport();
			
			transport.connect(mailUserName, mailPassWord);
			
			transport.sendMessage(msg, msg.getAllRecipients());
			
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			sendMessage();
		}
		
	}

}
