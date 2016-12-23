package com.prizy.org.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Service;
import com.prizy.org.product.Product;
import com.prizy.org.product.ProductData;
import com.prizy.org.product.survey.ProductDescription;
import com.prizy.org.product.survey.ProductNotes;
import com.prizy.org.product.survey.ProductSurveyForm;
import com.prizy.org.product.survey.ProductSurveyOfferedPriceComparator;
import com.prizy.org.product.survey.ProductViewer;

@Service
public class ProductServiceImpl implements ProductServices{
	
	
	double product_highest_price = 0;
	double product_avg_price = 0;
	double product_lowest_price = 0;
	double product_ideal_price = 0;
	double product_total_sum_offered_price = 0;

	public boolean isProductRegistered(ProductData productDataObj, String productId){
		if(productDataObj.productData.containsKey(productId)){
			return true;
		}
		 return false;
	 }
	 
	public ProductData getProductList(ServletContext servletContext){
		return (ProductData) servletContext.getAttribute("productData");
	}
	
	 public void addNewProduct(ProductSurveyForm productSurveyFormObj, Map<String, Product> productData){
		 
		 ProductNotes productNotes=productSurveyFormObj.getProduct_notes();
		 String productName=productNotes.getProduct_name();
		 String productComapnyName= productNotes.getProduct_company_name();
		 double productMRP= productNotes.getProduct_MRP();
		 String productBarCodeID=productSurveyFormObj.getProduct_bar_code_id();
		 
		 ArrayList<ProductSurveyForm> productSurvey=new ArrayList<ProductSurveyForm>();
		 productSurvey.add(productSurveyFormObj);
		 
		 Product product=new Product(productBarCodeID, productName, productMRP, productComapnyName,productSurvey);
		 productData.put(productBarCodeID, product);
	 }

	public void addNewProductSurveyRecord(ProductSurveyForm productSurveyFormObj, Map<String, Product> productData) {
	
		 String productBarCodeID=productSurveyFormObj.getProduct_bar_code_id();
		 Product product=productData.get(productBarCodeID);
		 ArrayList<ProductSurveyForm> puductSurvey=product.getProduct_survey();
		 if(puductSurvey!=null){
			 puductSurvey.add(productSurveyFormObj);
		 }else{
			 ArrayList<ProductSurveyForm> productSurvey=new ArrayList<ProductSurveyForm>();
			 productSurvey.add(productSurveyFormObj);
			 product.setProduct_survey(productSurvey);
		 }
	}

	public ProductViewer viewProductDetails(Product product, float idealPriceOffset) {
		
		String product_bar_code_id=product.getProduct_bar_code_id();
		String product_name=product.getProduct_name();
		double product_MRP=product.getProduct_MRP();
		String product_company_name=product.getProduct_company_name();
		calculateProductPriceLevel(product, idealPriceOffset);
		ProductDescription productDescription=new ProductDescription(product_name,product_MRP,product_company_name);
		ProductViewer productView=new ProductViewer(product_bar_code_id, productDescription,
														product_highest_price, product_avg_price, product_lowest_price, product_ideal_price);
		
		return productView;
	}
	 
	private void calculateProductPriceLevel(Product product, float idealPriceOffset){
		
		 ArrayList<ProductSurveyForm> productSurvey = product.getProduct_survey();
		 
		 if(productSurvey!=null){ 
			 Collections.sort(productSurvey,new ProductSurveyOfferedPriceComparator());
			 int size=productSurvey.size();
			 setProduct_highest_price(productSurvey.get(size-1).getOffered_product_price());
			 setProduct_avg_price(calculateAvgPrice(productSurvey));
			 setProduct_lowest_price(productSurvey.get(0).getOffered_product_price());
			 setProduct_ideal_price(calculateIdealPrice(productSurvey,product.getProduct_MRP(),idealPriceOffset));
		 }else{
			 setProduct_highest_price(product.getProduct_MRP());
			 setProduct_avg_price(product.getProduct_MRP());
			 setProduct_lowest_price(product.getProduct_MRP());
			 setProduct_ideal_price(product.getProduct_MRP());
		 }
	}
	
	
	private double calculateIdealPrice(ArrayList<ProductSurveyForm> productSurvey,double mrp, float idealPriceOffset){
		
		/* Ideal Price:: This price is calculated by taking all the prices of this product, removing the 2 highest and 2 lowest, 
		then doing an average with the rest and adding 20% to it.*/
		//calculating ideal price
		 int size=productSurvey.size();	
		 if(size>6){ // Since for calculating ideal price for the product , have to remove 2 highest and 2 lowest value  i.e 4 element
			 
			 double total_sum_of_offered_price=getProduct_total_sum_offered_price(); // total sum of offered price of all offered price has been already calculated.
			 
			 double higestFirstOfferdPrice=productSurvey.get(size-1).getOffered_product_price();
			 double higestSecondOfferdPrice=productSurvey.get(size-2).getOffered_product_price();
			 
			 double lowestFirstOfferdPrice=productSurvey.get(0).getOffered_product_price();
			 double lowestSecondOfferdPrice=productSurvey.get(1).getOffered_product_price();
			 
			 double final_total_sum_of_offered_price = total_sum_of_offered_price -
					 									(higestFirstOfferdPrice + higestSecondOfferdPrice+
					 												lowestFirstOfferdPrice + lowestSecondOfferdPrice);
			 
			 double final_avg_of_offered_price = final_total_sum_of_offered_price/size-4;
			 
			 //Adding idealPriceOffset ex: Increase price by 20%.
			 double final_ideal__price = final_avg_of_offered_price + ((final_avg_of_offered_price*idealPriceOffset)/100);
			 
			 return final_ideal__price;
		 }
		 // else if data is not sufficient than having MRP as an ideal price.
		return mrp;
	}

  private double calculateAvgPrice(ArrayList<ProductSurveyForm> productSurvey){
		 int size=productSurvey.size();	
		//calculating avg price
		 double avg_price,sum_price = 0;
		 Iterator<ProductSurveyForm> ir=productSurvey.iterator();
		 while(ir.hasNext()){
			 ProductSurveyForm surveyData=ir.next();
			 sum_price += surveyData.getOffered_product_price();
		 }
		 setProduct_total_sum_offered_price(sum_price);
		 avg_price=sum_price/size;
		return avg_price;
	}

	private double getProduct_highest_price() {
		return product_highest_price;
	}

	private void setProduct_highest_price(double product_highest_price) {
		this.product_highest_price = product_highest_price;
	}

	private double getProduct_avg_price() {
		return product_avg_price;
	}

	private void setProduct_avg_price(double product_avg_price) {
		this.product_avg_price = product_avg_price;
	}

	private double getProduct_lowest_price() {
		return product_lowest_price;
	}

	private void setProduct_lowest_price(double product_lowest_price) {
		this.product_lowest_price = product_lowest_price;
	}

	private double getProduct_ideal_price() {
		return product_ideal_price;
	}

	private void setProduct_ideal_price(double product_ideal_price) {
		this.product_ideal_price = product_ideal_price;
	}
	
	 public double getProduct_total_sum_offered_price() {
			return product_total_sum_offered_price;
		}

		public void setProduct_total_sum_offered_price(
				double product_total_sum_offered_price) {
			this.product_total_sum_offered_price = product_total_sum_offered_price;
		}
	 
}
