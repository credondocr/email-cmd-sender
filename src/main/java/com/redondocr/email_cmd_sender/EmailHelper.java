package com.redondocr.email_cmd_sender;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;

public class EmailHelper {

	Properties emailProperties;

	Session mailSession;

	MimeMessage emailMessage;

	public void configureServerProperties(final String propertiesPath) {
		this.emailProperties = System.getProperties();
		InputStreamReader in = null;

		try {
			in = new InputStreamReader(
					new FileInputStream(
							StringUtils.isNoneEmpty(propertiesPath) ? "email.properties"
									: propertiesPath), "UTF-8");
			this.emailProperties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void createEmailMessage(final String[] toEmails,
			final String subject, final String content, final String attachpath)
			throws AddressException, MessagingException {

		this.mailSession = Session.getDefaultInstance(this.emailProperties,
				null);
		this.emailMessage = new MimeMessage(this.mailSession);

		for (String toEmail : toEmails) {
			this.emailMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(toEmail.trim()));
		}

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(content, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		if (!StringUtils.isEmpty(attachpath)) {
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachpath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachpath);
		}
		multipart.addBodyPart(messageBodyPart);
		this.emailMessage.setContent(multipart);
		this.emailMessage.setSubject(subject);

	}

	public void sendEmail() throws MessagingException {
		String emailHost = this.emailProperties.getProperty("mail.smtp.host");
		String fromUser = this.emailProperties.getProperty("mail.smtp.user");
		String fromUserEmailPassword = this.emailProperties
				.getProperty("mail.smtp.password");
		Transport transport = this.mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(this.emailMessage,
				this.emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");

	}

}
