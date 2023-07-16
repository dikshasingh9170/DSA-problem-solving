class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length];
        for(int i=0;i<days.length;i++)
            dp[i]=-1;
        return solve(days,costs,0,dp);
    }
    public int solve(int[] days, int[] costs,int ind, int dp[])
    {
        if(ind>=days.length)
            return 0;
        if(dp[ind]!=-1)
           return dp[ind];
        int d1=costs[0]+solve(days,costs,ind+1,dp);
        
        int i=0;
        for(i=ind;i<days.length&&days[i]<days[ind]+7;i++);
        int d7=costs[1]+solve(days,costs,i,dp);    
        
        for( i=ind;i<days.length&&days[i]<days[ind]+30;i++);
        int d30=costs[2]+solve(days,costs,i,dp);    

        dp[ind]= Math.min(d1,Math.min(d7,d30));
        return dp[ind];
    }
}
