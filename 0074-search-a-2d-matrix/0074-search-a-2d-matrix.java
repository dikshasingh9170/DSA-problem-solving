class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        for(int i=0;i<n;i++){
            if(target<=matrix[i][m-1]){
                row=i;
                break;
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[row][j]==target){
                return true;
            }
        }
        return false;
    }
}