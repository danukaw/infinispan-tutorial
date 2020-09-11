package com.infinispan.tutorial.config;

import java.util.List;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryExpired;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryExpiredEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStarted;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStopped;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStartedEvent;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStoppedEvent;

import com.infinispan.tutorial.Message;

@Listener
public class EventListener {

	@CacheStarted
	public void logDetails(CacheStartedEvent event) {
		System.out.println("****////////// Cache started *****/////////////////");
		System.out.println(event.getType()+ "Cache Name" + event.getCacheName());
	}
	@CacheStopped
	public void logDetails(CacheStoppedEvent event) {
		System.out.println("****////////// Cache stoped ****//////////////////");
		System.out.println(event.getType());
	}
	@CacheEntryRemoved
	public void logDetails(CacheEntryRemovedEvent event) {
		System.out.println("****////////// Cache removed ****//////////////////" + event.getKey());
		System.out.println(event.getType());
	}
	@CacheEntryCreated
	public void logDetails(CacheEntryCreatedEvent<String, List<Message>> event) {
		System.out.println("****////////// Cache Entry created ****//////////////////" + event.getKey());
		System.out.println(event.getType());
	}
	
	@CacheEntryExpired
	public void logDetails(CacheEntryExpiredEvent event) {
		System.out.println("****////////// Cache Entry Expired ****//////////////////" + event.getKey());
		System.out.println(event.getType());
	}
	
}
