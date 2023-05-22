//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends

class Solution {
    static long inversionCount(long arr[], long N) {
        return mergeSortAndCount(arr, 0,(int)(N - 1));
    }
    static long mergeSortAndCount(long[] arr,int left,int right){
        int mid=0;long count=0;
        if(left<right){
            mid=(left+right)/2;
            count+=mergeSortAndCount(arr,left,mid);
            count+=mergeSortAndCount(arr,mid+1,right);
            count+=mergeAndCount(arr,left,mid,right);
        }
        return count;
    }
    static long mergeAndCount(long[] arr,int left,int mid,int right){
        int leftlength=mid-left+1;
        int rightlength=right-mid;
        long[] leftarray=new long[leftlength];
        long[] rightarray=new long[rightlength];
        for(int i=0;i<leftlength;i++){
            leftarray[i]=arr[left+i];
        }
        for(int i=0;i<rightlength;i++){
            rightarray[i]=arr[mid+i+1];
        }
        int k=left;int j=0,i=0;long count=0;
        while(i<leftlength && j<rightlength){
            if(leftarray[i]<=rightarray[j]){
                arr[k++]=leftarray[i++];
            }
            else{
                arr[k++]=rightarray[j++];
                count+=(mid+1-left)-i;
            }
        }
        while(i<leftlength){
            arr[k++]=leftarray[i++];
        }
        while(j<rightlength){
            arr[k++]=rightarray[j++];
        }
        return count;
    }
}
