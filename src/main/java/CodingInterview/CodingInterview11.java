package CodingInterview;

import org.junit.Test;

/**
 * @program: CodingInterview.CodingInterview
 * @description: 数组旋转
 * @author: wang xin
 * @create: 2021-02-14 15:39
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview11 {

    //1.遍历
//    public int minArray(int[] numbers) {
//        if(numbers.length <= 0) return -1;
//        for(int i = 1;i < numbers.length;i++)
//        {
//            if(numbers[i] >= numbers[i-1]) continue;
//            else{
//                return numbers[i];
//            }
//        }
//        return numbers[0];
//    }
    //2.二分法
    public int minArray(int[] numbers) {
        if(numbers.length <= 0) return -1;
        int head = 0;
        int rear = numbers.length-1;
        while(head<rear){
            int mid = head +(rear - head) / 2;//用这种方法防止溢出
            if(numbers[rear] > numbers[mid]) rear = mid;//当前mid为右侧最小，用此mid做新尾
            else if(numbers[rear] < numbers[mid]) head = mid + 1;//当前mid为左侧最大。不需要考虑mid，因为这个mid必然要大于右侧所有数
            else rear -= 1;//遇到相同数字，尾巴减少。
        }
        return numbers[head];
    }

    @Test
    public void test1()
    {
        System.out.println(minArray(new int[]{2, 1, 2, 2, 2, 2, 2}));
    }
}
