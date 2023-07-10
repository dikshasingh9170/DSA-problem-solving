//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] t=new int[N][N];
        int min=Integer.MAX_VALUE;
        return solve(1,N-1,arr,min,t);
    }
    static int solve(int i,int j,int arr[],int min,int[][] t){
        if(i>=j){
            return 0;
        }
        if(t[i][j]!=0){
            return t[i][j];
        }
        for(int k=i;k<j;k++){
            int temp=solve(i,k,arr,min,t)+solve(k+1,j,arr,min,t)+(arr[i-1]*arr[k]*arr[j]);
            min=Math.min(temp,min);
        }
        return t[i][j]=min;
    }
}