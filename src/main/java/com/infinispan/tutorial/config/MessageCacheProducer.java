package com.infinispan.tutorial.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.infinispan.cdi.embedded.ConfigureCache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

@ApplicationScoped
public class MessageCacheProducer {

	@Produces
	@ConfigureCache("message-cache")
	@MessageCache
	public Configuration getConfiguration() {
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.memory().size(1000);
		
		return builder.build();
	}
}
