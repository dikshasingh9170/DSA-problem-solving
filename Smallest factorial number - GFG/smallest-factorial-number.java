//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        int l=0;int r=5*n;int ans=l;
        while(l<=r){
            int mid=(l+r)/2;
            if(solve(mid)>=n){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    int solve(int n){
        int ans=0;int div=5;
        while(n>=div){
            ans+=n/div;
            div=div*5;
        }
        return ans;
    }
}