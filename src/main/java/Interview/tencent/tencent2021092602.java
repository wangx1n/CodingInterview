package Interview.tencent;

import java.util.Scanner;

public class tencent2021092602 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int T = sin.nextInt();
        while (T > 0) {
            int n = sin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sin.nextInt();
            }
            long res = Integer.MIN_VALUE;
            long[] temp = new long[n];
            for (int i = 0; i < n; i++) {
                res = Math.max(res, getSoc(temp, nums, i));
            }
            System.out.println(res);
            T--;
        }
    }

        public static long getSoc(long[] temp, int[] nums, int start) {
            long ans = 0, n = nums.length;
            if (start >= n) {
                return 0;
            }
            if (temp[start] != 0) {
                return  temp[start];
            }
            ans = nums[start] + getSoc(temp, nums, start + nums[start]);
            temp[start] = ans;
            return ans;
        }

}
