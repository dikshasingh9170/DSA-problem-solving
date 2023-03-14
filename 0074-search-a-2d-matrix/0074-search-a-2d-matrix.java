class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int head=0;int tail=(matrix.length*matrix[0].length)-1;
        while(head<=tail){
            int mid=(head+tail)/2;
            int midrow=(mid/matrix[0].length);
            int midcol=(mid%matrix[0].length);
            if(matrix[midrow][midcol]==target){
                return true;
            }
            else if(matrix[midrow][midcol]<target){
                head=mid+1;
            }
            else if(matrix[midrow][midcol]>target){
                tail=mid-1; 
            }          
        }
        return false;
    }
}