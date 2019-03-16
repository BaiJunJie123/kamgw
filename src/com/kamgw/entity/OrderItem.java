package com.kamgw.entity;

import com.jfinal.plugin.activerecord.Model;

public class OrderItem extends Model<OrderItem> {
	public static final OrderItem order = new OrderItem();
   private int id;
   private int quantity;
   private double price;
   private int goods;
   private int order_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getGoods() {
	return goods;
}
public void setGoods(int goods) {
	this.goods = goods;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public OrderItem(int id, int quantity, double price, int goods, int order_id) {
	super();
	this.id = id;
	this.quantity = quantity;
	this.price = price;
	this.goods = goods;
	this.order_id = order_id;
}
public OrderItem() {
	super();
}
   
}
