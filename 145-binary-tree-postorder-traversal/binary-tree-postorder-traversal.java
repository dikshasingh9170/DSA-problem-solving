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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        Stack<TreeNode> st1=new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode x=st.pop();
            if(x.left!=null){
                st.push(x.left);
            }
            if(x.right!=null){
                st.push(x.right);
            }
            st1.push(x);
        }
        while(!st1.isEmpty()){
            res.add(st1.pop().val);
        }
        return res;
    }
}