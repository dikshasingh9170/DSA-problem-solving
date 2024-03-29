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
    public List<Integer> preorderTraversal(TreeNode root) {
        solve(root);
        return arr;
    }
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        arr.add(root.val);
        solve(root.left);
        solve(root.right);
    }
}*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();   
        /*Stack<TreeNode> stack = new Stack<>();  
        TreeNode node=root;                 
        while(!stack.isEmpty() || node!=null){
            if(node!=null){
                stack.push(node);
                result.add(node.val);
                node=node.left;
            }
            else{
                node=stack.pop();
                node=node.right;
            }
        }
        return result;*/
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                result.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    result.add(curr.val);
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return result;
    }
}
