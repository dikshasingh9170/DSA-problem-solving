class Solution {
    public int maximumLength(int[] nums) {
        int countEven = 0, countOdd = 0;
        for (int num : nums) {
            if (num % 2 == 0) countEven++;
            else countOdd++;
        }
        int maxSameParity = Math.max(countEven, countOdd);
        int maxAlt = 1;  
        int lastParity = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int currentParity = nums[i] % 2;
            if (currentParity != lastParity) {
                maxAlt++;
                lastParity = currentParity;
            }
        }
        return Math.max(maxSameParity, maxAlt);
    }
}
// odd odd odd odd
// odd even odd even
// even odd even odd
// even even even even

// 1 5 9 4 2    // 1 9 4 2     // 1 5 9 2  //
// 0 0 1 0      // 0 1 0       // 0 0 1

