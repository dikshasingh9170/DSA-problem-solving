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
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        boolean[][] vis=new boolean[N+1][N+1];
        int kx=KnightPos[0]-1;
        int ky=KnightPos[1]-1;
        int tx=TargetPos[0]-1;
        int ty=TargetPos[1]-1;
        if(kx==tx && ky==ty){
            return 0;
        }
        Queue<cell> q=new LinkedList<cell>();
        q.add(new cell(kx,ky,0));
        vis[kx][ky]=true;
        while(!q.isEmpty()){
            cell z=q.poll();
            int[] a={1,1,-1,-1,2,2,-2,-2};
            int[] b={2,-2,2,-2,1,-1,1,-1};
            for(int i=0;i<8;i++){
                if(z.x==tx && z.y==ty){
                    return z.ans;
                }
                else{
                    if(isvalid(z.x+a[i],z.y+b[i],N) && vis[z.x+a[i]][z.y+b[i]]==false){
                        vis[z.x+a[i]][z.y+b[i]]=true;
                        q.add(new cell(z.x+a[i],z.y+b[i],z.ans+1));
                    }
                }
            }
        }
        return -1;
    }
    public boolean isvalid(int i,int j,int N){
        if(i>=0 && i<=N-1 && j>=0 && j<=N-1){
            return true;
        }
        return false;
    }
}
class cell{
    int x,y,ans;
    public cell(int x,int y, int ans){
        this.x=x;
        this.y=y;
        this.ans=ans;
    }
}
