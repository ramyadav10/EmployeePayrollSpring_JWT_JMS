package com.example.demo.util;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyFirstCamelRouter extends RouteBuilder{

//	@Autowired
//	private EmpayController empcon;
	
	@Override
	public void configure() throws Exception {
		//queue(timer-from-to)
		//transformation(transform/bean)
		//DataBase(log)
		from("timer:First-Timer")
//		.transform().constant("Timer is constantly running")
		.bean("getCurrentTimeBean")
		.to("log:Logging the message");
	}

	
	
}


//@Component
//class getCurrentTimeBean{
//	public String getCurrentTime() {
//		return "Time is now: "+LocalDateTime.now();
//	}
//}
