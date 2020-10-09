package 树.L117_填充每个节点的下一个右侧节点指针_II;

import Common.Node;

import java.util.*;

/**
 * @author logan
 * @date 2020/9/28 10:03 上午
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}
