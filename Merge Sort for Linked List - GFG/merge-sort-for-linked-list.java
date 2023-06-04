//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        
        Node mid=findMid(head);
        
        Node left=head;
        Node right=mid.next;
        mid.next=null;
        
        left=mergeSort(left);
        right=mergeSort(right);
        
        Node res=merge(left,right);
        
        return res;
    }
    static Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        Node ans=new Node(-1);
        Node temp=ans;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                temp=temp.next;
                left=left.next;
            }
            else{
                temp.next=right;
                temp=temp.next;
                right=right.next;
            }
        }
        if(left!=null){
            temp.next=left;
        }
        if(right!=null){
            temp.next=right;
        }
        return ans.next;
    }
}


