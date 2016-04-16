/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class RK
{
	/**
	 * H[si-sn]=s[i]*b^n-1+s[i+1]*b^n-2+...s[i+n-1]*b^0
	 * Assume pattern length as 3 i.e n=3 
	 * H[s0-s2]= s[0]*b^2+s[1]*b^1+s[2]*b^0
	 * H[s1-s3]= (H[s0-s2]-s[0]*b^n-1)*b+s[3]
	 * 
	 * */
	public static int q=23;//modulo prime 
	public static double b=7;//base
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			String pattern="aba";
			String s="cskdhsaabayyy";
			int n=pattern.length();
			double hash = inithash(s,n);
			double phash = inithash(pattern,n);
			double rm=Math.pow(b,n-1);
			int pos=1;
			if(phash==hash){
				//compare character by character which is naive.
				System.out.println("Found");
			}
			while(pos+n<=s.length()){
				System.out.println("pos"+pos);
				hash=((hash-s.charAt(pos-1)*rm)*b)+s.charAt(pos+n-1);
				System.out.println("hash"+hash);
				if(phash==hash){
					//compare character by character which is naive.
					System.out.println("Found");
					break;
				} else {
					pos++;	
				}
					
			}
		}
		catch(Exception exp){
			System.out.println("Exception"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	static double inithash(String text,int len){
		double y=0;
		double count=len-1;
		int pos=0;
		while(count>=0){
			y=y+text.charAt(pos)*Math.pow(b,count);
			count--;
			pos++;
		}
		System.out.println("hash in init"+y);
		return y;
	}
}