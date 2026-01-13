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
    int maxDiff=Integer.MAX_VALUE;
    Integer prev=null;
    int i=0;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return maxDiff;
    }
    public void helper(TreeNode root) {
        if(root.left!=null){
            helper(root.left);
        }
        if(prev!=null){
            maxDiff=Math.min(maxDiff,Math.abs(root.val-prev));
        }
        prev=root.val;
        if(root.right!=null){
            helper(root.right);
        }
    }
}