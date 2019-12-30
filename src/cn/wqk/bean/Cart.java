package cn.wqk.bean;

public class Cart {
	String name,unit_price,total_price,real_pay;
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getReal_pay() {
		return real_pay;
	}

	public void setReal_pay(String real_pay) {
		this.real_pay = real_pay;
	}
}
