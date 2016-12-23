package com.prizy.org.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import com.prizy.org.product.ProductData;


public class PrizyPricerContextLoaderListener extends ContextLoaderListener{

	
	public ServletContext servletContext=null;
	
	
	public ServletContext getServletContext() {
		return servletContext;
	}


	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		try{
			ProductData productData=new ProductData();
			ServletContext ctx = servletContextEvent.getServletContext();
			ctx.setAttribute("productData", productData);
			super.contextInitialized(servletContextEvent);
			
		}catch (Exception e) {
			System.out.println("##### PrizyPricer startup failed #####\nDetails:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
}
