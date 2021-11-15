package com.example.project.model;

public class Customer {
	int custid;
	String custname;
	String custDOB;
	String custusername;
	String password;
	String custphone;
	String custemail;
	String custaddress;
	public Customer() {
		super();
	}
	public Customer(int custid, String custname, String dOB, String custusername, String password, String custphone,
			String custemail, String custaddress) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.custDOB=dOB;
		this.custusername = custusername;
		this.password = password;
		this.custphone = custphone;
		this.custemail = custemail;
		this.custaddress = custaddress;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getDOB() {
		return custDOB;
	}
	public void setDOB(String dOB) {
		this.custDOB = dOB;
	}
	public String getCustusername() {
		return custusername;
	}
	public void setCustusername(String custusername) {
		this.custusername = custusername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public String getCustaddress() {
		return custaddress;
	}
	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", DOB=" + custDOB + ", custusername="
				+ custusername + ", password=" + password + ", custphone=" + custphone + ", custemail=" + custemail
				+ ", custaddress=" + custaddress + "]";
	}

}
