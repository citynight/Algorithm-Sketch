package 字符串.L557_反转字符串中的单词_III;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author logan
 * @date 2020/8/30 10:01 上午
 */
class Solution {
    public String reverseWords(String s) {
        ArrayList<String> res = new ArrayList<>();
        String[] split = s.split(" ");
        for (String str: split) {
            StringBuilder sb = new StringBuilder();
            String s1 = sb.append(str).reverse().toString();
            res.add(s1);
        }
        return join(res, " ");
    }
    private String join(ArrayList var0, String var1) {
        StringBuffer var2 = new StringBuffer();

        for(Iterator var3 = var0.iterator(); var3.hasNext(); var2.append((String)var3.next())) {
            if (var2.length() != 0) {
                var2.append(var1);
            }
        }
        return var2.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = solution.reverseWords("Let's take LeetCode contest");
        System.out.println(str);
    }
}
