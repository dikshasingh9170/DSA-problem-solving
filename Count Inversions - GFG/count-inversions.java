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


//User function Template for Java

class Solution
{
    static long inversionCount(long arr[], long N)
    {
        return mergeandcount(arr,0,(int)(N-1));
    }
    static long mergeandcount(long[] arr,int l,int r){
        long count=0;
        if(l<r){
            int mid=(l+r)/2;
            count+=mergeandcount(arr,l,mid);
            count+=mergeandcount(arr,mid+1,r);
            count+=merge(arr,l,mid,r);
        }
        return count;
    }
    static long merge(long[] arr,int l,int mid,int r){
        ArrayList<Long> temp=new ArrayList<Long>();
        long count=0;
        int low=l;
        int high=mid+1;
        while(low<=mid && high<=r){
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
        while(high<=r){
            temp.add(arr[high]);
            high++;
        }
        for(int i=l;i<=r;i++){
            arr[i]=temp.get(i-l);
        }
        return count;
    }
}