package com.prizy.org.product;


import java.util.HashMap;
import java.util.Map;

public class ProductData {
	
	public Map<String, Product> productData=new HashMap<String, Product>();

	public ProductData(){
		productData.put("abc123", new Product("abc123", "SAMSUNG Galaxy On8", 16000, "Samsung",null));
		productData.put("qw2134", new Product("qw2134", "Micromax Canvas Nitro 2", 8000, "MicroMax",null));
		productData.put("fd5335", new Product("fd5335", "Nokia 230 Dual SIM", 5000, "Nokia",null));
		productData.put("ry6567", new Product("ry6567", "Blackberry Priv", 33000, "BlackBerry",null));
	}
	
}
