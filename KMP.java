/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class KMP
{
  public static void main(String[] args) {
    match("helloababadaccc","ababaa");
  }
  
  static void match(String text,String pattern){
  	int[] fail = fail(pattern.toCharArray());
  	int x=0;
  	int y=0;
  	int patternLen =pattern.length();
  	while(x<text.length()){
  		if(text.charAt(x)==pattern.charAt(y)){
  			System.out.println("match"+x+" "+y);
  			if(y==(patternLen-1)){
  				System.out.println("found");
  				break;
  			}
  			x++;
  			y++;
  		} else {
  			System.out.println("!matching"+x+" "+y);
  			if(y!=0){
  				y=fail[y-1]; 	
  			} else {
  				x++;
  			}
  			System.out.println("!matching : fail process : "+x+" "+y);
  		}
  	}
  }
  
  static int[] fail(char[] a){
		int[] lps=new int[a.length];
		int x=0;
		int y=1;
		//int len=0;
		lps[0]=0;
		while(y<a.length){
			if(a[x]==a[y]){
				x++;
				lps[y]=x;
				y++;
			} else {
				if(x!=0){
					x=lps[x-1];
				} else {
					lps[y]=0;
					y++;
				}
			}
			
		}
		for(int el:lps){
			System.out.println(el);
		}
		return lps;
	}
}