/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import domain.User;

import service.UserService;
import struts.form.UserForm;
import utils.SqlHelper;
import utils.Tools;

/** 
 * MyEclipse Struts
 * Creation date: 12-06-2016
 * 
 * XDoclet definition:
 * @struts.action path="/user" name="userForm" scope="request"
 */
public class UserAction extends DispatchAction {

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub\
		String name = userForm.getName();
		FormFile photo = userForm.getPhoto();
		String filename  = photo.getFileName();
		int filesize = photo.getFileSize();
		//System.out.println("filename"+filename+"filesize"+filesize);
		//将文件名重命名为不重复的uuidname;
		Tools tools = new Tools();
		String uuidname = tools.renameFile(filename);
		//获取上传文件的路径;		
		String filePath = this.getServlet().getServletContext().getRealPath("/file");
		String fileAllPath = filePath+"\\"+uuidname;
		//System.out.println("keepFilePath"+keepFilePath);
		
		
		UserService uService = new UserService();
		//封装user信息
		User user = new User();
		user.setUsername(name);
		user.setFilename(filename);
		user.setUuidname(uuidname);

		//如果文件上传和添加用户都成功跳转至ok界面;
		if(tools.Upload(fileAllPath,photo)&&uService.addUser(user)){		
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("goerr");
		}		
	}
	
	public ActionForward showUserList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub\
		
		UserService uService = new UserService();
		ArrayList<User> al = uService.findAllUser();
		request.setAttribute("userList", al);
		return mapping.findForward("showUserList");
	}
	
	
	public ActionForward downFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub\
		
		UserService uService = new UserService();
		String username = request.getParameter("username");
		User user = uService.findUser(username);
		
		//设置下载的头信息
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+user.getFilename());
		String filePath = this.getServlet().getServletContext().getRealPath("/file");
		String fileAllPath = filePath+"\\"+user.getUuidname();
		Tools tools = new Tools();
		if(tools.Download(fileAllPath, response)){
			return mapping.findForward("showUserList");
		}else{
			return mapping.findForward("err");
		}
		
	}
}