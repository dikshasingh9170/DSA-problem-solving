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
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        HashMap<TreeNode,TreeNode> hm=new HashMap<TreeNode,TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode x=q.poll();
                if(x.left!=null){
                    q.offer(x.left);
                    hm.put(x.left,x);
                }
                if(x.right!=null){
                    q.offer(x.right);
                    hm.put(x.right,x);
                }
            }
        }
        q.offer(target);
        visited.add(target);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(count==k)break;
            count++;
            while(size-->0){
                TreeNode x=q.poll();
                if(hm.containsKey(x)){
                    if(!visited.contains(hm.get(x))){
                        q.offer(hm.get(x));
                        visited.add(hm.get(x));
                    }
                }
                if(x.left!=null){
                    if(!visited.contains(x.left)){
                        q.offer(x.left);
                        visited.add(x.left);
                    }
                }
                if(x.right!=null){
                    if(!visited.contains(x.right)){
                        q.offer(x.right);
                        visited.add(x.right);
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
