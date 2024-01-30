package com.healthify.api.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Component
public class MessageUtility {
	
	@Value("${twilio.sid}")
	private static String ACCOUNT_SID;
	
	@Value("${twilio.token}")
	private static String AUTH_TOKEN;
	
	public boolean sendSMS(){
		
		
		return false;
		
	}
	
	public static String sendWhatsAppMessage(String mobile,String msg) {
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    Message message = Message.creator(
	      new com.twilio.type.PhoneNumber("whatsapp:+91"+mobile),
	      new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	      msg)

	    .create();
	    
	   
		
		return  message.getSid();
		
	}

}
