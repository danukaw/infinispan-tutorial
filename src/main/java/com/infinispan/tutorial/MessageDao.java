package com.infinispan.tutorial;

import javax.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MessageDao {

	public List<Message> getMessages(){
		List<Message> message = new ArrayList<Message>();
		for (int a =0 ; a < 20 ; a++) {
			message.add(new Message(String.valueOf(a), "Message "+ a));
		}
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		return message;
		
	}
	public List<Employee> getEmployees(){
		List<Employee> employee = new ArrayList<Employee>();
		for (int a =0 ; a < 20 ; a++) {
			employee.add(new Employee(String.valueOf(a), "Employee "+ a));
		}
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		return employee;
		
	}
}


