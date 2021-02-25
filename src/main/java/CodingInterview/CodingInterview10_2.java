package CodingInterview;

/**
 * @program: CodingInterview.CodingInterview
 * @description: 青蛙跳台阶
 * @author: wang xin
 * @create: 2021-02-14 15:29
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview10_2 {

    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum = 0;

        if(n == 0 || n == 1) return 1;

        for(int i = 0;i < n;i++)
        {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
