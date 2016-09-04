package com.twei3131.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class StudentController extends Controller {
	public void index(){
		render("stu.jsp");
	}
	
	public void getNum(){
		ee();
		index();
	}
	
	public void ee(){
		Integer v = getParaToInt(0);
		v++;
		setAttr("res", v);
	}
	
	@ActionKey("/ak")
	public void ak(){
		System.out.println("ak");
		render("stu.jsp");
	}
}
