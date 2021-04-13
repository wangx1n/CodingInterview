package Sort;

import org.junit.Test;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/25 16:34
 **/
public class QuickSort {

    @Test
    public void test(){
        int[] arr = new int[]{0,9,1,7,2,3,5,4,6,8};
        QuickSort(arr,0,9);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void QuickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }
//    /**
//     * 快速排序方法
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    public static int[] QuickSort(int[] array, int start, int end) {
//        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
//        int smallIndex = partition(array, start, end);
//        if (smallIndex > start)
//            QuickSort(array, start, smallIndex - 1);
//        if (smallIndex < end)
//            QuickSort(array, smallIndex + 1, end);
//        return array;
//    }
//    /**
//     * 快速排序算法——partition
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    public static int partition(int[] array, int start, int end) {
//        //int pivot = (int) (start + Math.random() * (end - start + 1));
//        int pivot = start;
//        int smallIndex = start - 1;
//        swap(array, pivot, end);
//        for (int i = start; i <= end; i++)
//            if (array[i] <= array[end]) {
//                smallIndex++;
//                if (i > smallIndex)
//                    swap(array, i, smallIndex);
//            }
//        return smallIndex;
//    }
//
//    /**
//     * 交换数组内两个元素
//     * @param array
//     * @param i
//     * @param j
//     */
//    public static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
}
