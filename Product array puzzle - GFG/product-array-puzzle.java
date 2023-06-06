//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
	    long[] res=new long[n];
	    long product=1;int flag=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                flag++;
                continue;
            }
            product*=nums[i];
        }
        for(int i=0;i<n;i++){
            if(flag==1){
                if(nums[i]!=0){
                    res[i]=0;
                }
                else{
                    res[i]=product;
                }
            }
            else if(flag==2){
                res[i]=0;
            }
            else if(flag==0){
                res[i]=product/(long)nums[i];
            }
        }
        return res;
	} 
} 
