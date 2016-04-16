/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


 class BinarySearch
{
	public static boolean bs(int[] a,int lo,int hi,int key){
			System.out.println(lo + " -- "+hi);
			int mid=lo+((hi-lo)/2);
		if(lo>hi){
			return false;
		}	
		if(key<a[mid]){
			bs(a,lo,mid-1,key);
		} else if (key>a[mid]) {
			bs(a,mid+1,hi,key);
		} else {
			System.out.println("Found at index "+mid);
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		int[] a = {2,6,7,8,11,22};
		bs(a,0,a.length-1,1);
	}
	
}