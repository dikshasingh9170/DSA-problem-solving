//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        boolean[] dfsvisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(solution(adj,dfsvisited,visited,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solution(ArrayList<ArrayList<Integer>> adj,boolean[] dfsvisited,boolean[] visited,int i){
        visited[i]=true;
        dfsvisited[i]=true;
        for(int it:adj.get(i)){
            if(visited[it]==false){
                if(solution(adj,dfsvisited,visited,it)){
                    return true;
                }
            }
            else if(visited[it]==true && dfsvisited[it]==true){
                return true;
            }
        }
        dfsvisited[i]=false;
        return false;
    }
}