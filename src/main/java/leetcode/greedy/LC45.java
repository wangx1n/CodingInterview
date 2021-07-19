package leetcode.greedy;

public class LC45 {
    public int jump(int[] nums) {
        int step = 0;
        int start = 0;
        int end = 1;

        while(end < nums.length) {
            int max = 0;

            for (int i = start; i < end;i++) {
                if (nums[i] + i > max) max = nums[i] + i;
            }
            start = end;
            end = max;
            step++;
        }
        return step;
    }
}
