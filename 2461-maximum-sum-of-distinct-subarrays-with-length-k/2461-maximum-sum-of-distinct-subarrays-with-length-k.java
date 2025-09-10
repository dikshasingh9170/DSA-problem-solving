class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;
        
        for(int j=0;j<n;j++){
            int x=nums[j];
            while(elements.contains(x)){
                currentSum-=nums[begin];
                elements.remove(nums[begin]);
                begin++;
            }
            elements.add(x);
            currentSum+=x;
            if(j-begin+1>k){
                currentSum-=nums[begin];
                elements.remove(nums[begin]);
                begin++;
            }
            if(j-begin+1==k){
                maxSum=Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
}