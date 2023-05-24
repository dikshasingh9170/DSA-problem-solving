//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    static long trappingWater(int arr[], int n) { 
        int[] max1=new int[n];
        int[] max2=new int[n];
        max1[0]=arr[0];
        max2[n-1]=arr[n-1];
        int k1=0,k2=0;
        for(int i=1;i<arr.length;i++){
                max1[i]=Math.max(arr[i],max1[i-1]);
        }
        for(int i=arr.length-2;i>=0;i--){
                max2[i]=Math.max(arr[i],max2[i+1]);
        }
        long count=0;
        for(int i=0;i<n;i++){
            count+=(long)Math.min(max1[i],max2[i])-arr[i];
        }
        return count;
    } 
}


