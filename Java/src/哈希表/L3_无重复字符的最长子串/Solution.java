package 哈希表.L3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // 暴力解法
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            set.clear();
            for (int j = i; j < len; j++) {
                if (set.contains(s.charAt(j))) {
                    int curr = j - i;
                    max = Math.max(max,curr);
                    break;
                }else {
                    set.add(s.charAt(j));
                }
            }
        }
        max = Math.max(max,set.size());
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 记录字符出现的位置
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            Character character = s.charAt(i);
            // 获取上次出现的位置
            int index = map.getOrDefault(character,-1);
            if (start <= index) {
                max = Math.max(max,i-start);
                start = index + 1;
            }
            map.put(character,i);
        }
        max = Math.max(max,len - start);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(len + "");
    }
}