//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends




//User function Template for Java

class Pair implements Comparable<Pair> 
{
    int val,ap,vp;
    Pair(int val,int ap,int vp)
    {
        this.val = val;
        this.ap=ap;
        this.vp=vp;
    }
    public int compareTo(Pair p)
    {
        return this.val-p.val;
    }
    
}
class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
       ArrayList<Integer> al=new ArrayList<Integer>();
       PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
       for(int i=0;i<K;i++)
       {
           pq.add(new Pair(arr[i][0],i,0));
       }
       while(!pq.isEmpty())
       {
           Pair p = pq.poll();
           int val = p.val;
           int ap=p.ap;
           int vp=p.vp;
           al.add(val);
           if(vp+1<arr[ap].length)
           {
               pq.add(new Pair(arr[ap][vp+1],ap,vp+1));
           }
           
       }
       return al;
    }
}