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

        return mergeSort(lists,0,lists.length-1);
    }

    ListNode mergeSort(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }

        int mid = i + (j - i) / 2;

        ListNode left = mergeSort(lists, i, mid);
        ListNode right = mergeSort(lists, mid + 1, j);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        ListNode ans = new ListNode(-1);
        ListNode tail = ans;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if(left != null){
            tail.next = left;
        }
        if(right != null){
            tail.next = right;
        }

        return ans.next;
    }
}
