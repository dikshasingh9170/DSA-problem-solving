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
     public ArrayList<Integer> arr=new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        solve(root);
        return arr;
    }
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        solve(root.left);
        solve(root.right);
        arr.add(root.val);
    }
}