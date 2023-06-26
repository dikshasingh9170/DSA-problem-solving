class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<String> board=new ArrayList<>();String s="";
        for(int i=0;i<n;i++){
            s+='.';
        }
        for(int i=0;i<n;i++){
            board.add(s);
        }
        solve(board,res,0,n);
        return res;
    }
    public void solve(List<String> board,List<List<String>> res,int row,int n){
        if(row==n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int i=0;i<n;i++){
            if(check(board,row,i,n)){
                StringBuilder sb=new StringBuilder(board.get(row));
                sb.setCharAt(i,'Q');
                board.set(row,sb.toString());
                solve(board,res,row+1,n);
                sb.setCharAt(i,'.');
                board.set(row,sb.toString());
            }
        }
    }
    public boolean check(List<String> board,int row,int col,int n){
        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for(int i=1;i<=row;i++){
            if(col-i>=0){
                if(board.get(row-i).charAt(col-i)=='Q'){
                    return false;
                }
            }
            if(col+i<n){
                if(board.get(row-i).charAt(col+i)=='Q'){
                    return false;
                }
            }
        }
        return true;
    }
}
        