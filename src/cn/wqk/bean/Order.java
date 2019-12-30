package cn.wqk.bean;

public class Order {
	String id,username,name,address,real_pay,issend;
	
	public String getIssend() {
		return issend;
	}

	public void setIssend(String issend) {
		this.issend = issend;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReal_pay() {
		return real_pay;
	}

	public void setReal_pay(String real_pay) {
		this.real_pay = real_pay;
	}
}
