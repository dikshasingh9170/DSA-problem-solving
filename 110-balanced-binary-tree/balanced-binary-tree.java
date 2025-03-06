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
    public boolean isBalanced(TreeNode root) {
        int res=Balanced(root);
        if(res==-1){
            return false;
        }
        return true;
    }
    public int Balanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=Balanced(root.left);
        int rh=Balanced(root.right);
        if(lh==-1 || rh==-1){
            return -1;
        }
        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
}