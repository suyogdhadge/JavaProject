package com.email.api.model;

public class EmailRequest {

	private String To;
	
	private String subject;
	
	private String message;

	

	public EmailRequest(String To, String subject, String message) {
		this.To = To;
		this.subject = subject;
		this.message = message;
	}

	public EmailRequest() {
		
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		this.To = To;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "EmailRequest [To=" + To+ ", subject=" + subject + ", message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
