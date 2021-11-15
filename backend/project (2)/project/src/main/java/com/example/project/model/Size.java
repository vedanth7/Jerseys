package com.example.project.model;

public class Size {
int sizeid;
String sizename;
int sizeprice;
public Size() {
	super();
}
public Size(int sizeid, String sizename, int sizeprice) {
	super();
	this.sizeid = sizeid;
	this.sizename = sizename;
	this.sizeprice = sizeprice;
}
public int getSizeid() {
	return sizeid;
}
public void setSizeid(int sizeid) {
	this.sizeid = sizeid;
}
public String getSizename() {
	return sizename;
}
public void setSizename(String sizename) {
	this.sizename = sizename;
}
public int getSizeprice() {
	return sizeprice;
}
public void setSizeprice(int sizeprice) {
	this.sizeprice = sizeprice;
}
@Override
public String toString() {
	return "Size [sizeid=" + sizeid + ", sizename=" + sizename + ", sizeprice=" + sizeprice + "]";
}

}
