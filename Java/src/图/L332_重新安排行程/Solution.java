package 图.L332_重新安排行程;

import java.util.*;

/**
 * @author logan
 * @date 2020/8/27 9:56 上午
 *
 *
 * 思路:
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * index   from             to
 *   0      MUC -----------> LHR    跳转到index:3
 *   1      JKF -----------> MUC    跳转到index:0
 *   2      SFO -----------> SJC    结束
 *   3      LHR -----------> SFO    跳转到index:2
 *
 *   1. 首先机票的初始出发点都是JFK(肯尼迪国际机场)出发,第1号机票符合要求,目的地MUC
 *   2. MUC为出发点的机票为第0号机票,目的地LHR,
 *   3. LHR为出发点的机票为第3号机票,目的地SFO,
 *   4. SFO为出发点的机票为第2号机票,目的地SJC,SJC没有出发的机票.结束
 *
 *   可以使用栈把最后的位置放入栈中/或者每次找到目的地都放在数组的第0个位置:["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 *
 *   地点通向有向的边 -> 图
 */
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();

        // 创建一个图
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        bulidGraph(tickets,g);

        dfs(g,res,"JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> g, LinkedList<String> res, String from) {
        PriorityQueue<String> arrivals = g.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            String to = arrivals.poll();
            dfs(g,res,to);
        }
        res.addFirst(from);
    }

    private void bulidGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> g) {
        for (List<String> travel: tickets) {
            String from = travel.get(0);
            String to = travel.get(1);
            if (!g.containsKey(from)) {
                g.put(from,new PriorityQueue<>());
            }
            g.get(from).offer(to);
        }
    }
}
