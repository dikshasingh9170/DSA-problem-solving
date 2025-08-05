class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero=false;
        boolean colZero=false;
        int rowLength=matrix[0].length;
        int colLength=matrix.length;
        for(int i=0;i<rowLength;i++){
            if(matrix[0][i]==0){
                rowZero=true;
            }
        }
        for(int i=0;i<colLength;i++){
            if(matrix[i][0]==0){
                colZero=true;
            }
        }
        for(int i=1;i<colLength;i++){
            for(int j=1;j<rowLength;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<colLength;i++){
            for(int j=1;j<rowLength;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero==true){
            for(int i=0;i<rowLength;i++){
                matrix[0][i]=0;
            }
        }
        if(colZero==true){
            for(int i=0;i<colLength;i++){
                matrix[i][0]=0;
            }
        }
    }
}