package com.infytel.utility;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void initializeStaticContext()
	{
		LocaleLookUpUtility.setMessageSource(context.getBean(MessageSource.class));
	}
}
