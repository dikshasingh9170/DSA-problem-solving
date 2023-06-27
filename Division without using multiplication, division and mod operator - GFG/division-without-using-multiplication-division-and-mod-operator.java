//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GfG {
    

	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String S[] = br.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            
            long b = Long.parseLong(S[1]);
	       
	    	Solution ob = new Solution();
           
            System.out.println(ob.divide(a,b));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long divide(long a, long b)
    {
        boolean sign=(a>=0)==(b>=0)?true:false;
        a=Math.abs(a);
        b=Math.abs(b);long result=0;
        while(a-b>=0){
            long count=0;
            while(a-(b<<1<<count)>=0){
                count++;
            }
            result+=1<<count;
            a-=b<<count;
        }
        return sign?result:-result;
    }
}