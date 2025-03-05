/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<Pair> st=new Stack<Pair>();
        int res=0;
        int ans=0;
        while(!st.isEmpty() || root!=null){
            if(root!=null){
                st.push(new Pair(root,res));
                root=root.left;
                res++;
            }
            else{
                root=st.peek().root;
                res=st.peek().res;
                ans=Math.max(res,ans);
                st.pop();
                root=root.right;
                res++;
            }
        }
        return 1+ans;
    }
}
class Pair{
    TreeNode root;
    int res;
    Pair(TreeNode root,int res){
        this.root=root;
        this.res=res;
    }
}