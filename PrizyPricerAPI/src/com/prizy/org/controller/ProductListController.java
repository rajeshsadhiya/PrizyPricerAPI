package com.prizy.org.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.prizy.org.product.Product;
import com.prizy.org.product.ProductData;
import com.prizy.org.product.ProductList;
import com.prizy.org.product.survey.ProductViewer;
import com.prizy.org.service.ProductServices;


@Controller
@RequestMapping("/productlist")
public class ProductListController{

	@Autowired
	public ProductServices productServices;
	
	public ProductListController() {
		super();
	}
	
	@RequestMapping(value="/", produces={MediaType.APPLICATION_ATOM_XML_VALUE},method=RequestMethod.GET)
	public @ResponseBody ProductList getProductList(HttpServletRequest request){
		ServletContext servletContext  = request.getSession().getServletContext();
		ProductData productDataObj=productServices.getProductList(servletContext);
		List<Product> list=new ArrayList<Product>(productDataObj.productData.values());
		return new ProductList(list);
	}
	
	@RequestMapping(value="/{productBarCodeId}", produces={MediaType.APPLICATION_ATOM_XML_VALUE},method=RequestMethod.GET)
	public @ResponseBody ProductViewer viewProductDetails(@PathVariable("productBarCodeId")String productBarCodeId, HttpServletRequest request){
		
		ServletContext servletContext  = request.getSession().getServletContext();
		float idealPriceOffset= Float.parseFloat((String)servletContext.getInitParameter("idealPriceOffset"));
		ProductData productDataObj=productServices.getProductList(servletContext);
		Product product=productDataObj.productData.get(productBarCodeId);
		ProductViewer productViewer = productServices.viewProductDetails(product,idealPriceOffset);
		return productViewer;

	}

}
