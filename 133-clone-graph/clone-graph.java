/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        HashMap<Node ,Node> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while(!q.isEmpty()){
            Node x=q.poll();
            for(Node n:x.neighbors){
                if(!visited.containsKey(n)){
                    visited.put(n,new Node(n.val,new ArrayList<>()));
                    q.add(n);
                }
                visited.get(x).neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);
    }
}