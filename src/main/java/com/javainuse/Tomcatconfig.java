package com.javainuse;



import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class Tomcatconfig {
	
	 @Bean
	 public TomcatEmbeddedServletContainerFactory tomcatFactory() {
	        
		 return new TomcatEmbeddedServletContainerFactory() {
	          
	           @Override
	           protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) 
	           {
	                tomcat.enableNaming();
	                return super.getTomcatEmbeddedServletContainer(tomcat);
	            }
	        	
	            @Override
	            protected void postProcessContext(Context context) 
	            {
	                ContextResource resource = new ContextResource();

	                resource.setType(DataSource.class.getName());
	                resource.setName("j4s");
	                resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");
	                resource.setProperty("url", "jdbc:mysql://localhost/testing");
	                resource.setProperty("username", "root");
	                resource.setProperty("password", "mysql12345");
	                
	                context.getNamingResources().addResource(resource);
	            }
	        };
	    }
	 
	    @Bean
	    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException 
	    {
	        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();    
	        bean.setJndiName("java:/comp/env/j4s");
	        bean.setProxyInterface(DataSource.class);
	        bean.setLookupOnStartup(false);
	        bean.afterPropertiesSet();
	        
	        return (DataSource) bean.getObject();
	    }
}