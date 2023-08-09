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
        /*List<Integer> result = new ArrayList<>();   
        Stack<TreeNode> stack = new Stack<>();  
        TreeNode node=root;                 
        while(!stack.isEmpty() || node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                node=stack.pop();
                result.add(node.val);
                node=node.right;
            }
        }
        return result;*/
        List<Integer> arr=new ArrayList<Integer>();
        inorder(root,arr);
        return arr;
    }
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}