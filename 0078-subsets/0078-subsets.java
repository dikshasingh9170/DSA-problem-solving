//T.c 2^n
//s.c n
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        solve(0,nums,arr,res);
        return res;
    }
    public void solve(int i,int[] nums,List<Integer> arr,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        solve(i+1,nums,arr,res);
        arr.remove(arr.size()-1);
        solve(i+1,nums,arr,res);
    }
}
