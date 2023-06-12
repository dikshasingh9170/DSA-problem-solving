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
        ArrayList<Long> temp=new ArrayList<>();
        int low=left;
        int high=mid+1;
        long count=0;
        while(low<=mid && high<=right){
            if(arr[low]<=arr[high]){
                temp.add(arr[low]);
                low++;
            }
            else{
                temp.add(arr[high]);
                count+=mid+1-low;
                high++;
            }
        }
     while(low<=mid){
            temp.add(arr[low]);
            low++;
            
        } 
        while(high<=right){
            temp.add(arr[high]);
            high++;
        } 
        for(int i=left;i<=right;i++){
            arr[i]=temp.get(i-left);
        }
        return count;
    }
}
