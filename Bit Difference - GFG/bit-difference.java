//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        /*int count=0;
        while(a>0 || b>0){
            if((a&1)!=(b&1)){
                count++;
            }
            a=a>>1;
            b=b>>1;
        }
        return count;*/
        int count=0;
        int xor=a^b;
        while(xor>0){
            xor=xor&(xor-1);
            count++;
        }
        return count;
    }
    
    
}


//{ Driver Code Starts.

// Driver class
class Main {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int m, n;
		long ans = 0; // initialise ans to 0
		while(t-->0) {
		    
		    //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    Solution obj = new Solution();
		    System.out.println(obj.countBitsFlip(m, n));
		}
	}
}


// } Driver Code Ends