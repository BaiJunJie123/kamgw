package com.kamgw.demo;

import java.util.List;

import com.jfinal.core.Controller;
import com.kamgw.entity.OrderItem;

public class HelloController extends Controller {
	//@ActionKey("/login") ����ʹ��ע��
	//JFinal Ĭ��ʹ�ü��š�-�����ָ����ֵ���� ͨ��constants. setUrlParaSeparator(String)���÷ָ�������
	//�� Controller  �п���ͨ�� getPara(intindex)�ֱ�ȡ����Щֵ
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
