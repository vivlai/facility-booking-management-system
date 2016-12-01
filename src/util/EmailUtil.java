package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {
	public static void sendNotification(String recipientEmail, String subjectField, String emailContent) {
		final String username = "ooad5448@gmail.com";
		final String password = "ooad5448!";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
		try {
	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipientEmail));
			message.setSubject(subjectField);
			message.setText(emailContent);
	
			Transport.send(message);
	
			System.out.println("email sent successfully");
	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}