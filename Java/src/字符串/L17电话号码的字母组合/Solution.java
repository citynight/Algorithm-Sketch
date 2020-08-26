package 字符串.L17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logan
 * @date 2020/8/26 9:39 上午
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(phoneMap,res,digits,0,new StringBuffer());
        return res;
    }
    private void dfs(Map<Character, String> phoneMap,List<String> res,String digits,int index, StringBuffer combination) {
        if (index == digits.length()) {
            res.add(combination.toString());
        }else {
            Character digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                dfs(phoneMap,res,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
