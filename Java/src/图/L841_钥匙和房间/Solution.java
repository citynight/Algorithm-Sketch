package 图.L841_钥匙和房间;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author logan
 * @date 2020/8/31 10:32 下午
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int room = queue.remove();
            if (visited.contains(room)) {
                continue;
            }
            visited.add(room);
            for (Integer k : rooms.get(room)) {
                queue.add(k);
            }
        }
        return rooms.size() == visited.size();
    }
}
