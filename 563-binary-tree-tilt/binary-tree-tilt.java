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
    int ans = 0;
    int get(TreeNode root){
        if(root==null){return 0; }        
        int l= get(root.left) ;
        int r= get(root.right) ;
        ans+=Math.abs(l-r);        
        return l+r+root.val; 
    }
    public int findTilt(TreeNode root) {        
        get(root);
        return ans;
    }
}