package com.email.api.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



@Service
public class EmailService {

	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f = false;
		
		String from="suyogdhadge27@gmail.com";
		//variable for gmail
		
		String host ="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		System.out.println("PROPERTIES"+ properties);
		
		// setting imp information
		
		//setting host
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth","true");
		
		String username="suyogdhadge27@gmail.com";
		String password="iznvlhyqfibahyln";
		
		//get the session object
		
		
		Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication passwordAuthentication() {
				return new PasswordAuthentication(username, password);
				
			}
	
		});
			
		
		session.setDebug(true);
		try {
			
			MimeMessage m = new MimeMessage(session);
			
			m.setFrom(new InternetAddress(from));
			
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			m.setSubject(subject);
			
			m.setText(message);
			
			Transport.send(m);
			
			System.out.println("Sent Successfully.............");
			
			f=true;
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return f;
	}
	
}


