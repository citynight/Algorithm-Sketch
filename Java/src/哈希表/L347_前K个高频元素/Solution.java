package 哈希表.L347_前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author logan
 * @date 2020/9/7 12:11 下午
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 记录每个数据出现的次数
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1);
        }

        // 数据按次数排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> Integer.compare(freq.get(o1),freq.get(o2))));
        for (Integer ele: freq.keySet()) {
            minHeap.add(ele);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        // 排序后的数据返回
        int res[] = new int[minHeap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.remove();
        }
        return res;
    }
}
