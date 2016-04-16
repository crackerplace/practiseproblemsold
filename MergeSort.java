/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

import java.util.Iterator;
public class MergeSort
{
	public void sort(int[] a,int lo,int hi){
		int mid=lo+hi-lo/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	public void merge(int a[],int lo,int mid,int hi){
		int i=lo,j=mid+1;
		int[] aux = new int[hi-lo+1];
		for(int k=lo;k<=hi;k++)	{
			aux[k]=a[k];
		}
		for(int k=lo;k<=hi;k++)	{
			if(i>mid) a[k]=a[j++];
			else if(j>hi) a[k]=a[i++];
			else if(a[j]<a[i]) a[k]=a[j];
			else a[k]=a[i];
		}
	}
	
	
	
 
}