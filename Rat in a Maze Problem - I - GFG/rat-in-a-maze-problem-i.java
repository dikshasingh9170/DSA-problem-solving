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
        res=new ArrayList<String>();
        if(m[0][0]==0){
            return res;
        }
        boolean[][] vis=new boolean[n][n];
        String s="";
        solve(0,0,n,m,s,vis);
        return res;
    }
    public static void solve(int i,int j,int n,int[][] m,String s,boolean[][] vis){
        if(i<0 || j<0 || i>n-1 || j>n-1 || m[i][j]==0 || vis[i][j]==true){
            return;
        }
        if(i==n-1 && j==n-1){
            res.add(s);
            return;
        }
        vis[i][j]=true;
        solve(i+1,j,n,m,s+'D',vis);
        solve(i-1,j,n,m,s+'U',vis);
        solve(i,j+1,n,m,s+'R',vis);
        solve(i,j-1,n,m,s+'L',vis);
        vis[i][j]=false;
        
        return;
    }
}
