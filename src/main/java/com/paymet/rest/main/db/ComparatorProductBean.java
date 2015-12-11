package com.paymet.rest.main.db;

import java.util.Comparator;

import com.paymet.rest.main.db.bean.ProductBean;

public class ComparatorProductBean implements Comparator<ProductBean>{

	@Override
	public int compare(ProductBean o1, ProductBean o2) {
		return o1.getProductId().compareTo(o2.getProductId());
	}
	
	

}
