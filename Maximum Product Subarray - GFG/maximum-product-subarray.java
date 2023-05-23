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
    long maxProduct(int[] arr, int n) {
        long maxLeft=1, maxRight=1;
        long max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(maxLeft==0) maxLeft=1;
            if(maxRight==0) maxRight=1;
            maxLeft*=arr[i];
            maxRight*=arr[n-i-1];
            max = Math.max(max, Math.max(maxLeft, maxRight));
        }
        return max;  //t.c. ->O(n); s.c.->O(1)
    }
}