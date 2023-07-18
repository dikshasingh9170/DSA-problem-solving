//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    
	    int mini=Integer.MAX_VALUE;int maxi=Integer.MIN_VALUE;
	    PriorityQueue<node> p=new PriorityQueue<node>();
	    int res[] = new int[2];
	    for(int i=0;i<k;i++){
	        int ele=KSortedArray[i][0];
	        mini=Math.min(ele,mini);
	        maxi=Math.max(ele,maxi);
	        p.add(new node(ele,i,0));
	    }
	    int start=mini;int end=maxi;
	    while(!p.isEmpty()){
	        node x=p.poll();
	        int row=x.row;
	        int col=x.col;
	        mini=x.data;
	        if(maxi-mini<end-start){
	            start=mini;
	            end=maxi;
	        }
	        if(col+1<KSortedArray[row].length){
	            maxi = Math.max(maxi, KSortedArray[row][col+1]);
	            p.add(new node(KSortedArray[row][col+1],row,col+1));
	        }
	        else{
	            break;
	        }
	    }
	    res[0] = start;
	    res[1] = end;
	    return res;
	}
}



class node implements Comparable<node>{
    int data;
    int row;
    int col;
    node(int data,int row,int col){
        this.data=data;
        this.row=row;
        this.col=col;
    }
    public int compareTo(node n){
        return this.data-n.data;
    }
}


 