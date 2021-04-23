/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length < 2) {return 0;}
        int begin = 0; int end = length - 1;
        int max = 0;
        while(begin < end) {
            int area = Math.min(height[begin],height[end]) * (end - begin);
            if (max < area) {
                max = area;
            }
            if (height[begin] < height[end]) {
                begin++;
            }else {
                end--;
            }
        }
        return max;
    }
}
// @lc code=end

