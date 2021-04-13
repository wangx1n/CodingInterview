package oj;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/23 15:31
 **/
public class OJ1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;

        //和相等，返回
        if (sum1 == sum2) {
            return 0;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        //每一位相加，如果最大值小于最小值，那么永远不可能相等
        if (len1 * 6 < len2 * 1) {
            return -1;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int res = 0;

        int i = 0, j = len2 - 1;
        while (i < len1 || j >= 0) {
            if ((6 - nums1[i]) >= (nums2[j] - 1)) {
                nums1[i] = 6 - nums1[i];
                res++;
                if ((diff -= (nums1[i])) <= 0) {
                    return res;
                }
                if (i + 1 < len1) {
                    i++;
                }
            } else {
                nums2[j] = nums2[j] - 1;
                res++;
                if ((diff -= (nums2[j])) <= 0) {
                    return res;
                }
                if (j - 1 >= 0) {
                    j--;
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5,6};
        int[] b = {1,1,2,2,2,2};
        minOperations(a,b);
    }
}