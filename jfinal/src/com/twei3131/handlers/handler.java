package com.twei3131.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class handler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		// TODO Auto-generated method stub
		System.out.println("===Log:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+":"+target);
		next.handle(target, request, response, isHandled);
	}

}
