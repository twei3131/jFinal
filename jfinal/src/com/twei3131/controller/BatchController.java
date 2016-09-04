package com.twei3131.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.twei3131.common.model.User;

public class BatchController extends Controller {
	public void index(){
		render("index.jsp");
	}
	
	public void getbactch(){
		List<User> users = new ArrayList<User>();
		for(int i = 0;i < 2;i++){
			//users.add(getModel(User.class, "user["+i+"]"));
			User user = new User();
			user.setId(getPara("user["+i+"].id"));
			user.setName(getPara("user["+i+"].name"));
			user.setAge(Integer.valueOf(getPara("user["+i+"].age")));
			user.setSex(Integer.valueOf(getPara("user["+i+"].sex")));
			user.setRemark(getPara("user["+i+"].remark"));
			users.add(user);
		}
		String name = users.get(0).getId();
		System.out.println(name);
		Db.batchSave(users, 2);
		render("index.jsp");
	}
	
	public void downloadFile(){
		List<User> users = new ArrayList<User>();
		final String basePath = PathKit.getWebRootPath()+File.separator+"twei3131Load";
		try{
			File file = new File(basePath,"123.txt");
			if (!file.exists()) {
				users = User.dao.find("select * from user");
				String context = JsonKit.toJson(users);
				file.createNewFile();
				FileOutputStream outputStream = new FileOutputStream(file);
				outputStream.write(context.getBytes("GBK"),0,context.getBytes("GBK").length);
				outputStream.close();
			}
			renderFile(file);
		}catch(Exception e){
			renderError(404);
		}
		
	}
	
	public void execins(){
//		int i = Db.update("insert user values(?,?,?,?,?)",14302198,"131",21,1,"874833");
//		if (i == 0) {
//			renderError(404);
//		}
		/*
		User user = new User();
		user.setId("123456");
		user.setName("1232");
		user.setSex(1);
		user.setRemark("234232");
		user.setAge(21);
		boolean state = user.save();
		if (!state) {
			renderError(500);
		}*/
		Record user = new Record();
		user.set("id", 55453);
		user.set("name", "56454");
		user.set("age", 23);
		user.set("sex", 1);
		user.set("remark", "53235343");
		boolean sta = Db.save("user", user);
		if(!sta){
			renderError(404);
		}
		render("index.jsp");
	}
	
	public void getInfoByPage(){
		int pages = getParaToInt(0);
		Page<Record> page = Db.paginate(pages, 10, "select *", "from user where age > ?",18);
		List<Record> users = page.getList();
		String id = users.get(1).get("id");
		System.out.println(id);
		setAttr("con", users);
		render("index.jsp");
	}
	
	public void getPage(){
		boolean succeed = Db.tx(new IAtom() {	
			public boolean run() throws SQLException {
				Long count = Db.queryLong("select count(*) from user where age > ?", 18);
				System.out.println(count);
				return count >= 0;
			}
		});
		if (!succeed) {
			renderError(500);
		}else{
			render("index.jsp");
		}
		
	}
}
