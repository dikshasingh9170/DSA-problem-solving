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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        while(!st.isEmpty() || root!=null){
            if(root!=null){
                st.add(root);
                arr.add(root.val);
                root=root.left;
            }
            else{
                TreeNode pop=st.pop();
                root=pop.right;
            }
        }
        return arr;
    }
}