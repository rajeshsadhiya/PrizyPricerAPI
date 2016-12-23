package com.prizy.org.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prizy.org.product.ProductData;
import com.prizy.org.product.survey.ProductSurveyForm;
import com.prizy.org.service.ProductServices;


@Controller
@RequestMapping("/productloader")
public class ProductLoaderController {
	
	@Autowired
	ProductServices productServices;
	
	public ProductLoaderController() {
		super();
	}
	
	@RequestMapping(value="/survey", headers="Content-Type=application/xml", produces=MediaType.APPLICATION_XHTML_XML_VALUE, consumes={MediaType.APPLICATION_ATOM_XML_VALUE},method=RequestMethod.POST)
	public @ResponseBody String productSurvey(@RequestBody ProductSurveyForm productSurveyFormObj, HttpServletRequest request){
		
		ServletContext servletContext  = request.getSession().getServletContext();
		ProductData productDataObj=productServices.getProductList(servletContext);
		String productId=productSurveyFormObj.getProduct_bar_code_id();
		
		if(!(productServices.isProductRegistered(productDataObj,productId))){
			productServices.addNewProduct(productSurveyFormObj,productDataObj.productData);
			servletContext.setAttribute("productData", productDataObj);
		}else{
			productServices.addNewProductSurveyRecord(productSurveyFormObj, productDataObj.productData);
			servletContext.setAttribute("productData", productDataObj);
		}
		
		return "<product-status><message>Product Details Updated.</message></product-status>";
	}
	
}
