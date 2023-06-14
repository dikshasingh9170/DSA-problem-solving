//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    public static long findSubarray(long[] arr ,int n) 
    {
        int count=0;
        long prefix=0;
        HashMap<Long,Integer> hm=new HashMap<Long,Integer>();
        for(int i=0;i<n;i++){
            prefix+=arr[i];
            if(prefix==0){
                count++;
            }
            if(hm.containsKey(prefix)){
                count+=hm.get(prefix);
            }
            hm.put(prefix,hm.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}