package com.sogeti.repository;

import java.util.ArrayList;

import com.sogeti.model.Product;

public class ProductHolder {
	private static ProductHolder myObj;
	private ArrayList<Product> array = new ArrayList<Product>();
	
	private ProductHolder() {
	}
   
	public static ProductHolder getInstance(){
        if(myObj == null){
            myObj = new ProductHolder();
           
        }
        return myObj;
    }
     
	public ArrayList<Product> getArray() {
		return this.array;
	}
	
	public void addToArray(Product value) {
        array.add(value);
    	//if(!array.isEmpty()) array.clear();	
    }
}