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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);boolean ltor=true;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> ans=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                ans.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(!ltor){
                Collections.reverse(ans);
            }
            res.add(ans);
            ltor=!ltor;
        }
        return res;
    }
}