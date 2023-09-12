class Solution {
    public int[] sortArray(int[] nums) {
        int N=nums.length;
        for(int i=(N/2)-1;i>=0;i--){
            heapify(nums,i,N);
        }
        for(int i=N-1;i>0;i--){
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            heapify(nums,0,i);
        }
        return nums;
    }
    public void heapify(int[] nums,int i,int n){
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && nums[l]>nums[largest]){
            largest=l;
        }
        if(r<n && nums[r]>nums[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp=nums[i];
            nums[i]=nums[largest];
            nums[largest]=temp;
            heapify(nums,largest,n);
        }
    }
}
