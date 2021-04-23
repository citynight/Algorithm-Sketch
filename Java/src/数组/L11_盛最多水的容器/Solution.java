package 数组.L11_盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0, j = height.length - 1; i < j ; ){
            int minHeight = height[i] < height[j] ? height[i ++] : height[j --];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}
