package 字符串.L459_重复的子字符串;

/**
 * @author logan
 * @date 2020/8/24 10:11 上午
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int count = s.length();
        Character endChar = s.charAt(count - 1);
        for (int i = 0; i < count; i++) {
            // 判断子串是否能重复的构成原字符串
            if (s.charAt(i) == endChar && i+1 != count && count % (i+1) == 0) {
                // 判断是否是字串
                String substring = s.substring(0, i + 1);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count / (i + 1); j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("aba"));
    }
}
