package web.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//자바로 메일보내기
public class MailSend {
	public static void main(String[] args) {

		String host = "smtp.naver.com";
		final String user = "pueen9999@naver.com";
		final String password = "RLAgusehd12!@";

		String to = "sylove532@naver.com";

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			message.setSubject("개똥멍청이 ㅎㅇ");

			// Text
			message.setText("잘좀하자");

			// send the message
			Transport.send(message);
			System.out.println("메시지가 발송 되었습니다.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}