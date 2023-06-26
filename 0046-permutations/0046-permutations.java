class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //tc :- n!*n
        List<List<Integer>> res=new ArrayList<>();
        solve(0,nums,res);
        return res;
    }
    public void solve(int i,int[] nums,List<List<Integer>> res){
        if(i==nums.length){
            List<Integer> arr=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
                arr.add(nums[j]);
            }
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int j=i;j<nums.length;j++){
            swap(i,j,nums);
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
//t.c for this code is n!*n
        //s.c is o(n)+O(n)
        /*List<List<Integer>> res=new ArrayList<>();
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
        }*/