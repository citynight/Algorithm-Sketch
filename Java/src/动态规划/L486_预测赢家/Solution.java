package 动态规划.L486_预测赢家;

/**
 * @author logan
 * @date 2020/9/1 10:54 下午
 */
public class Solution {
    public boolean PredictTheWinner1(int[] nums) {
        return helper(nums,0,nums.length - 1) >= 0;
    }

    private int helper(int[] nums,int start,int end) {
        if (start == end) {
            return nums[start];
        }
        // 当前选择的分数，减去，往后对手赢过自己的分数（剩余数组的递归结果）。因为选择有两种，所以在两个差值中取较大的。
        int left = nums[start] - helper(nums,start + 1,end);
        int right = nums[end] - helper(nums,start,end - 1);
        return Math.max(left,right);
    }


    // 使用动态规划
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = nums[i] - dp[i+1][j];
                int right = nums[j] - dp[i][j-1];
                dp[i][j] = Math.max(left,right);
            }
        }
        return dp[0][len-1] >= 0;
    }
}
