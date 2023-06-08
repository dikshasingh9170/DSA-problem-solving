class Solution {
    public int[] sortArray(int[] nums) {
        int N = nums.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(nums, N, i);

        for (int i = N - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;
    }
    public void heapify(int arr[], int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < N && arr[l] > arr[largest])
            largest = l;
        
        if (r < N && arr[r] > arr[largest])
            largest = r;
        
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }
}
