/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<Integer>();
        HashMap<TreeNode,TreeNode> parent=new HashMap<TreeNode,TreeNode>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                st.push(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                st.push(curr.right);
            }
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(target);
        st.push(target);
        int dist=0;
        while(!q.isEmpty()){
            if(dist==k)break;
            dist++;
            int size=q.size();
            while(size-->0){
                TreeNode x=q.poll();
                if(parent.containsKey(x)){
                    if(!st.contains(parent.get(x))){
                        q.offer(parent.get(x));
                        st.push(parent.get(x));
                    }
                }
                if(x.left!=null){
                    if(!st.contains(x.left)){
                        q.offer(x.left);
                        st.push(x.left);
                    }
                }
                if(x.right!=null){
                    if(!st.contains(x.right)){
                        q.offer(x.right);
                        st.push(x.right);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}