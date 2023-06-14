//4 approaches
//1:-time O(n2) space:-O(1)
//iterate the array for each element and count the number of occurences
//2:-time O(n) space:-O(1)
//take hashmap store each element into it and then its occurences as value
//3:-Moore voting algorithm
//time:-O(n) space:-O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            if(candidate==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
            return candidate;
        
    }
}