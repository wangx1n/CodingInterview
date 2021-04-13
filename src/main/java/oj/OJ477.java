package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/23 21:54
 *
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class OJ477 {
    public int totalHammingDistance(int[] nums) {
        int[] result = new int[32];
        for(int num : nums){
            int i = 0;
            while(num > 0){
                result[i] += (num & 1);
                num >>>= 1;
                i++;
            }
        }

        int n = nums.length;
        int ans = 0;

        for(int sumi : result){
            ans += sumi * (n - sumi);
        }

//        for(int i = 0;i < nums.length;i++){
//            for(int j = i + 1;j<nums.length;j++){
//                result.add(getDifferent(nums[i] ^ nums[j]));
//            }
//        }
//        //Integer[] resultArray = result.toArray(new Integer[result.size()])
//        int sum = result.stream().reduce(Integer::sum).orElse(0);
        return ans;
    }

    int getDifferent(int n){
        int result = 0;
        while(n != 0){
            if((n & 1) == 1){
                result++;
            }
            n >>>= 1;
        }

        return result;
    }
}
