package com.email.api.controller;

import com.email.api.model.EmailRequest;
import com.email.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/welcome")
	public String welcome()
	{
		return "This is my first email api";
	}
	
	//create api to send email
	
	@RequestMapping(value="/sendemail", method = RequestMethod.POST)
	public ResponseEntity<?>sendEmail(@RequestBody EmailRequest request)
	{
		// this.emailService.sendEmail(null, null, null);
		
		System.out.println("request");
		
		
		boolean result =this.emailService.sendEmail(request.getMessage(),request.getSubject(),request.getTo());
		
		if(result) {
			return ResponseEntity.ok("Email sent succesfully");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
		}
		
		
		
	}
	
}
