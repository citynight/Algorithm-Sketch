package 数组.L60_第k个排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/5 10:35 上午
 */
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        // 所有的阶乘值
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i-1] * i;
        }

        k--;
        StringBuffer sb = new StringBuffer();
        // i 表示剩余的数字个数，初始化为 n - 1
        for (int i = n-1; i >= 0; i--) {
            int num = nums.remove(k/fact[i]);
            sb.append(num);
            k %= fact[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.getPermutation(3, 3);
        System.out.println(s);
    }
}
