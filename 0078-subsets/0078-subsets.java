//T.c 2^n
//s.c n
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> arr1=new ArrayList<Integer>();
        solve(0,nums,arr,arr1);
        return arr;
    }
    public void solve(int i,int[] nums,List<List<Integer>> arr,List<Integer> arr1){
        if(i==nums.length){
            arr.add(new ArrayList<Integer>(arr1));
            return;
        }
        arr1.add(nums[i]);
        solve(i+1,nums,arr,arr1);
        arr1.remove(arr1.size()-1);
        solve(i+1,nums,arr,arr1);
    }
}
