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
	//  �˷����������� JFinal ����ֵ���翪��ģʽ���� devMode �����ã�Ĭ����ͼ���� ViewType�����ã����´��������� JFinal �����ڿ���ģʽ����Ĭ����ͼ����Ϊ JSP
	//JFinal ֧�� JSP��FreeMarker��Velocity ���ֳ�����ͼ��
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
	//�˷����������� JFinal �� Handler�����´�����������Ϊ ResourceHandler �Ĵ�������Handler ���Խӹ����� web ���󣬲���Ӧ��ӵ����ȫ�Ŀ���Ȩ��
	//���Ժܷ����ʵ�ָ��߲�Ĺ������� չ
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}
	//�˷����������� JFinal  ��ȫ����������ȫ������������������ action  ���󣬳���ʹ��@Clear �� Controller �����
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
    // �������ݿ�
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
	//�˷����������� JFinal ����·�ɣ����´��������˽���/hello��ӳ�䵽 HelloController ����� ���� ��
	//ͨ �� �� �� �� �� �� �� http://localhost/hello �� �� �� HelloController.index() ������
	//�� http://localhost/hello/methodName �����ʵ� HelloController.methodName()������
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.add("/hello",HelloController.class,"/WEB-INF/jsp");
		//arg0.add(new AdminRoutes());
	}
	//JFinalConfig �е� afterJFinalStart()�� beforeJFinalStop()�������������� JFinalConfig 
	//�̳����� ���� �� JFinal ����ϵͳ������ɺ�ص� afterJFinalStart() �� �� �� 
	//�� �� ϵ ͳ �� �� ǰ �� �� beforeJFinalStop()������
	//�������������Ժܷ��������Ŀ��������ر�ǰ�ÿ������л������ �������������ϵͳ�����󴴽������̻߳���ϵͳ�ر�ǰд�ػ���
	//PropKit.use(��).get(��) ������
	//��һ��ʹ��use���ص����ý���Ϊ�����ã�����ͨ��PropKit.get(...)ֱ��ȡֵ 	PropKit.use("a_little_config.txt");

	//me.setDevMode(PropKit.getBoolean("devMode"));
	
	//getFile �ϴ��ļ�
	//���� �� JFinalConfig.configConstant(Constants me)������ͨ�� me.setBaseUploadPath(baseUploadPath) 
	//�����ļ��ϴ�����·������·�����������ԡ�/����ͷ������ windows �����̷���ͷ�ľ���·���� ���ɽ�����·��ָ����Ŀ����֮�⣬
	//���㵥����ʵ�����𡣵���·����������Ϊ���·��ʱ�� ��������Ŀ��Ϊ���������·����
}
