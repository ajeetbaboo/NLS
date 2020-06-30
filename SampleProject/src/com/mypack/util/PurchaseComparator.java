package com.mypack.util;
import java.util.*;
import com.mypack.model.*;

public class PurchaseComparator implements Comparator<Stock>{
	
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