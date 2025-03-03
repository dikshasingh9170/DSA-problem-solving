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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        TreeNode x=root.left;
        while(!st.isEmpty() || x!=null){
            if(x!=null){
                st.push(x);
                x=x.left;
            }
            else{
                x=st.pop();
                res.add(x.val);
                x=x.right;
            }
        }
        return res;
    }
}