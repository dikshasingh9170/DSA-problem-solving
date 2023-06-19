//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Pair{
    int sidx;
    int lidx;
    public Pair(int sidx,int lidx){
        this.sidx=sidx;
        this.lidx=lidx;
    }
}
class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
        Arrays.sort(intervals,(arr1,arr2)->arr1[0]-arr2[0]);
        Stack<Pair> s=new Stack<>();
        for(int i=0;i<intervals.length;i++){
            if(s.isEmpty() || s.peek().lidx<intervals[i][0]) s.push(new Pair(intervals[i][0],intervals[i][1]));
            else{
                Pair curr=s.pop();
                curr.lidx=Math.max(curr.lidx,intervals[i][1]);
                s.push(curr);
            }
        }
        int[][] ans=new int[s.size()][2];
        int i=ans.length-1;
        while(!s.isEmpty()){
            Pair curr=s.pop();
            ans[i][0]=curr.sidx;
            ans[i][1]=curr.lidx;
            i--;
        }
        return ans;
    }
}