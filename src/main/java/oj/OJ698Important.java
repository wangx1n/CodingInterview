package oj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/23 20:48
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 通过次数19,885提交次数44,411
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class OJ698Important {

    @Test
    public void test(){
        //[10,10,10,7,7,7,7,7,7,6,6,6]
        //3
        int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
        int k = 3;
        canPartitionKSubsets(nums,k);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if(sum % k != 0){
            return false;
        }

        int groupMax = sum / k;

        Arrays.sort(nums);

        int row = nums.length - 1;

        if(nums[nums.length - 1] > groupMax){
            return false;
        }

        while(nums[row] == groupMax && row > 0){
            row--;
            k--;
        }

        return search(new int[k],nums,groupMax,row);
    }

    public boolean search(int[] group,int[] nums,int groupMax,int row){
        if(row < 0) return true;

        int currValue = nums[row--];

        for(int i = 0; i < group.length;i++){
            if(currValue + group[i] <= groupMax){
                group[i] += currValue;
                if(search(group,nums,groupMax,row)) {
                    return true;
                }
                group[i] -= currValue;
            }
            if (group[i] == 0) break;
        }
        return false;
    }


//    public boolean search(int[] groups, int row, int[] nums, int target) {
//        if (row < 0) return true;
//        int v = nums[row--];
//        for (int i = 0; i < groups.length; i++) {
//            if (groups[i] + v <= target) {
//                groups[i] += v;
//                if (search(groups, row, nums, target)) return true;
//                groups[i] -= v;
//            }
//            if (groups[i] == 0) break;
//        }
//        return false;
//    }
//
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = Arrays.stream(nums).sum();
//        if (sum % k > 0) return false;
//        int target = sum / k;
//
//        Arrays.sort(nums);
//        int row = nums.length - 1;
//        if (nums[row] > target) return false;
//        while (row >= 0 && nums[row] == target) {
//            row--;
//            k--;
//        }
//        return search(new int[k], row, nums, target);
//    }
}
