class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<Integer>();
        boolean[] freq=new boolean[nums.length];
        permutation(nums,freq,ans,res);
        return res;
    }
    public void permutation(int[] nums,boolean[] freq,List<Integer> ans,List<List<Integer>> res){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ans.add(nums[i]);
                permutation(nums,freq,ans,res);
                ans.remove(ans.size()-1);
                freq[i]=false;
            }
        }
    }
}