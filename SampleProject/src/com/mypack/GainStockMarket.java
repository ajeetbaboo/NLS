package com.mypack;

import java.text.DecimalFormat;
import java.util.*;
//This class created for maintaining the share purchase and sell with profit
//
class Stock{
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
//Filter the value on the basis of Purchasing so that minimum purchase amount can be found
class PurchaseComparator implements Comparator<Stock>{
	
	@Override
	public int compare(Stock o1, Stock o2) {
		if(o1.getPurchase()<o2.getPurchase()){
			return -1;
		}else if(o1.getPurchase()>o2.getPurchase()){
			return 1;
		}else{
			return 0;
		}
	}
}


//Filter the value on the basis of maximum profit so that maximum profit time can be found.
class ProfitComparator implements Comparator<Stock>{
	
	@Override
	public int compare(Stock o1, Stock o2) {
		if(o1.getProfit()<o2.getProfit()){
			return -1;
		}else if(o1.getProfit()>o2.getProfit()){
			return 1;
		}else{
			return 0;
		}
	}
}


public class GainStockMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Common Test Cases
		String inputVal11="";
		
		String inputVal12=null;
		
		//Test Case 1
		String inputVal="19.35 dfgdfg  19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98";
		
		// Test Case 2
		String inputVal2="9.10 9.16 9.06 9.05 9.15 9.11 8.72 8.86 8.83 8.70 8.69 8.73";
		
		// Test Case 3
		String inVal="9.20 8.03 10.02 8.08 8.14 8.10 8.31 8.28 8.35 8.34 8.39 8.45 8.38 "
				+ "8.38 8.32 8.36 8.28 8.28 8.38 8.48 8.49 8.54 8.73 8.72 8.76 8.74 8.87 "
				+ "8.82 8.81 8.82 8.85 8.85 8.86 8.63 8.70 8.68 8.72 8.77 8.69 8.65 8.70 "
				+ "8.98 8.98 8.87 8.71 9.17 9.34 9.28 8.98 9.02 9.16 9.15 9.07 9.14 9.13 "
				+ "9.10 9.16 9.06 9.10 9.15 9.11 8.72 8.86 8.83 8.70 8.69 8.73 8.73 8.67 "
				+ "8.70 8.69 8.81 8.82 8.83 8.91 8.80 8.97 8.86 8.81 8.87 8.82 8.78 8.82 "
				+ "8.77 8.54 8.32 8.33 8.32 8.51 8.53 8.52 8.41 8.55 8.31 8.38 8.34 8.34 "
				+ "8.19 8.17 8.16";
		
		
		GainStockMarket market=new GainStockMarket();
		System.out.println(market.gainTraderOutput(inputVal));
		
		
	}
	
	
public String gainTraderOutput(String listOfStock){
		
		if(listOfStock==null || listOfStock.isEmpty()){
			return "Invalid input.";
		}
	
		String stockList[]=listOfStock.split(" ");
		StringBuilder outputVal=new StringBuilder();
		
		float prev=0f;
		float next=0f;
		float diffs=0f;
		ArrayList<Stock> list=new ArrayList<>();
		ArrayList<Stock> listLoss=new ArrayList<>();
		for(int i=0;i<stockList.length-1;i+=2){
			try{
			prev=Float.parseFloat(stockList[i]);
			next=Float.parseFloat(stockList[i+1]);
			}catch(NumberFormatException ex){
				return "Invalid input.";
			}
			diffs=(next-prev);
			String valueDec="";
			
			if(diffs>0){
				valueDec=new DecimalFormat("##.####").format(diffs);
				Stock s1=new Stock(prev,next,Float.parseFloat(valueDec));
				list.add(s1);
			}else{
				valueDec=new DecimalFormat("##.####").format(diffs);
				Stock s1=new Stock(prev,next,Float.parseFloat(valueDec));
				listLoss.add(s1);
				
			}
		}
		//This sort is used for getting minimum purchase value.
		Collections.sort(list,new PurchaseComparator());
		outputVal.append(list.get(0).getPurchase());
		//This sort is used for getting maximum profit value.
		Collections.sort(list,new ProfitComparator());
		outputVal.append(" ");
		outputVal.append(list.get(list.size()-1).getSell());
		return outputVal.toString();
		
	}

}
