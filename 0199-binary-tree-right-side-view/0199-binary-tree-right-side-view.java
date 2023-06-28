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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        
        solve(root,res,0);
        return res;
    }
    void solve(TreeNode root,List<Integer> arr,int level){
        if(root==null){
            return;
        }
        if(level==arr.size()){
            arr.add(root.val);
        }
        solve(root.right,arr,level+1);
        solve(root.left,arr,level+1);
    }
}