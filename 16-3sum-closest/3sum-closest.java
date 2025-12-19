class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int k=i+1;int j=n-1;
            int sum=0;
            while(k<j){
                sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-ans)>Math.abs(target-sum)){
                    ans=sum;
                }
                if(sum>target){
                    j--;
                }
                else{
                    k++;
                }
            }
        }
        return ans;
    }
}