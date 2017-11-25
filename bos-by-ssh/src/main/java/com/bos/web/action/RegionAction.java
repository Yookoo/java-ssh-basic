package com.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Region;
import com.bos.utils.PageBean;
import com.bos.utils.PinYin4jUtils;
import com.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File myFile;
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	
	public String importXlsFile() throws IOException{
		String flag = "1";
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(myFile));
			HSSFSheet sheet = workbook.getSheetAt(0);
			List<Region> list = new ArrayList<Region>();
			for (Row row : sheet) {
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//第一行，标题行，忽略
					continue;
				}
				String id = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String district = row.getCell(3).getStringCellValue();
				String postcode = row.getCell(4).getStringCellValue();
				String citycode = this.toCitycode(city);
				String shortcode = this.toShortcode(province, city, district);
				Region region = new Region(id, province, city, district, postcode, shortcode, citycode, null);
				list.add(region);
			}
			regionService.saveBatch(list);
			
		} catch (Exception e) {
			flag = "0";
			e.printStackTrace();
		}
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;  
	}
	public String pageQuery(){
		
		regionService.pageQuery(pageBean);
		//过滤没用的属性
		String [] excludes = new String [] {"detachedCriteria"};
		this.objectToJson(pageBean,excludes, null);
		return NONE;
	}
	public String findAll(){
		
		List<Region> list = regionService.findAll();
		String [] includes = new String [] {"id","name"};
		this.arrayListToJson(list, null, includes );
		return NONE;
	}
	
	

	private String toCitycode(String city){
		//城市编码--->>shijiazhuang
		city  = city.substring(0, city.length() - 1);
		String[] stringToPinyin = PinYin4jUtils.stringToPinyin(city);
		String citycode = StringUtils.join(stringToPinyin, "");
		return citycode;
		
	}

	private String toShortcode(String province,String city,String district){
		//简码---->>HBSJZCA
		province  = province.substring(0, province.length() - 1);
		city  = city.substring(0, city.length() - 1);
		district  = district.substring(0, district.length() - 1);
		String info = province + city + district;//河北石家庄长安
		String[] headByString = PinYin4jUtils.getHeadByString(info);
		
		String shortcode = StringUtils.join(headByString, "");
		return shortcode;
	}

}
