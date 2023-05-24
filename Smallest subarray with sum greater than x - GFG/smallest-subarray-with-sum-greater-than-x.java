//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends

class Solution {
    public static int smallestSubWithSum(int a[], int n, int x) {
        int i = 0, j = 0, curSum = 0, res = Integer.MAX_VALUE;
        while (i < n) {
            if (curSum > x) {
                if (j-i < res) {
                    res = j-i;
                }
                curSum -= a[i];
                i++;
            } else if (j < n && curSum <= x) {
                curSum += a[j];
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}