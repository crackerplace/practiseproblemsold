/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MaxValueOfWines
{
	static int steps=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] w= {1, 4, 2, 3,5,11};
		int mv = mvw(w,0,w.length-1,1);
		System.out.println(mv+"  "+steps);
	}
	
	static int mvw(int[] w,int s,int e,int y){
		steps++;
		if(s==e){
			return y*w[s];
		}
		int max = Math.max(y*w[s]+mvw(w,s+1,e,y+1),y*w[e]+mvw(w,s,e-1,y+1));	
		return max;
	}
}