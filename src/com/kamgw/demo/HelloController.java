package com.kamgw.demo;

import java.util.List;

import com.jfinal.core.Controller;
import com.kamgw.entity.OrderItem;

public class HelloController extends Controller {
	//@ActionKey("/login") 或者使用注解
	//JFinal 默认使用减号“-”来分隔多个值（可 通过constants. setUrlParaSeparator(String)设置分隔符），
	//在 Controller  中可以通过 getPara(intindex)分别取出这些值
	public void index() {
		String zhi = "bjjbjj";
		List<OrderItem> item =OrderItem.order.find("select * from order_item where id =1"); 
		OrderItem em = item.get(0);
		
		renderJson(em);
		//renderJsp("aaa.jsp");
	}
	/*
	 * public void one() { renderText("Hello jfinal one"); }
	 */
	
}
