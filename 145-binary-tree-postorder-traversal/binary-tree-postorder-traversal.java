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
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(root==null){
            return arr;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode x=st.pop();
            if(x.left!=null){
                st.add(x.left);
            }
            if(x.right!=null){
                st.add(x.right);
            }
            arr.addFirst(x.val);
        }
        return arr;
    }
}