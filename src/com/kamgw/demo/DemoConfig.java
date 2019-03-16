package com.kamgw.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.kamgw.entity.OrderItem;
import com.kamgw.util.AdminRoutes;

public class DemoConfig extends JFinalConfig {
	//  此方法用来配置 JFinal 常量值，如开发模式常量 devMode 的配置，默认视图类型 ViewType的配置，如下代码配置了 JFinal 运行在开发模式下且默认视图类型为 JSP
	//JFinal 支持 JSP、FreeMarker、Velocity 三种常用视图。
	// me.setViewType(ViewType.JSP);
	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		 arg0.setDevMode(true);
		 arg0.setViewType(ViewType.JSP);
	}

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub
		
	}
	//此方法用来配置 JFinal 的 Handler，如下代码配置了名为 ResourceHandler 的处理器，Handler 可以接管所有 web 请求，并对应用拥有完全的控制权，
	//可以很方便地实现更高层的功能性扩 展
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}
	//此方法用来配置 JFinal  的全局拦截器，全局拦截器将拦截所有 action  请求，除非使用@Clear 在 Controller 中清除
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
    // 连接数据库
	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/kam?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		C3p0Plugin cp = new C3p0Plugin(url, user, password);
		arg0.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		arg0.add(arp);
		arp.addMapping("order_item",OrderItem.class);
	}
	//此方法用来配置 JFinal 访问路由，如下代码配置了将”/hello”映射到 HelloController 这个控 制器 ，
	//通 过 以 下 的 配 置 ， http://localhost/hello 将 访 问 HelloController.index() 方法，
	//而 http://localhost/hello/methodName 将访问到 HelloController.methodName()方法。
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.add("/hello",HelloController.class,"/WEB-INF/jsp");
		//arg0.add(new AdminRoutes());
	}
	//JFinalConfig 中的 afterJFinalStart()与 beforeJFinalStop()方法供开发者在 JFinalConfig 
	//继承类中 覆盖 。 JFinal 会在系统启动完成后回调 afterJFinalStart() 方 法 ， 
	//会 在 系 统 关 闭 前 回 调 beforeJFinalStop()方法。
	//这两个方法可以很方便地在项目启动后与关闭前让开发者有机会进行 额外操作，如在系统启动后创建调度线程或在系统关闭前写回缓存
	//PropKit.use(…).get(…) 来操作
	//第一次使用use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值 	PropKit.use("a_little_config.txt");

	//me.setDevMode(PropKit.getBoolean("devMode"));
	
	//getFile 上传文件
	//可以 在 JFinalConfig.configConstant(Constants me)方法中通过 me.setBaseUploadPath(baseUploadPath) 
	//设置文件上传基础路径，该路径参数接受以”/”打头或者以 windows 磁盘盘符打头的绝对路径， 即可将基础路径指向项目根径之外，
	//方便单机多实例部署。当该路径参数设置为相对路径时， 则是以项目根为基础的相对路径。
}
