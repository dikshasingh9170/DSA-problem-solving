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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int tx=TargetPos[0]-1;
        int ty=TargetPos[1]-1;
        int kx=KnightPos[0]-1;
        int ky=KnightPos[1]-1;
        Queue<cell> q=new LinkedList<>();
        if(tx==kx && ky==ty){
            return 0;
        }
        boolean[][] vis=new boolean[N+1][N+1];
        q.add(new cell(kx,ky,0));
        vis[kx][ky]=true;
        int[] ax={1,1,-1,-1,2,2,-2,-2};
        int[] bx={2,-2,2,-2,1,-1,-1,1};
        while(!q.isEmpty()){
            cell t=q.poll();
            if(t.x==tx && t.y==ty){
                return t.ans;
            }
            for(int i=0;i<8;i++){
                if(isvalid(t.x+ax[i],t.y+bx[i],N) && vis[t.x+ax[i]][t.y+bx[i]]==false){
                    vis[t.x+ax[i]][t.y+bx[i]]=true;
                    q.add(new cell(t.x+ax[i],t.y+bx[i],t.ans+1));
                }
            }
        }
        return -1;
    }
    public boolean isvalid(int x,int y,int N){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }
}
class cell{
    int x,y,ans;
    public cell(int x,int y,int ans){
        this.x=x;
        this.y=y;
        this.ans=ans;
    }
}