//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int[][] t=new int[str.length()][str.length()];
        return solve(str,0,str.length()-1,t);
    }
    static int solve(String S,int i,int j,int[][] t){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(S,i,j)==true){
            return 0;
        }
        if(t[i][j]!=0){
            return t[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int left=0,right=0;
            if(t[i][k]!=0){
                left=t[i][k];
            }
            else{
                left=solve(S,i,k,t);
                t[i][k]=left;
            }
            
            if(t[k+1][j]!=0){
                right=t[k+1][j];
            }
            else{
                right=solve(S,k+1,j,t);
                t[k+1][j]=right;
            }
            int temp=left+right+1;
            min=Math.min(temp,min);
        }
        return t[i][j]=min;
    }
    static boolean isPalindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--))return false;
        }
        return true;
    }
}