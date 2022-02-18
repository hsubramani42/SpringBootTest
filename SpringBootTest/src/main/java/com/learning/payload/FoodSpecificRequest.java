package com.learning.payload;

import lombok.Data;

@Data

//constraints are not set because in food update 
//user may send null value for the fields which he don't want to update 
public class FoodSpecificRequest {

	private String foodName;

	private double foodCost;

	private String foodType;

	private String description;

	private String foodPic;
}
