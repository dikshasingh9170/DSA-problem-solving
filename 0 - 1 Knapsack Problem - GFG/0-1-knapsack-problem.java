//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


/*class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[] dp=new int[W+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                dp[i]=dp[i-1];
                if(wt[i]<=j){
                    dp[j]=Math.max(val[j]+dp[j-wt[i]],dp[j]);
                }
            }
        }
        return dp[W];
    } 
}*/


class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[] dp = new int[W + 1];
        for(int i=wt[0]; i<=W; i++){
            dp[i] = val[0];
        } 
        for (int i = 1; i <n; i++) {
            for (int w=W;w>=0;w--) {
                if (wt[i] <= w){
                    dp[w]= Math.max(dp[w],dp[w-wt[i]]+ val[i]);
                }
            }
        }
        return dp[W]; 
    }
}

