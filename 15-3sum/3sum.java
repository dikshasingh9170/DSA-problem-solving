class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> res=new HashSet<>();
        for(int i=0;i<n;i++){
            int k=i+1;int j=n-1;
            int sum=0;
            while(k<j){
                List<Integer> ans=new ArrayList<>();
                sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ans.add(nums[i]);
                    ans.add(nums[k]);
                    ans.add(nums[j]);
                    res.add(ans);
                    k++;
                    j--;
                }
                else if(sum>0){
                    j--;
                }
                else{
                    k++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}