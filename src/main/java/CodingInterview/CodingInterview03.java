package CodingInterview;

/**
 * @program: CodingInterview.CodingInterview
 * @description: 剑指offer03
 * @author: wang xin
 * @create: 2021-01-28 17:34
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview03 {

    //方法一：TimeOut
//    public int findRepeatNumber(int[] nums) {
//
//        int findInt = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1;j < nums.length;j++){
//                if(nums[i] > nums[j])
//                {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//
//                if(nums[i] == nums[j])
//                {
//                    findInt = nums[i];
//                }
//            }
//        }
//        return findInt;
//        }
//通过
    //错误的地方在于，不是在i后面找，而是找不到就一直找，直到这一个位置的数字被找到
    //跳出的条件为：某一个数字想要找到他的家，但是发现他的家已经被占了，那么这个数字就是重复数字
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        CodingInterview03 codingInterview03 = new CodingInterview03();
        System.out.println(codingInterview03.findRepeatNumber(new int[]{3,1,2,3}));
    }
}
