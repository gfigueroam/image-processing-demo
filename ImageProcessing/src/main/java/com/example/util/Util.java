package com.example.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.Filter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * Image processing utilities.
 * @author gloria.figueroa
 */
public class Util {
	
	private final static String JSON_FILTERS = "[ {id:1, name:Identity, description:identity, width:3, height:3, mask:[0,0,0,0,1,0,0,0,0] },"
            + " {id:2, name:'Edge Detection Low', description:'Edge detection', width:3, height:3, mask:[1,0,-1,0,0,0,-1,0,1]}," 
            + " {id:3, name:'Edge Detection Medium', description:'Edge detection', width:3, height:3, mask:[0,1,0,1,-4,1,0,1,0]},"
            + " {id:4, name:'Edge Detection High', description:'Edge detection', width:3, height:3, mask:[-1,-1,-1,-1,8,-1,-1,-1,-1]},"
            + " {id:5, name:'Sharpen', description:'Sharpen', width:3, height:3, mask:[0,-1,0,-1,5,-1,0,-1,0]}," 
	        + " {id:6, name:'Box Blur', description:'Box blur', width:3, height:3, mask:[.11111,.11111,.11111,.11111,.11111,.11111,.11111,.11111,.11111]},"
	        + " {id:7, name:'Botton Sobel', description:'Botton Sobel', width:3, height:3, mask:[-1,-2,-1,0,0,0,1,2,1]},"
	        + " {id:8, name:'Emboss', description:'Emboss', width:3, height:3, mask:[-2,-1,0,-1,1,1,0,1,2]} ]";
	

	/**
	 * Private Default Constructor to prevent the instantiation.
	 */
	private Util(){}
	
	/**
	 * Returns a list with the filters defined in {@link #JSON_FILTERS JSON_FILTERS}.
	 * @return List populated with the filters.
	 * @throws JsonSyntaxException Exception thrown when the String JSON_FILTERS is not correctly defined.
	 */
	public static List<Filter> getFiltersList() throws JsonSyntaxException{
		Type listType = new TypeToken<ArrayList<Filter>>(){}.getType();
		return new Gson().fromJson(JSON_FILTERS, listType);
	}
}
