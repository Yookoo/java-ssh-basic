package com.young.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JsonUtils {
	
	public static void objectToJson(Object object, String [] excludes, String [] includes) {
		
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		if(excludes !=null && excludes.length > 0){
			filter.getExcludes().addAll(new HashSet<String>(Arrays.asList(excludes)));
		}
		
		if(includes !=null && includes.length > 0){
			filter.getIncludes().addAll(new HashSet<String>(Arrays.asList(includes)));
		}
		
		String jsonString = JSONObject.toJSONString(object,filter);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void arrayListToJson(List list, String [] excludes, String [] includes) {
		
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		if(excludes !=null && excludes.length > 0){
			filter.getExcludes().addAll(new HashSet<String>(Arrays.asList(excludes)));
		}
		
		if(includes !=null && includes.length > 0){
			filter.getIncludes().addAll(new HashSet<String>(Arrays.asList(includes)));
		}
		
		String jsonString = JSONArray.toJSONString(list,filter);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
