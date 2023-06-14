//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends
class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int [] color=new int[n];
        if(solve(0,graph,color,n,m)) return true;
        return false;
    }
    public static boolean isPossible(boolean[][] graph,int[] color,int node,int check){
        for(int i=0;i<graph.length;i++){
            if(i==node){
                for(int j=0;j<graph[0].length;j++){
                    if(graph[i][j] && i!=j){
                        if(color[j]==check) return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean solve(int node,boolean graph[][],int[] color,int n,int m){
        if(node==n){
            return true;
        }
        for(int col=1;col<=m;col++){
            if(isPossible(graph,color,node,col)){
                color[node]=col;
                if(solve(node+1,graph,color,n,m)) return true;
                else color[node]=0;
            }
        }
        return false;
    }
   
}