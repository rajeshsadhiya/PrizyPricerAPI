package com.prizy.org.product;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.prizy.org.product.survey.ProductSurveyForm;

@XmlRootElement
@XmlType(propOrder={"product_bar_code_id","product_name","product_company_name","product_MRP","product_survey"})
public class Product {
	
	private String product_bar_code_id;
	private String product_name;
	private double product_MRP;
	private String product_company_name;
	private ArrayList<ProductSurveyForm> product_survey;
	
	public Product(String product_bar_code_id, String product_name, double product_MRP, String product_company_name, ArrayList<ProductSurveyForm> product_survey) {
		super();
		this.product_bar_code_id = product_bar_code_id;
		this.product_name = product_name;
		this.product_MRP = product_MRP;
		this.product_company_name = product_company_name;
		this.product_survey = product_survey;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProduct_bar_code_id() {
		return product_bar_code_id;
	}

	public void setProduct_bar_code_id(String product_bar_code_id) {
		this.product_bar_code_id = product_bar_code_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_MRP() {
		return product_MRP;
	}

	public void setProduct_MRP(double product_MRP) {
		this.product_MRP = product_MRP;
	}

	public String getProduct_company_name() {
		return product_company_name;
	}

	public void setProduct_company_name(String product_company_name) {
		this.product_company_name = product_company_name;
	}

	public ArrayList<ProductSurveyForm> getProduct_survey() {
		return product_survey;
	}

	public void setProduct_survey(ArrayList<ProductSurveyForm> product_survey) {
		this.product_survey = product_survey;
	}
	
	
	
	
	
}
