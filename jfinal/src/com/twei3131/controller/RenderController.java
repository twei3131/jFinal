package com.twei3131.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.render.ContentType;
import com.twei3131.model.User;

public class RenderController extends Controller {
	public void index(){
		render("index.jsp");
	}
	
	public void result(){
		render("/upload/index.jsp");
	}
	
	public void renderJSP(){
		renderJsp("/upload/index.jsp");
	}
	
	public void redirct(){
		redirect("/upload",true);
		//render("/upload/index.jsp");
		//redirect("http://www.baidu.com",true);
	}
	
	public void forward(){
		forwardAction("/upload");
	}
	
	public void forwardwp(){
		setAttr("wed", "1");
		forwardAction("/render/forwardResultwp");
	}
	
	public void forwardResultwp(){
		setAttr("wedss", getAttr("wed"));
		render("/upload/index.jsp");
	}
	
	public void text(){
		renderText("leik,efile");
	}
	
	public void textxml(){
		renderText("<name>twei3131</name>",ContentType.XML);
	}
	
	public void texthtml(){
		renderText("<center><h1>twei3131</h1></center>",ContentType.HTML);
	}
	
	public void error(){
		renderError(404);
	}
	
	public void none(){
		System.out.println("null");
		renderNull();
	}
	
	public void json(){
		List<User> users = User.dao.find("select * from user");
		setAttr("users", users.get(0));
//		String json  = JsonKit.toJson(users);
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("res", users);
		renderJson(new String[]{"users"});
	}
}
