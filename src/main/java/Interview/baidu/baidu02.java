package InterviewTest.Meituan.meituan2021.baidu;

import java.util.Scanner;

public class baidu02 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        char[] str = s.toCharArray();
        int n = str.length;
        int[] nums = new int[n];
        for (int i = 0;i < n;i++) {
            nums[i] = str[i] - '0';
        }
        int len = n - 1, sum1 = 0, sum2 = 0;
        int s1 = 0, s2 = 1;
        for (int i = s1;i < s1 + len; i++) {
            sum1 += nums[i];
        }
        sum2 = sum1 - nums[0] + nums[n - 1];
        while(len > 0) {
            for (int i = s1; i + len < n; ++i) {
                int t1 = i + len;
                for (int j = s2;j + len < n;++j) {
                    int t2 = j + len;
                    if (sum(str, i, j, t1, t2)) {
                        ++i;
                        ++j;
                        ++t1;
                        ++t2;
                        System.out.println(i + " " +t1 + " " +j + " " + t2 + " ");
                        return;
                    }
                    sum2 = sum2 - nums[j] + nums[t2];
                }
                sum1 = sum1 - nums[i] + nums[t1];
            }
            --len;
        }
    }

    private static boolean sum(char[] c, int s1, int s2, int t1, int t2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = s1; i < t1; i++) {
            sum1 += c[i] - '0';
        }
        for (int i = s2; i < t2; i++) {
            sum2 += c[i] - '0';
        }
        if (sum1 != sum2) {
            return false;
        }
        return true;
    }
}
