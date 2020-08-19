package 回文.L647_回文子串;
/**
 *
 * 思路： 使用中心扩展方法,每个字符都是一个中心，或者两个相邻一样的字符是一个中心，然后向左右分别递进判断能否形成回文
 * 举个🌰
 * 比如字符串是   a   b   a
 * 遍历字符串  <-⬆->              回文子串 a  左边没有数据所以只有这一个
 *               <-⬆->          回文子串 b  一个指针向左走一个指针向右走 判断是否还有对应的子串（aba）， 左边 a 右边 a 能形成字串，再走没有数据
 *                    <-⬆->     回文字串 a 右边没有数据所以结束
 * 根据上面的流程 最终的字串为  a，b, aba, a 共4个
 *
 * 当然还有两个字符一样的情况
 * 比如字符串是   a   b   b   a
 * 这样就需要      <-⬆  ⬆->      从中间两个向外判断是否能形成回文子串
 *
 */
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