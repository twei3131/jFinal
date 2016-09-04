package com.twei3131.controller;

import java.util.List;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.twei3131.common.model.User;

@Clear
public class UserController extends Controller {
	public void index(){
		List<User> users = User.dao.find("select * from user");
		setAttr("users", users);
		System.out.println(users.size());
		render("list.jsp");
	}
	
	public void form(){
		String id = getPara(0);
		if (id != null && Integer.valueOf(id) > 0) {
			//List<User> users = User.dao.find("select * from user where id = ?", id.trim());
			User users = User.dao.findById(id);
			User u = User.dao.findByIdLoadColumns(id, "remark,age");
			u.setRemark("324353343");
			System.out.println(u.getRemark()+"sui");
			System.out.println(u.getInt("age")+"sui");
			//Long i = User.dao.findFirst("select count(*) as num from user where id = ?",id.trim()).getLong("num");
			Long i = Db.queryLong("select count(*) from user where id = ?",id.trim());
			System.out.println("===="+i+"====");
			System.out.println(users.getAge());
			setAttr("user", users);	
		}
		render("form.jsp");
	}
	
	public void submit(){
		User user = getModel(User.class,"user");
		user.save();
		index();
	}
	
	public void update(){
		//User user = getModel(User.class,"user");
		User user = new User();
		//user.set("id", 14302189);
		user = User.dao.findById("14302189");
		user.set("age",22);
		user.update();
		index();
	}
	
	public void edit(){
		form();
	}
	
	public void delete(){
		//User.dao.deleteById(getPara(0));
		User user = new User();
//		user.setId(getPara(0));
//		user.delete();
		user = User.dao.findById(getPara(0));
		user.delete();
		index();
	}
}
