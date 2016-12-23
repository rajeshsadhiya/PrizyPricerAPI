package com.prizy.org.product.survey;

import java.util.Comparator;

public class ProductSurveyOfferedPriceComparator implements Comparator<ProductSurveyForm>{

	public int compare(ProductSurveyForm o1, ProductSurveyForm o2) {
		  
		if(o1.getOffered_product_price()==o2.getOffered_product_price())  
			return 0;  
		else if(o1.getOffered_product_price()>o2.getOffered_product_price())  
			return 1;  
		else  
			return -1;  
	}

}
