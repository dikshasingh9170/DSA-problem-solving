class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Arrays.sort(nums);
        powerset(0,nums,res,arr);
        return res;
    }
    public void powerset(int i,int[] nums, List<List<Integer>> res,ArrayList<Integer> arr){
        res.add(new ArrayList<>(arr));
        for(int index = i;index<nums.length;index++) {
            if(index!=i && nums[index] == nums[index-1]) continue; 
            arr.add(nums[index]); 
            powerset(index+1, nums, res, arr); 
            arr.remove(arr.size() - 1);
        }
    }
}
