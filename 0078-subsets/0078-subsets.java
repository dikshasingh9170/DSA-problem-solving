class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        powerset(0,nums,res,arr);
        return res;
    }
    public void powerset(int i,int[] nums, List<List<Integer>> res,ArrayList<Integer> arr){
        if(i==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        powerset(i+1,nums,res,arr);
        arr.remove(arr.size()-1);
        powerset(i+1,nums,res,arr);
    }
}
