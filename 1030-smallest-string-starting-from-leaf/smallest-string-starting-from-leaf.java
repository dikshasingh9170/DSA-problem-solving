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
    String max=null;
    public String smallestFromLeaf(TreeNode root) {
        solution(root,"");
        return max;
    }
    public void solution(TreeNode root,String s){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            s=(char) ('a' + root.val)+s;
            if(max==null || (s).compareTo(max)<0){
                max=s;
            }
            return;
        }
        solution(root.left,(char) ('a' + root.val)+s);
        solution(root.right,(char) ('a' + root.val)+s);
    }
}