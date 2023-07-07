//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        int m= s.length();
        int n= t.length();
        int[][] dp= new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j]= 0;
            }
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                } else {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        
        HashSet<String> hs= new HashSet<>();
        solve(m,n,s,t,dp,"",hs,dp[m][n]);
        
        List<String> ans= new ArrayList<>(hs);
        Collections.sort(ans);
        
        return ans;
    }
    
    public void solve(int m, int n, String s, String t, int[][] dp, String res, HashSet<String> hs, int r){
        if(res.length()==r){
            hs.add(res);
            return;
        }
        
        for(int i=m; i>0; i--){
            for(int j=n; j>0; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    solve(i-1,j-1,s,t,dp,s.charAt(i-1)+res, hs,r);
                }
            }
        }
    }
}