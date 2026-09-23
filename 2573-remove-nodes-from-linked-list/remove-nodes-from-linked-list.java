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
    public ListNode removeNodes(ListNode head) {
        ListNode[] stack = new ListNode[100001];
        int top = -1;

        ListNode current = head;

        while (current != null) {
            while (top >= 0 && stack[top].val < current.val) {
                top--;
            }

            stack[++top] = current;
            current = current.next;
        }

        for (int i = 0; i < top; i++) {
            stack[i].next = stack[i + 1];
        }

        stack[top].next = null;

        return stack[0];
    }
}