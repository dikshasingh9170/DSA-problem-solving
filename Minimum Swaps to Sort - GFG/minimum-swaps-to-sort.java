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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends








class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int i=0;
        int res = 0;
        while(i<nums.length){
            if(map.get(nums[i]) == i) i++;
            
            else{
                int temp = nums[map.get(nums[i])];
                nums[map.get(nums[i])] = nums[i];
                nums[i]= temp;
                res++;
            }
        }
        return res;
    }
}