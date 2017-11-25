package com.bos.web.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bos.bussiness.domain.Region;
import com.bos.bussiness.domain.Subarea;
import com.bos.utils.FileUtils;
import com.bos.utils.PageBean;
import com.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public String editSubarea(){
		//如果是新增将staff的id置空
//		if("".equals(model.getId())){
//			model.setId(null);
//		}
		subareaService.editSubarea(model);
		return "list";
	}

	public String findSubarea() throws IOException{
		
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");

		//在查询之前，封装条件
		DetachedCriteria detachedCriteria2 = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		Region region = model.getRegion();
		if(StringUtils.isNotBlank(addresskey)){
			//按照地址关键字模糊查询
			detachedCriteria2.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		if(region != null){
			//创建别名，用于多表关联查询
			detachedCriteria2.createAlias("region", "r");
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			if(StringUtils.isNotBlank(province)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}

		subareaService.findSubarea(pageBean);
		
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		filter.getExcludes().add("detachedCriteria");
		filter.getExcludes().add("currentPage");
		filter.getExcludes().add("pageSize");
		filter.getExcludes().add("decidedzone");
		filter.getExcludes().add("subareas");
		filter.getExcludes().add("shortcode");
		filter.getExcludes().add("citycode");
				
		String jsonString = JSONObject.toJSONString(pageBean,filter,SerializerFeature.DisableCircularReferenceDetect);
		
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");

		ServletActionContext.getResponse().getWriter().print(jsonString);
	
		return NONE;
	}
	
	public String exportXlsFile() throws IOException{
		List<Subarea> list = subareaService.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		
		HSSFSheet sheet = workbook.createSheet("分区数据");
		
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("区域编号");
		headRow.createCell(2).setCellValue("地址关键字");
		headRow.createCell(3).setCellValue("省市区");

		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getRegion().getId());
			dataRow.createCell(2).setCellValue(subarea.getAddresskey());
			dataRow.createCell(3).setCellValue(subarea.getRegion().getName());
		}
		//一个流两个头
		OutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		String filename = FileUtils.encodeDownloadFilename("分区数据.xls", agent);
		
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletActionContext.getResponse().setContentType(contentType);
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+filename);
		
		workbook.write(outputStream);
		return NONE;
	}
	
	public String findSubareaNotAssociation(){
		List<Subarea> list = subareaService.findSubareaNotAssociation();
		String [] includes = new String [] {"subareaid","addresskey","position"};
		this.arrayListToJson(list,null, includes);
		return NONE;
	}
}
