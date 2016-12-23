package com.prizy.org.product.survey;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="product_details")
@XmlType(propOrder={"product_bar_code_id","product_description","product_highest_price","product_avg_price",
		"product_lowest_price","product_ideal_price"})
public class ProductViewer {

	private String product_bar_code_id;
	private ProductDescription product_description;
	private double product_highest_price;
	private double product_avg_price;
	private double product_lowest_price;
	private double product_ideal_price;

	public ProductViewer(String product_bar_code_id, ProductDescription product_description, double product_highest_price, double product_avg_price,
			double product_lowest_price, double product_ideal_price) {
		
		super();
		this.product_bar_code_id = product_bar_code_id;
		this.product_description = product_description;
		this.product_highest_price = product_highest_price;
		this.product_avg_price = product_avg_price;
		this.product_lowest_price = product_lowest_price;
		this.product_ideal_price = product_ideal_price;
	}


	public ProductViewer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getProduct_bar_code_id() {
		return product_bar_code_id;
	}
	public void setProduct_bar_code_id(String product_bar_code_id) {
		this.product_bar_code_id = product_bar_code_id;
	}
	public double getProduct_highest_price() {
		return product_highest_price;
	}
	public void setProduct_highest_price(double product_highest_price) {
		this.product_highest_price = product_highest_price;
	}
	public double getProduct_avg_price() {
		return product_avg_price;
	}
	public void setProduct_avg_price(double product_avg_price) {
		this.product_avg_price = product_avg_price;
	}
	public double getProduct_lowest_price() {
		return product_lowest_price;
	}
	public void setProduct_lowest_price(double product_lowest_price) {
		this.product_lowest_price = product_lowest_price;
	}
	public double getProduct_ideal_price() {
		return product_ideal_price;
	}
	public void setProduct_ideal_price(double product_ideal_price) {
		this.product_ideal_price = product_ideal_price;
	}


	public ProductDescription getProduct_description() {
		return product_description;
	}


	public void setProduct_description(ProductDescription product_description) {
		this.product_description = product_description;
	}
	
	
}
