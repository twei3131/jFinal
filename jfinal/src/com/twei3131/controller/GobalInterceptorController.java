package com.twei3131.controller;

import com.jfinal.core.Controller;

public class GobalInterceptorController extends Controller {
	public void index(){
		System.out.println("拦截器");
		renderHtml("<center><h1>请查看控制台</h1></center>");
	}
}
