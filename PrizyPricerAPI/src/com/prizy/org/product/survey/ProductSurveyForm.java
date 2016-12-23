package com.prizy.org.product.survey;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="product_survey")
@XmlType(propOrder={"store_name","product_bar_code_id","offered_product_price","product_notes"})
public class ProductSurveyForm {
	
	private String store_name;
	private String product_bar_code_id;
	private double offered_product_price;
	private ProductNotes product_notes=null;
	
	public ProductSurveyForm(String store_name, String product_bar_code_id, double offered_product_price, ProductNotes product_notes) {
		super();
		this.store_name = store_name;
		this.product_bar_code_id = product_bar_code_id;
		this.offered_product_price = offered_product_price;
		this.product_notes = product_notes;
	}

	public ProductSurveyForm() {
		super();
		
	}

	public String getProduct_bar_code_id() {
		return product_bar_code_id;
	}

	public void setProduct_bar_code_id(String product_bar_code_id) {
		this.product_bar_code_id = product_bar_code_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public double getOffered_product_price() {
		return offered_product_price;
	}

	public void setOffered_product_price(double offered_product_price) {
		this.offered_product_price = offered_product_price;
	}

	public ProductNotes getProduct_notes() {
		return product_notes;
	}

	public void setProduct_notes(ProductNotes product_notes) {
		this.product_notes = product_notes;
	}
	
	
	
}
