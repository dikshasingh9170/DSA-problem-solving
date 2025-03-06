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
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> st=new LinkedList<TreeNode>();
        st.offer(root);
        int reverse=1;
        while(!st.isEmpty()){
            int size=st.size();
            List<Integer> ans=new ArrayList<Integer>();
            while(size-->0){
                TreeNode x=st.poll();
                ans.add(x.val);
                if(x.right!=null){
                    st.offer(x.right);
                }
                if(x.left!=null){
                    st.offer(x.left);
                }
            }
            if(reverse==0){
                res.add(ans);
                reverse++;
            }
            else{
                Collections.reverse(ans);
                res.add(ans);
                reverse--;
            }
        }
        return res;
    }
}