package com.example.project.model;

public class Orders {
	int orderid;
	String order_date;
int cutomerid;
int total;
public Orders() {
	super();
}
public Orders(int orderid, String order_date, int cutomerid, int total) {
	super();
	this.orderid = orderid;
	this.order_date = order_date;
	this.cutomerid = cutomerid;
	this.total = total;
}
@Override
public String toString() {
	return "Orders [orderid=" + orderid + ", order_date=" + order_date + ", cutomerid=" + cutomerid + ", total=" + total
			+ "]";
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public int getCutomerid() {
	return cutomerid;
}
public void setCutomerid(int cutomerid) {
	this.cutomerid = cutomerid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}

}
