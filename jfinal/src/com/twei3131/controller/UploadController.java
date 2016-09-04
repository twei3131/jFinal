package com.twei3131.controller;

import java.io.File;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

public class UploadController extends Controller {
	public void index(){
		setAttr("qw", 2016);
		//render("index.jsp");
		//renderError(500);
	}
	
	@ActionKey("/formNormal")
	public void formNormal(){
		UploadFile file = getFile("file");
		setAttr("res", "success");
		setAttr("fileUrl", PathKit.getWebRootPath()+File.separator+"twei3131Load"+File.separator+file.getFileName());
		setAttr("url", "twei3131Load"+File.separator+file.getFileName());
		renderJson();
		//render("result.jsp");
	}
	
	@ActionKey("/paraNormal")
	public void paraNormal(){
		final String baseFileName = "123456.pdf";
		final String basePath = PathKit.getWebRootPath()+File.separator+"twei3131Load"+File.separator;
		
		File oldfile = new File(basePath+baseFileName);
		if (oldfile.exists()) {
			oldfile.delete();
		}
		
		UploadFile file = getFile("file");
		String param = getPara("param");
		File f = file.getFile();
		f.renameTo(new File(basePath+baseFileName));
		
		setAttr("res", "success"+"==="+param);
		setAttr("fileUrl", basePath+file.getFileName());
		setAttr("url", "twei3131Load"+File.separator+file.getFileName());
		render("result.jsp");
	}
}
