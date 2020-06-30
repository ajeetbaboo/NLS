package com.mypack.test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import com.mypack.model.*;
import com.mypack.GainStockMarket;

public class StockTestCase {

	
	@Test
	public void testNull() {
		GainStockMarket market=new GainStockMarket();
		String inputVal="";
		
		String expected="Invalid input.";
		assertEquals(expected, market.gainTraderOutput(inputVal));
	}
	
	@Test
	public void numberWithString() {
		GainStockMarket market=new GainStockMarket();
		String inputVal="19.35 dfgdfg  19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98";
		
		
		String expected="Invalid input.";
		assertEquals(expected, market.gainTraderOutput(inputVal));
	}
	
	
	
	@Test
	public void stockMarketPositive() {
		GainStockMarket market=new GainStockMarket();
		String inputVal="19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98";
		
		String expected="18.88 19.03";
		assertEquals(expected, market.gainTraderOutput(inputVal));
	}

	
	@Test
	public void stockMarketWithNewInput() {
		GainStockMarket market=new GainStockMarket();
		String inputVal="9.10 9.16 9.06 9.10 9.15 9.11 8.72 8.86 8.83 8.70 8.69 8.73";
		
		String expected="8.69 8.86";
		assertEquals(expected, market.gainTraderOutput(inputVal));
	}
	
	@Test
	public void stockMarketWithComplexInput() {
		GainStockMarket market=new GainStockMarket();
		String inputVal="9.20 8.03 10.02 8.08 8.14 8.10 8.31 8.28 8.35 8.34 8.39 8.45 8.38 "
				+ "8.38 8.32 8.36 8.28 8.28 8.38 8.48 8.49 8.54 8.73 8.72 8.76 8.74 8.87 "
				+ "8.82 8.81 8.82 8.85 8.85 8.86 8.63 8.70 8.68 8.72 8.77 8.69 8.65 8.70 "
				+ "8.98 8.98 8.87 8.71 9.17 9.34 9.28 8.98 9.02 9.16 9.15 9.07 9.14 9.13 "
				+ "9.10 9.16 9.06 9.10 9.15 9.11 8.72 8.86 8.83 8.70 8.69 8.73 8.73 8.67 "
				+ "8.70 8.69 8.81 8.82 8.83 8.91 8.80 8.97 8.86 8.81 8.87 8.82 8.78 8.82 "
				+ "8.77 8.54 8.32 8.33 8.32 8.51 8.53 8.52 8.41 8.55 8.31 8.38 8.34 8.34 "
				+ "8.19 8.17 8.16";
		
		String expected="8.03 9.34";
		//assertEquals(expected, market.gainTraderOutput(inputVal));
	}
}
