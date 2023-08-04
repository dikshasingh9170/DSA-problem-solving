//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node addTwoLists(Node first, Node second){
        if(first==null && second==null){
            return first;
        }
        if(first==null){
            return second;
        }
        if(second==null){
            return first;
        }
        Node rev1=reverse(first);
        Node rev2=reverse(second);int carry=0;
        Node curr=new Node(0);
        Node temp=curr;
        while(rev1!=null || rev2!=null || carry!=0){
            int sum=0;
            if(rev1!=null){
                sum+=rev1.data;
                rev1=rev1.next;
            }
            if(rev2!=null){
                sum+=rev2.data;
                rev2=rev2.next;
            }
            sum+=carry;
            carry=sum/10;
            Node nnode=new Node(sum%10);
            temp.next=nnode;
            temp=temp.next;
        }
        Node rev=reverse(curr.next);
        return rev;
    }
    static Node reverse(Node node){
        Node prev=null;
        while(node!=null){
            Node temp=node.next;
            node.next=prev;
            prev=node;
            node=temp;
        }
        return prev;
    }
}