class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        solution(nums,arr,res);
        return res;
    }
    public void solution(int[] nums,List<Integer> arr,List<List<Integer>> res){
        if(arr.size()==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(arr.contains(nums[i]))continue;

            arr.add(nums[i]);
            solution(nums,arr,res);
            arr.remove(arr.size()-1);
        }
    }
}