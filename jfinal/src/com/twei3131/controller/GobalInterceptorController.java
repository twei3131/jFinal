package com.twei3131.controller;

import com.jfinal.core.Controller;

public class GobalInterceptorController extends Controller {
	public void index(){
		System.out.println("������");
		renderHtml("<center><h1>��鿴����̨</h1></center>");
	}
}
