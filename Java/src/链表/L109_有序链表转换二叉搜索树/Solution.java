package 链表.L109_有序链表转换二叉搜索树;

import Common.ListNode;
import Common.TreeNode;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head,null);
    }

    private TreeNode helper(ListNode start,ListNode end) {
        if(start == end) {
            return null;
        }

        // 快慢指针找中点，慢指针走一步，快指针走两步。当快指针走万的时候慢指针走一半（也就是中点）
        ListNode slow = start;
        ListNode fast = start;

        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 中点就是root
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start,slow);
        root.right = helper(slow.next,end);
        return root;
    }
}