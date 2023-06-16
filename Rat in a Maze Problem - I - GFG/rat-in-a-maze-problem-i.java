//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    static  ArrayList<String> res;
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res=new ArrayList<String>();
        if(n<=1){
            return res;
        }
        String s="";
        solve(0,0,s,m,res,n);
        return res;
    }
    public static void solve(int i,int j,String s,int[][] m,ArrayList<String> res,int n){
        if(i<0 || j<0 || i>=n || j>=n || m[i][j]==0){
            return;
        }
        if(i==n-1 && j==n-1){
            res.add(s);
        }
        m[i][j]=0;
        solve(i+1,j,s+'D',m,res,n);
        solve(i,j+1,s+'R',m,res,n);
        solve(i-1,j,s+'U',m,res,n);
        solve(i,j-1,s+'L',m,res,n);
        m[i][j]=1;
        return;
    }
}
