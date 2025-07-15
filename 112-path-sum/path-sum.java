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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solution(root,targetSum,0);
    }
    public boolean solution(TreeNode root,int target,int ans){
        if(root==null){
            return false;
        }
        ans+=root.val;
        if(root.left==null && root.right==null && target==ans){
            return true;
        }
        return solution(root.left,target,ans) || solution(root.right,target,ans);
    }
}