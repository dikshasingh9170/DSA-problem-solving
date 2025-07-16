class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        solution(nums,visited,arr,res);
        return res;
    }
    public void solution(int[] nums,boolean[] visited,List<Integer> arr,List<List<Integer>> res){
        if(arr.size()==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;

            visited[i]=true;
            arr.add(nums[i]);
            solution(nums,visited,arr,res);
            arr.remove(arr.size()-1);
            visited[i]=false;
        }
    }
}