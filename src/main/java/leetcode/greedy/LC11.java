package leetcode.greedy;

public class LC11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int size = Math.min(height[i], height[j]) * (j - i);
            if (size > max) max = size;
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
