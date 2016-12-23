package com.prizy.org.product.survey;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="product_notes")
@XmlType(propOrder={"product_name","product_MRP","product_company_name","note"})
public class ProductNotes {

		private String product_name;
		private double product_MRP;
		private String product_company_name;
		private String note;
		
		public ProductNotes(String product_name, double product_MRP, String product_company_name, String note) {
			super();
			this.product_name = product_name;
			this.product_MRP = product_MRP;
			this.product_company_name = product_company_name;
			this.note = note;
		}

		public ProductNotes() {
			super();
			// TODO Auto-generated constructor stub
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

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}
		
		
		
		
		
}
