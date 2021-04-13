  package oj;

import java.util.Arrays;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/23 18:18
 **/
public class OJ34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int resultleft = gerResult(nums,target,true);
        int resultright = gerResult(nums,target,false) - 1;

        if(resultleft <= resultright && resultright < nums.length && nums[resultleft] == target && nums[resultright] == target){
            result[0] = resultleft;
            result[1] = resultright;
            return result;
        }
        return new int[]{-1,-1};

    }

    int gerResult(int[] nums,int target,boolean isLow){
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] > target || (isLow&&(nums[mid] >= target))){
                right = mid - 1;
                result = mid;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
}
