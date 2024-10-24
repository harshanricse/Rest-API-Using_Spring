package com.infytel.utility;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleLookUpUtility {

	private static MessageSource messageSource;

	public static void setMessageSource(MessageSource messageSource)
	{
		LocaleLookUpUtility.messageSource=messageSource;
	}
	
	public static String getLocaleMessage(String messageCode) {
		
		return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
	}

	//The below private constructor is to avoid object creation for this class from any other classes. 
	private LocaleLookUpUtility()
	{
		
	}
}
