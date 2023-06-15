class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String s="";
        for(int i=0;i<n;i++){
            s+='.';
        }
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(s);
        }
        helper(board, ans, 0, n);
        return ans;
    }
    public void helper(List<String> board, List<List<String>> ans, int row, int size) {
        if (row == size) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (checkValid(board, row, i, size)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(i, 'Q');
                board.set(row, sb.toString());
                helper(board, ans, row + 1, size);
                sb.setCharAt(i, '.'); 
                board.set(row, sb.toString());
            }
        }
    }
    public boolean checkValid(List<String> board, int row, int col, int size) {
            // Check straight up
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check diagonals
        for (int i = 1; i <= row; i++) {
            if (col - i >= 0) {
                // Left diagonal
                if (board.get(row - i).charAt(col - i) == 'Q') {
                    return false;
                }
            }
            if (col + i < size) {
                // Right diagonal
                if (board.get(row - i).charAt(col + i) == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
}

