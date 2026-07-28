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

    public ListNode removeNthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }

        if( n == k ){
            return head.next;
        }

        temp = head;

        for(int i = 0; i<n-k-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;

        
    }
}
