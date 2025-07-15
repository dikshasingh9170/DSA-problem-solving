class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        solution(nums,result,arr,0);
        return result;
    }
    public void solution(int[] nums,List<List<Integer>> result,List<Integer> arr,int index){
        if(index==nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[index]);
        solution(nums,result,arr,index+1);
        arr.remove(arr.size()-1);
        solution(nums,result,arr,index+1);
    }
}