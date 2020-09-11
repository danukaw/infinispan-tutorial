package com.infinispan.tutorial;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.remoting.transport.Address;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.infinispan.tutorial.*;
import com.infinispan.tutorial.config.*;

@ApplicationScoped
public class MessageService {
	
	private static final String CACHE_KEY_01 = "replicated";	
	
	
	@Inject
	MessageDao messageDea;
	
	Cache<String, List<Message>>  messageCache;

	public MessageService() {
		
	}
	
	@Inject
	public MessageService(EmbeddedCacheManager cacheManeger) {
		
		cacheManeger.addListener(new EventListener());		
		
		this.messageCache = cacheManeger.getCache("replicated");
		
	}
	
	public List<Message> getMesseages(){
		
		List<Message> user01Messges = messageCache.get("user_01");
		List<Message> employees = messageCache.get("employee_01");

		if(user01Messges == null) {

			user01Messges = messageDea.getMessages();
			messageCache.put("user_01", user01Messges);
			
			System.out.println("User 01 Message size ///////////////////////////////////////////////////");		
		} else if (user01Messges != null) {
			
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			 
			 Message message01 = user01Messges.get(0);
			 message01.setTimestamp(timestamp.toString());
			 
			 user01Messges.add(message01);
			 
			
			messageCache.put("user_01", user01Messges);
		}
		
		if(employees == null) {
			
			List<Message> employeeMesge = new ArrayList<Message>();
			employeeMesge.add(new Message("empID", "Danuka Wijetunge"));
			messageCache.reput("employee_01", employeeMesge);
			
			System.out.println("Employees Message size \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		}
		
		return user01Messges;
	}
}
