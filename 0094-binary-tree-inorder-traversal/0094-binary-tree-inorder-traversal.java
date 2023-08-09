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
/*class Solution {
    public ArrayList<Integer> arr=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return arr;
    }
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        solve(root.left);
        arr.add(root.val);
        solve(root.right);
    }
}*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> arr=new ArrayList<Integer>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode node=root;
        while(!st.isEmpty() || node!=null){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                node=st.pop();
                arr.add(node.val);
                node=node.right;
            }
        }
        return arr;
    }
}