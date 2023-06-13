/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0 ){
            return head;
        }
        ListNode fast=head;
        ListNode curr=head;
        int n=1;
        while(curr.next!=null){
            n++;
            curr=curr.next;
        }
        k=n-k%n-1;int i=0;
        while(i<k){
            fast=fast.next;
            i++;
        }
        curr.next=head;
        ListNode slow=fast.next;
        fast.next=null;
        head=slow;
        return head;
    }
}
