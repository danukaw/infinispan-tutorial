package com.infinispan.tutorial.config;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
public class CacheManagerConfig {

	@Produces
	public EmbeddedCacheManager getManager() {
		
//		GlobalConfiguration globalconfiguration = new GlobalConfigurationBuilder().
//					clusteredDefault()
//					.transport()
//					.clusterName("message-cluster")
//					.addProperty("configurationFile", "jgroups-tcp.xml")
//					.build();
//		
//		Configuration configuration = new ConfigurationBuilder().
//												clustering()
//												.cacheMode(CacheMode.REPL_SYNC).memory()
//												.size(120)
//												.build();
//		
//		return new DefaultCacheManager(globalconfiguration, configuration);
	
// declartive way of implementing infinispan
//cacheManager = new DefaultCacheManager(WeatherApp.class.getResourceAsStream("/weatherapp-infinispan.xml"));

		try {
			//return new DefaultCacheManager("my-config-file.xml");
			return new DefaultCacheManager(CacheManagerConfig.class.getResourceAsStream("/my-config-file.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		//return new DefaultCacheManager("my-config-file.xml");
	}
}
