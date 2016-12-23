package com.prizy.org.service;

import java.util.Map;

import javax.servlet.ServletContext;

import com.prizy.org.product.Product;
import com.prizy.org.product.ProductData;
import com.prizy.org.product.survey.ProductSurveyForm;
import com.prizy.org.product.survey.ProductViewer;


public interface ProductServices {

	 public boolean isProductRegistered(ProductData productDataObj, String productId);
	 
	 public ProductData getProductList(ServletContext servletContext);
	 
	 public void addNewProduct(ProductSurveyForm productSurveyFormObj, Map<String, Product> productData);
	 
	 public void addNewProductSurveyRecord(ProductSurveyForm productSurveyFormObj, Map<String, Product> productData);
	 
	 public ProductViewer viewProductDetails(Product product,float idealPriceOffset);
}
