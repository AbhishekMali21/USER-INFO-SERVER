package com.util;

import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.entity.User;

public class EmailUtil {
	private static final String EMAIL_USERNAME = "gate2022goal@gmail.com";
	private static final String EMAIL_APP_PASSWORD = "piybjdtonzfyiiwt";

	private EmailUtil() {
	}

	public static void sendEmail(User savedUser) throws MessagingException {
		String subject = "Your Information is Saved Successfully !!";
		String contentWeb = generateHtmlContent(savedUser);
		String recipientEmail = savedUser.getEmail();
		Session session = propertyDetails();
		Message message = extracted(subject, contentWeb, recipientEmail, session);
		Transport.send(message);
	}

	private static Session propertyDetails() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_APP_PASSWORD);
			}
		});
		session.setDebug(true);
		return session;
	}

	private static Message extracted(String subject, String contentWeb, String recipientEmail, Session session)
			throws MessagingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(EMAIL_USERNAME));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
		message.setSubject(subject);
//		message.setText(content);
		message.setContent(contentWeb, "text/html");
		return message;
	}

	private static String generateHtmlContent(User savedUser) {
//		String content = "Hello,\n\nThe saved information is:\n\n" + "Name: " + savedUser.getName() + "\n" + "Email: "
//		+ savedUser.getEmail() + "\n" + "Date of Birth: "
//		+ savedUser.getDob().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" + "Phone Number: "
//		+ savedUser.getPhoneNo() + "\n\n" + "Thank you.";
		return "<html><head><style>h3 { font-weight: bold; } body { font-family: Arial, sans-serif; }</style></head><body>"
				+ "<h3>Hello, Thank you for providing the following information: </h3>" + "<p><strong>Name:</strong> "
				+ savedUser.getName() + "</p>" + "<p><strong>Email:</strong> " + savedUser.getEmail() + "</p>"
				+ "<p><strong>Date of Birth:</strong> "
				+ savedUser.getDob().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "</p>"
				+ "<p><strong>Phone Number:</strong> " + savedUser.getPhoneNo() + "</p>"
				+ "<h3>We have successfully saved your details. If you have any further inquiries or need assistance, please feel free to reach out to us.</h3>"
				+ "<h3>Wishing you a wonderful day filled with joy and success!</h3>" + "</body></html>";
	}
}
