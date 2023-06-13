class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(i,j,board.length,board[0].length,board,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(int i,int j,int m,int n,char[][] board,String word,int k){
        if(k==word.length()){
            return true;
        }
         if(i<0 || j<0 || i==m || j==n || board[i][j]!=word.charAt(k)){
            return false;
        }
        board[i][j]='#';
        boolean op1=search(i+1,j,m,n,board,word,k+1);
        boolean op2=search(i,j+1,m,n,board,word,k+1);
        boolean op3=search(i-1,j,m,n,board,word,k+1);
        boolean op4=search(i,j-1,m,n,board,word,k+1);
        board[i][j]=word.charAt(k);
        return op1 || op2 || op3 || op4;
    }
}