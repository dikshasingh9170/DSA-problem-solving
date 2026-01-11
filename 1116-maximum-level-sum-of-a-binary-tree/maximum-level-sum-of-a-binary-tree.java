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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Pair x=new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            while(size-->0){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            level++;
            if(x.sum<sum){
                x.sum=sum;
                x.level=level;
            }
        }
        return x.level;
    }
}
class Pair{
    int sum;
    int level;
    public Pair(int sum,int level){
        this.sum=sum;
        this.level=level;
    }
}