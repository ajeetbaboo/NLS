package com.mypack.model;
public class Stock{
	private float purchase;
	private float sell;
	private float profit;
	
	public float getPurchase() {
		return purchase;
	}
	public void setPurchase(float purchase) {
		this.purchase = purchase;
	}
	public float getSell() {
		return sell;
	}
	public void setSell(float sell) {
		this.sell = sell;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(float purchase, float sell, float profit) {
		super();
		this.purchase = purchase;
		this.sell = sell;
		this.profit = profit;
	}
	
	
	
	@Override
	public String toString() {
		return "Stock [purchase=" + purchase + ", sell=" + sell + ", profit=" + profit + "]";
	}
	
}