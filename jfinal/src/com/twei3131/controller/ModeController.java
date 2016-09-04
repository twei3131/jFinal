package com.twei3131.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.log.Log4jLog;
import com.twei3131.common.model.Student;

public class ModeController extends Controller {
	public void index(){
		render("index.jsp");
	}
	
	public void setsave(){
		Student students = new Student();
		students.set("id", "14302189");
		students.set("name", "陶伟");
		students.set("grage", "大三");
		students.set("class", "14级应用3班");
		boolean state = students.save();
		if (state) {
			setAttr("state", 200);
			setAttr("model", students);
			renderJson();
		}else{
			
			renderError(500);
		}
	}
	
	public void getsave(){
		Student students = getModel(Student.class, "student");
		boolean fla = students.save();
		if (fla) {
			setAttr("sta", 200);
			renderJson();
		}else{
			renderError(500);
		}
		
	}
}
