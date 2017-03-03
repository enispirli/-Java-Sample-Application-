package model;

public class Product {
	private int barcodeNo;
	private String name;
	private int cost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(int barcodeNo) {
		this.barcodeNo = barcodeNo;
	}

	@Override
	public String toString() {
		return "Product [barcodeNo=" + barcodeNo + ", name=" + name + ", cost=" + cost + "]";
	}
	
	

}
