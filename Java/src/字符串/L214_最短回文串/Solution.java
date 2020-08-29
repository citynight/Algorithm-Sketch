package 字符串.L214_最短回文串;

/**
 * @author logan
 * @date 2020/8/29 10:26 上午
 */
public class Solution {
    // 暴力解法.超时
    public String shortestPalindrome1(String s) {
        int i = 0, end = s.length() - 1, j = end;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                i = 0;
                end--;
                j=end;
            }
        }
        return new StringBuffer(s.substring(end+1)).reverse().toString() + s;
    }

    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        // 使用特殊字符避免重复 比如 baaa
        String l = s + "#" + rev_s;

        int[] p = new int[l.length()];

        // build KMP table
        //i -> suffix boundary
        //j -> prefix boundary
        for (int i = 1; i < l.length(); i++) {
            // update prefix boundary
            int j = p[i-1];

            // move to the last prefix boundary match
            while (j>0 && l.charAt(i) != l.charAt(j)) {
                j = p[j-1];
            }

            // if prefix boundary matches suffix boundary, increase prefix length
            if (l.charAt(i) == l.charAt(j)) {
                p[i] = j+1;
            }
        }
        return rev_s.substring(0,s.length() - p[l.length()-1]) + s;
    }
}
