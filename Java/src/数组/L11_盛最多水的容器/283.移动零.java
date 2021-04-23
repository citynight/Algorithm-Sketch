/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 记录不为0的位置
        int j = 0;

        for(int i=0;i<nums.length;i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                // 补0操作
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
// @lc code=end

