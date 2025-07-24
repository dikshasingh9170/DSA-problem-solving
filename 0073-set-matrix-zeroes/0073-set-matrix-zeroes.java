class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix[0].length;
        int col=matrix.length;
        boolean firstRow=false;
        boolean firstCol=false;
        for(int i=0;i<row;i++){
            if(matrix[0][i]==0){
                firstRow=true;
            }
        }
        for(int j=0;j<col;j++){
            if(matrix[j][0]==0){
                firstCol=true;
            }
        }
        for(int i=1;i<col;i++){
            for(int j=1;j<row;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<col;i++){
            for(int j=1;j<row;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
         if(firstRow) {
            for(int j = 0; j < row; j++)
                matrix[0][j] = 0;
        }

        if(firstCol) {
            for(int i = 0; i < col; i++)
                matrix[i][0] = 0;
        }
    }
}