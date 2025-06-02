class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int n=nums.length;
        int diff=0;
        Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            diff=target-nums[i];
            if(hm.containsKey(diff)){
                res[0]=i;
                res[1]=hm.get(diff);
                return res;
            }
            hm.put(nums[i],i);
        }
        return res;
    }
}