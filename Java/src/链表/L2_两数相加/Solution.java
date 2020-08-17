package 链表.L2_两数相加;

import Common.ListNode;

/**
 * @author : logan
 * create at:  2020-08-17  13:22
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头结点，省去判断头为空的情况
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        // 进位
        int carry = 0;
        while (p != null || q != null) {
             int x = (p != null) ? p.val : 0;
             int y = (q != null) ? q.val : 0;
             int sum = x + y + carry;
             carry = sum / 10;
             curr.next = new ListNode(sum % 10);
             curr = curr.next;
             if ( p != null ) { p = p.next; }
             if ( q != null ) { q = q.next; }
        }
        // 如果两个数最高位之和还有进位需要，还需要追加进位节点
        if ( carry > 0 ) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}