package com.twei3131.controller;

import com.jfinal.core.Controller;

public class TeacherController extends Controller {
	public void index(){
		render("teacher.jsp");
	}
	
	public void qw(){
		System.out.println(1);
		Integer a = getParaToInt(0);
		Integer b = getParaToInt(1);
		setAttr("a", a);
		setAttr("b", b);
		www();
		render("ww.jsp");
	}
	
	public void www(){
		System.out.println("www");
	}
}
