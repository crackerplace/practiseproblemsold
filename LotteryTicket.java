/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//http://apps.topcoder.com/wiki/display/tc/SRM+466 --Use Bitmasking
class LotteryTicket
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LotteryTicket lt = new LotteryTicket();
		System.out.println(lt.buy(10,1,5,10,50));
	}
	
	public String recursiveBuy(int price, int b1, int b2, int b3, int b4){
		String str = recursiveBuy(price,new ArrayList<Integer>(Arrays.asList(new Integer[]{b1,b2,b3,b4})));
		System.out.println(str);
		return str;
	}
	
	String buy(int price, int b1, int b2, int b3, int b4)
    {
        int a[] = new int[]{b1, b2, b3, b4};
    	for(int i=0; i<1<<4; i++){
    		int sum = 0;
      		for(int j=0; j<4; j++){
      			if((i&1<<j) > 0){
      				sum+=a[j];	
      			}
      		}
      		if(sum == price)
        		return "POSSIBLE";
    	}
    	return "IMPOSSIBLE";
    }
	
	String recursiveBuy(int price,ArrayList a){
		System.out.println("price : "+price + ",list"+a);
		if(price==0){
			return "POSSIBLE";
		} if(price<0 || a.size() ==0){
			return "IMPOSSIBLE";
		} else {
			ArrayList b = (ArrayList)a.clone();
			b.remove(0);
			String res0 = recursiveBuy(price-(int)a.get(0),b);
			System.out.println("------------>");
			String res1 = recursiveBuy(price,b);	
			if(res0 == "POSSIBLE" || res1 == "POSSIBLE"){
				return "POSSIBLE";
			}
		}
		return "IMPOSSIBLE";
	}


}