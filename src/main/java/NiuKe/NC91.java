package NiuKe;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/31 19:45
 **/
public class NC91 {
    @Test
    public void test(){
        int[] array = new int[]{2,1,5,3,6,4,8,9,7};
        int[] array2 = LIS(array);
    }
    public int[] LIS (int[] arr) {
        int[] dp = new int[arr.length];
        int[] subset = new int[arr.length + 1];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (subset[len] < arr[i]) {
                len += 1;
                subset[len] = arr[i];
                dp[i] = len;
            } else {
                int idx = Arrays.binarySearch(subset, 0, len, arr[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                subset[idx] = arr[i];
                dp[i] = idx;
            }
        }
        int[] res = new int[len];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }
}
