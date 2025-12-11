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
        if(root==null){
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> st=new Stack<>();
        ArrayList<Integer> arr=new ArrayList<>();
        while(root!=null || !st.isEmpty()){
            if(root!=null){
                st.add(root);
                root=root.left;
            }
            else{
                root=st.pop();
                arr.add(root.val);
                root=root.right;
            }
        }
        return arr;
    }
}