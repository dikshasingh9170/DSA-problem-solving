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
        return solution(root);
    }
    public int solution(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=solution(root.left);
        int rh=solution(root.right);
        return 1+Math.max(lh,rh);
    }
}