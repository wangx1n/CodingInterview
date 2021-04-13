package Sort;

import org.junit.Test;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/25 15:26
 **/
public class ShellSort {

    @Test
    public void test(){
        int[] a = ShellSort(new int[]{8,9,1,7,2,3,5,4,6,0});
        for(int i : a){
            System.out.print(i + ",");
        }
    }

    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
