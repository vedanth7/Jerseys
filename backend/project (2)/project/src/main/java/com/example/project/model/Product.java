package com.example.project.model;

public class Product {
	int pid;
	String pname;
	String description;
	int sizeid;
	String image;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", description=" + description + ", sizeid=" + sizeid
				+ ", image=" + image + "]";
	}
	public Product(int pid, String pname, String description, int sizeid, String image) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.description = description;
		this.sizeid = sizeid;
		this.image = image;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
