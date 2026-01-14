class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1) && board[i][j]=='O'){
                    dfs(i,j,board);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] grid){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]!='O'){
            return;
        }
        grid[i][j]='#';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}