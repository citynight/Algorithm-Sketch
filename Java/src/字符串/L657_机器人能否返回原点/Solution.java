package 字符串.L657_机器人能否返回原点;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author logan
 * @date 2020/8/28 12:09 上午
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        ArrayList<Integer> location = new ArrayList<>();
        location.add(0);
        location.add(0);
        char[] chars = moves.toCharArray();
        for (char move:  chars) {
            if (move == 'L') {//左
                int val = location.get(1);
                location.set(1,val-1);
            }else if (move == 'R'){
                int val = location.get(1);
                location.set(1,val+1);
            }else if (move == 'U'){
                int val = location.get(0);
                location.set(0,val+1);
            }else if (move == 'D'){
                int val = location.get(0);
                location.set(0,val-1);
            }
        }
        return location.get(0) == 0 && location.get(1) == 0;
    }
}
