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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        solution(root,res,"");
        return res;
    }
    public void solution(TreeNode root,List<String> res,String s){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            res.add(s+root.val);
            return;
        }
        solution(root.left,res,s+root.val+"->");
        solution(root.right,res,s+root.val+"->");
    }
}