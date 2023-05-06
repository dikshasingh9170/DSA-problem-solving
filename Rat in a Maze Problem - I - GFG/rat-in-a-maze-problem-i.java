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
        boolean[][] vis=new boolean[n][n];
        res=new ArrayList<String>();
        if(m[0][0]==0){
            return res;
        }
        String s="";
        findpaths(0,0,m,n,vis,s);
        return res;
    }
    public static void findpaths(int i,int j,int[][] m,int n,boolean[][] vis,String s){
        if(i==n-1 && j==n-1){
            res.add(s);
            return;
        }
        else{
            vis[i][j]=true;
        }
        if(isvalid(i+1,j,n,m) && vis[i+1][j]==false){
            findpaths(i+1,j,m,n,vis,s+'D');
        }
        if(isvalid(i-1,j,n,m) && vis[i-1][j]==false){
            findpaths(i-1,j,m,n,vis,s+'U');
        }
        if(isvalid(i,j-1,n,m) && vis[i][j-1]==false){
            findpaths(i,j-1,m,n,vis,s+'L');
        }
        if(isvalid(i,j+1,n,m) && vis[i][j+1]==false){
            findpaths(i,j+1,m,n,vis,s+'R');
        }
        vis[i][j]=false;
    }
     public static boolean isvalid(int i,int j,int n,int[][] m){
        if(i>=0 && i<=n-1 && j>=0 && j<=n-1 && m[i][j]==1){
            return true;
        }
        return false;
    }
}