/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*HashMap<Node,Node> hm=new HashMap<Node,Node>();
        Node temp=head;
        while(temp!=null){
            Node newnode=new Node(temp.val);
            hm.put(temp,newnode);
            temp=temp.next;
        }
        Node t=head;
        while(t!=null){
            Node node=hm.get(t);
            node.next=t.next!=null?hm.get(t.next):null;
            node.random=t.random!=null?hm.get(t.random):null;
            t=t.next;
        }
        return hm.get(head);*/
        Node temp=head;
        while(temp!=null){
            Node newnode=new Node(temp.val);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=temp.next.next;
        }
        Node itr=head;
        while(itr!=null){
            if(itr.random!=null){
                itr.next.random=itr.random.next;
            }
            itr=itr.next.next;
        }
        itr=head;
        Node fast=null;
        Node dummy=new Node(0);
        temp=dummy;
        while(itr!=null){
            fast=itr.next.next;
            temp.next=itr.next;
            itr.next=fast;
            temp=temp.next;
            itr=fast;
        }
        return dummy.next;
    }
}