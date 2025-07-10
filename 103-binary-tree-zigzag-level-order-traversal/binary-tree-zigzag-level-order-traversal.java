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
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int flag=0;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> arr=new ArrayList<Integer>();
            while(size-->0){
                TreeNode x=q.poll();
                arr.add(x.val);
                if(x.left!=null){
                    q.offer(x.left);
                }
                if(x.right!=null){
                    q.offer(x.right);
                }
            }
            if(flag!=0){
                Collections.reverse(arr);
                flag=0;
            }else{
                flag=1;
            }
            res.add(arr);
        }
        return res;
    }
}