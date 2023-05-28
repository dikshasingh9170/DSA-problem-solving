//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> list = new ArrayList<>();
        int size=1;
        int val=2;int carry=0;
        list.add(0,1);
        while(val<=N){
            for(int i=size-1;i>=0;i--){
                int temp=list.get(i)*val+carry;
                list.set(i,temp%10);
                carry=temp/10;
            }
            while(carry!=0){
                list.add(0,carry%10);
                carry=carry/10;
                size++;
            }
            val++;
        }
        return list;
    }
}
