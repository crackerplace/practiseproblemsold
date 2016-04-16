/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TheSwap {
	
	public static void main(String args[]){
		
		//findMax();
		TheSwap sw = new TheSwap();
		//sw.generatePermutations(new StringBuffer("abc"),0);
		//sw.generatePermutationsOther("","abc");
		System.out.println("------------->"+sw.findMax(123,3));
	}
	 
	 public int findMax(int n, int K) {
	 	TreeSet<String>[] b = new TreeSet[K+1];
	    b[0]=new TreeSet<String>(Arrays.asList(new String[]{String.valueOf(n)}));
	    
	    for(int i=1; i<=K; i++){
	      b[i]=new TreeSet<String>();
	      System.out.println(b[i-1]);
	      for(String s:b[i-1]){
	        
	        char c[]=s.toCharArray();
	        for(int j=0; j<c.length; j++)for(int k=j+1; k<c.length; k++){
	          char d[]=c.clone(), t=d[j];
	          d[j]=d[k]; d[k]=t;
	          System.out.println(new String(d));
	          if(d[0]!='0')b[i].add(new String(d));
	        }
	        
	      }
	      
	    }
	    System.out.println(b[K]);
	    int r=-1;
	    for(String s:b[K]) r=Math.max(r,Integer.parseInt(s));
	    
	    return r;
	 }
	 
	 void recursivelyPermutate(StringBuffer s,int start){
	 	//System.out.println(start+" "+s);
	 	if(start==s.length()-1){
	 		System.out.println(s);
	 		System.out.println("");
	 		return;
	 	}
	 	for(int i=start;i<s.length();i++){
	 		//System.out.println(i+" "+j);
	 		swap(s,start,i);
	 		recursivelyPermutate(s,start+1);
	 		//System.out.println(s);
	 		swap(s,start,i);
	 	}
	 	
	 }
	 
	 void recursivelyPermutate(String prefix,String s){
	 	//System.out.println(start+" "+s);
	 	if(s.length()==0){
	 		System.out.println(s);
	 		System.out.println("");
	 		return;
	 	}
	 	for(int i=0;i<prefix.length();i++){
	 		//System.out.println(i+" "+j);
	 		recursivelyPermutate(prefix+s.charAt(i),s.substring(0,i)+s.substring(i,s.length()));
	 		//System.out.println(s);
	 	}
	 	
	 }
	 
	 /*gp s,0
	 	sw s,0,0      -- abc
	 		gp s,1
	 			sw s,1,1   -- abc 
	 				gp s,2 -- abc
	 			sw s,1,1
	    		
	    		sw s,1,2   -- acb
	        		gp s,2 -- acb
	    		sw s,1,2   -- abc    
 		sw s,0,0     --  abc       
		

	 */
	 void swap(StringBuffer str,int src,int des){
	 	char t = str.charAt(src);
	 	str.setCharAt(src,str.charAt(des));
	 	str.setCharAt(des,t);
	 }
}