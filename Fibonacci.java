/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
class Fibonacci
{
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	static {
	      fibCache.add(BigInteger.ZERO);
	      fibCache.add(BigInteger.ONE);
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(fibC(4));
	}
	
	static int fib(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fib(n-1)+fib(n-2);	
	}
	
	static int fibIt(int n){
		int result=0;
		if(n<1)
			return n;
		int prev1=1;
		int prev2=0;
		for(int i=2;i<=n;i++){
			result=prev1+prev2;
			prev1=result;
			prev2=prev1;
		}
		return result;
	}
	
	public static BigInteger fibC(int n) {
        if (n >= fibCache.size()) {
            fibCache.add(n, (fibC(n-1)).add(fibC(n-2)));
        }
       return fibCache.get(n);
    }
       
}