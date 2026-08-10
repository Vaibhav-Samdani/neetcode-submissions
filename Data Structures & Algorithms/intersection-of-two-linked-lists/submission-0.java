/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        int countA = 0;
        int countB = 0;

        while (t1 != null) {
            countA++;
            t1 = t1.next;
        }
        while (t2 != null) {
            countB++;
            t2 = t2.next;
        }

        int diff = Math.abs(countA - countB);

        if (countA >= countB) {
            t1 = headA;
            t2 = headB;
        } else {
            t1 = headB;
            t2 = headA;
        }

        for (int i = 0; i < diff; i++) {
            t1 = t1.next;
        }

        while (t1 != null && t2 != null) {
            if (t1 == t2) {
                return t1;
            } else {
                t1 = t1.next;
                t2 = t2.next;
            }
        }

        return null;

    }
}