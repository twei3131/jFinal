package com.twei3131.common;

import java.util.Date;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.FakeStaticHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.twei3131.common.model._MappingKit;
import com.twei3131.controller.BatchController;
import com.twei3131.controller.GobalInterceptorController;
import com.twei3131.controller.IndexController;
import com.twei3131.controller.ModeController;
import com.twei3131.controller.RenderController;
import com.twei3131.controller.StudentController;
import com.twei3131.controller.TeacherController;
import com.twei3131.controller.Test01;
import com.twei3131.controller.UploadController;
import com.twei3131.controller.UserController;
import com.twei3131.handlers.handler;
//import com.twei3131.interceptor.ExceptionIntoLogInterceptor;
import com.twei3131.interceptor.GobalInterceptor;
import com.twei3131.common.model.Log;

public class MainConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setViewType(ViewType.JSP);
		PropKit.use("config.properties");
		PropKit.use("log4j.properties");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setBaseUploadPath("twei3131Load");
		me.setMaxPostSize(104857600);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/",IndexController.class);
		me.add("/user",UserController.class);
		me.add("/teacher", TeacherController.class);
		me.add("/student",StudentController.class);
		me.add("/gobalInterceptor",GobalInterceptorController.class);
		me.add("/test01",Test01.class);
		me.add("/upload",UploadController.class);
		me.add("/render",RenderController.class);
		me.add("/students",ModeController.class);
		me.add("/batch",BatchController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password"));
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arp.setShowSql(true);
//		arp.addMapping("user", User.class);
//		arp.addMapping("log", Log.class);
//		arp.addMapping("student", Students.class);
		_MappingKit.mapping(arp);
		me.add(c3p0Plugin);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new GobalInterceptor());
		//me.addGlobalActionInterceptor(new ExceptionIntoLogInterceptor());
		//me.addGlobalServiceInterceptor(new ExceptionIntoLogInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		//me.add(new FakeStaticHandler());
		me.add(new handler());
	}
	
	@Override
	public void beforeJFinalStop() {
		System.out.println("0987654321");
		Log log = new Log();
		log.set("context", "14302189");
		log.set("createTime", new Date());
		log.save();
	}
	
	@Override
	public void afterJFinalStart(){
		System.out.println("1234567890");
		Log log = new Log();
		log.set("context", "14302189");
		log.set("createTime", new Date());
		log.save();
	}
	
	public static void main(String[] args){
		JFinal.start("WebRoot",8080,"/",5);
	}

}
