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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode list : lists){
            if(list != null) pq.offer(list);
        }

        ListNode ans = new ListNode(-1);

        ListNode tail = ans;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();

            tail.next = curr;
            tail = tail.next;

            if(curr.next != null) pq.offer(curr.next);
        }

        return ans.next;
    }
}
