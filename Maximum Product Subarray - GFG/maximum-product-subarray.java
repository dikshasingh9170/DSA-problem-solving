//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long maxleft=1;
        long maxright=1;
        long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(maxleft==0)maxleft=1;
            if(maxright==0)maxright=1;
            maxleft*=arr[i];
            maxright*=arr[n-i-1];
            max=Math.max(max,Math.max(maxleft,maxright));
        }
        return max;
    }
}