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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm=new TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(0,0,root));
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode x=q.peek().root;
                int col=q.peek().col;
                int row=q.peek().row;
                q.poll();
                if(!tm.containsKey(col)){
                    tm.put(col,new TreeMap<>());
                }
                if(!tm.get(col).containsKey(row)){
                    tm.get(col).put(row,new PriorityQueue<>());
                }
                tm.get(col).get(row).offer(x.val);
                if(x.left!=null){
                    q.offer(new Tuple(col-1,row+1,x.left));
                }
                if(x.right!=null){
                    q.offer(new Tuple(col+1,row+1,x.right));
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:tm.values()){
            ArrayList<Integer> arr=new ArrayList<Integer>();
            for(PriorityQueue<Integer> pq:ys.values()){
                while(!pq.isEmpty()){
                    arr.add(pq.poll());
                }
            }
            res.add(arr);
        }
        return res;
    }
}
class Tuple{
    TreeNode root;
    int col;
    int row;
    public Tuple(int col,int row,TreeNode root){
        this.col=col;
        this.row=row;
        this.root=root;
    }
}
