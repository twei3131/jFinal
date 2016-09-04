package com.twei3131.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;

public class Test01 extends Controller {
	public void index(){
		setAttr("p1", getPara("index"));
		setAttr("p2", getPara("twoInd"));
		render("index.jsp");
	}
	
	@ActionKey("qwt")
	public void qwt(){
		setAttr("p1", getParaToInt("p1",130));
		setAttr("p2", getParaToInt("p2"));
		render("index.jsp");
	}
	
	public void ajx(){
		String id = getPara("id");
//		Ret ret = Ret.create();
//		ret.put("id","123456");
//		ret.put("param", "succ");
		setAttr("id",id);
		renderJson();
	}
}
 