class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int l=j+1;int k=n-1;
                while(l<k){
                    long x=nums[i];
                        x+=nums[j];
                        x+=nums[k];
                        x+=nums[l];
                    if(x==target){
                        List<Integer> ans=new ArrayList<Integer>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans.add(nums[l]);
                        res.add(ans);
                        l++;
                        k--;
                        while(l<k && nums[l]==nums[l-1])l++;
                        while(l<k && nums[k]==nums[k+1])k--;
                    }
                    else if(x<target){
                        l++;
                    }
                    else{
                        k--;
                    }
                }
            }
        }
        return res;
    }
}