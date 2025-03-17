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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        count++;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode x=q.poll();
                if(x.left!=null){
                    q.offer(x.left);
                    count++;
                }
                if(x.right!=null){
                    q.offer(x.right);
                    count++;
                }
            }
        }
        return count;
    }
}