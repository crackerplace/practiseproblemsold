/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class QuickSort			
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] a = new int[]{8,5,6,7,3,11,12};
		quicksort(a,0,a.length-1);// your code goes here
		/*for(int x:a){
			System.out.println(x);
		}*/
		//System.out.println(partition(new int[]{3,5,6,7},0,3));
	}
	
	static void quicksort(int[] a ,int lo,int hi){
		if(lo>=hi)
			return;
		int partition=partition(a,lo,hi);
		/*for(int x:a){
			System.out.println(x);
		}*/
		quicksort(a,lo,partition-1);
		quicksort(a,partition+1,hi);
	}
	
	static int partition(int[] a,int lo,int hi){
		int pivot=a[lo];
		int right=lo,left=hi;
		while(right<left){
			System.out.println("pivot " + pivot);
			while(a[right]<pivot){
				//System.out.println("right "+right);
				right++;
			}
			while(a[left]>pivot){
				//System.out.println("left "+left);
				left--;
			}
			System.out.println("right " +right + " left "+left);
			if(right<left){
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				right++;
				left--;
			}
		}
		System.out.println(right+"       "+left);
		for(int x:a){
			System.out.println(x);
		}
		return right;
	}
	
}