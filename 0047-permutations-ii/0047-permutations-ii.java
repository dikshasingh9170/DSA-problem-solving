class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,res);
        return res;
    }
    public void solve(int i,int[] nums,List<List<Integer>> res){
        if(i==nums.length){
            List<Integer> ans=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
                ans.add(nums[j]);
            }
            if(!res.contains(new ArrayList<>(ans))){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(i!=j && nums[j-1]==nums[j])continue;
            swap(j,i,nums);
            solve(i+1,nums,res);
            swap(j,i,nums);
        }
    }
    public void swap(int x,int y,int[] nums){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}