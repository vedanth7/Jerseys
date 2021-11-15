package com.example.project.model;

public class Orderdetails {
int orderid;
int pid;
int sizid;
int sizprice;
int qty;
int sum;
public Orderdetails(int orderid, int pid, int sizid, int sizprice, int qty, int sum) {
	super();
	this.orderid = orderid;
	this.pid = pid;
	this.sizid = sizid;
	this.sizprice = sizprice;
	this.qty = qty;
	this.sum = sum;
}
public Orderdetails() {
	super();
}
@Override
public String toString() {
	return "Orderdetails [orderid=" + orderid + ", pid=" + pid + ", sizid=" + sizid + ", sizprice=" + sizprice
			+ ", qty=" + qty + ", sum=" + sum + "]";
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getSizid() {
	return sizid;
}
public void setSizid(int sizid) {
	this.sizid = sizid;
}
public int getSizprice() {
	return sizprice;
}
public void setSizprice(int sizprice) {
	this.sizprice = sizprice;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}

}
