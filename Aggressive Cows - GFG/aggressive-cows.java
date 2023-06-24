//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s=0;
        int maxi=-1;
        /*for(int i=0;i<n;i++){
            maxi=Math.max(maxi,stalls[i]);
        }*/
        int e=stalls[n-1];
        int ans=-1;
        int mid=s+(e-s)/2;
        while(s<=e){
            if(isPossible(n,k,stalls,mid)){
                ans=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
            mid=s+(e-s)/2;
        }
        return ans;
    }
    public static boolean isPossible(int n, int k, int[] stalls,int mid){
        int count=1;
        int pos=stalls[0];
        for(int i=0;i<n;i++){
            if(stalls[i]-pos>=mid){
                count++;
                if(count==k){
                    return true;
                }
                pos=stalls[i];
            }
        }
        return false;
    }
}