package com.kamgw.util;

import com.jfinal.config.Routes;
import com.kamgw.demo.HelloController;

public class AdminRoutes extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
		this.add("/admin/one",HelloController.class);
	}

}
