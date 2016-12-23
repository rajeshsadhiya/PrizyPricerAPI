package com.prizy.org.product;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="product_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList {
	
	public List<Product> product;

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public ProductList(List<Product> product) {
		super();
		this.product = product;
		System.out.println("size:"+this.product.size());
	}

	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
