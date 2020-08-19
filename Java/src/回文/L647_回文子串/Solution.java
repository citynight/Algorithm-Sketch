package 回文.L647_回文子串;

class Solution {
    // 回文字串数量
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // aba -> i 为 b位置
            helper(s,i,i);
            // abba -> i 为第一个b位置
            helper(s,i,i+1);
        }
        return count;
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}