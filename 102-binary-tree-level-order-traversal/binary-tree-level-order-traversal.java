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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> arr=new ArrayList();
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> arr1=new ArrayList<Integer>();
            while(size-->0){
                TreeNode x=q.peek();
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
                q.poll();
                arr1.add(x.val);
            }
            arr.add(arr1);
        }
        return arr;
    }
}