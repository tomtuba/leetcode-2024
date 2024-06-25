/**
 * 143. Reorder List
 */
package solutions;

import java.util.ArrayDeque;

import solutions.common.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> queue = new ArrayDeque<>();

        ListNode last = head;
        ListNode next = null;

        while (head != null) {
            queue.add(head);
            head = head.next;
        }

        boolean start = false;

        while (queue.size() > 0) {
            if (start) {
                next = queue.pollLast();
            } else {
                next = queue.pollFirst();
            }
            last.next = next;
            last = next;
            start = !start;
        }
        if (next != null) {
            next.next = null;
        }
    }
}
