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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        while(n-->0){
            first=first.next;
        }
        ListNode second=head;
        if(first==null){
            return second.next;
        }
        while(first!=null && first.next!=null){
            first=first.next;
            second=second.next;
        }
        if(second.next!=null && second.next.next!=null){
            second.next=second.next.next;
        }
        else if(second.next!=null){
            second.next=null;
        }
        return head;
    }
}