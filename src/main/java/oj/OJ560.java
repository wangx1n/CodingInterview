package oj;

import org.junit.Test;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/22 18:27
 **/
public class OJ560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i<nums.length ;i++){
            int tempk = 0;
            int j = i;
            while(j < nums.length){

                tempk += nums[j];

                if(tempk == k) {
                    result+=1;
                }

                j++;
            }
        }

        return result;
    }

    @Test
    public void test(){
        int[] a = {-1,-1,1};
        int k = 0;
        subarraySum(a,k);
    }
}
