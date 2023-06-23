//O(n^3) space O(1);
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int l=j+1;int k=nums.length-1;
                while(l<k){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[l];
                    sum+=nums[k];
                    if(sum==target){
                        ArrayList<Integer> arr=new ArrayList<Integer>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[l]);
                        arr.add(nums[k]);
                        res.add(arr);
                        l++;
                        k--;
                        while(l<k && nums[l]==nums[l-1])l++;
                        while(l<k && nums[k]==nums[k+1])k--;
                    }
                    else if(sum<target){
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        