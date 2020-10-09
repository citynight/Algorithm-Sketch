package 链表.L141_环形链表;

import Common.ListNode;

/**
 * @author logan
 * @date 2020/10/9 9:44 上午
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;

        while (slow != null && fast != null) {
            if (slow.val == fast.val) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
