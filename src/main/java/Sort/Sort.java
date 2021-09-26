package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/26 11:26
 **/
public class Sort {

    public static void main(String[] args) {
        int []arr = {8,7,1,9,2,3,5,4,6,0};
        System.out.println("堆排序前："+ Arrays.toString(arr));
        HeapSort(arr);
        System.out.println("堆排序后："+Arrays.toString(arr));

        int []arr2 = {8,7,1,9,2,3,5,4,6,0};

        System.out.println("快速排序前："+ Arrays.toString(arr2));
        QuickSort(arr2,0,arr2.length - 1);
        System.out.println("快速排序后："+Arrays.toString(arr2));

        int []arr3 = {8,7,1,9,2,3,5,4,6,0};
        System.out.println("归并排序前："+ Arrays.toString(arr3));
        int[] result  = Merge(arr3);
        System.out.println("归并排序后："+Arrays.toString(result));

        int []arr4 = {8,7,1,9,2,3,5,4,6,0};
        System.out.println("希尔排序前："+ Arrays.toString(arr4));
        ShellSort(arr4);
        System.out.println("希尔排序后："+Arrays.toString(arr4));
    }

    @Test
    public void test(){
         int[] A = new int[2];
         A[0] = 2;
         int[] B = {1};
         merge(A,1,B,1);
    }

    public void merge(int A[], int m, int B[], int n) {
        for(int i = m;i<m+n;i++){
            A[m] = B[i-m];
        }
        int[] result = merge2(A);
    }

    public int[] merge2(int A[]){
        if(A.length < 2) return A;

        int mid = A.length/2;
        int[] left = Arrays.copyOfRange(A,0,mid);
        int[] right = Arrays.copyOfRange(A,mid,A.length);
        return mergeSort(merge2(left),merge2(right));

    }

    public int[] mergeSort(int[] left,int[] right){
        //if(arr.length < 2) return arr;
        int[] result = new int[left.length+right.length];

        for(int i = 0,j = 0,index = 0;index < result.length;index++){
            if(i >= left.length){
                result[index] = right[j++];
            }else if(j >= right.length){
                result[index] = left[i++];
            }else if(left[i] < right[j]){
                result[index] = left[i++];
            }else{
                result[index] = right[j++];
            }
        }
        return result;
    }

    // Merge 归并排序
    public static int[] Merge(int a[]){
        if(a.length < 2){
            return a;
        }

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a,0,mid);
        int[] right = Arrays.copyOfRange(a,mid,a.length);
        return MergeSort(Merge(left),Merge(right));
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void ShellSort(int[] arr){
        int gap = arr.length / 2;

        while(gap > 0){
            for(int i = gap;i<arr.length;i++){
                int temp = arr[i];
                int pre = i - gap;
                // 第一轮过后pre不止有一个
                // 目的就是找到temp应该在的位置
                while(pre >=0 && arr[pre] > temp){
                    arr[pre+gap] = arr[pre]; // 把较大的数换到后面去
                    pre -= gap; // 继续往前找， 找到第一个不比arr[pre + gap]的数，停止
                }
                arr[pre + gap] = temp; // 找到第一个不比arr[pre + gap]的数了，将原本的值赋值给这个位置
            }
            // 每隔一个交换一次，就是最后一次交换
            gap /= 2;
        }
    }

    /**
     * 归并排序
     * @param left
     * @param right
     * @return
     */
    public static int[] MergeSort(int[] left,int[] right){
        int[] result = new int[left.length+ right.length];

        for(int i=0,j=0,index=0;index<result.length;index++){
            if(i >= left.length){
                result[index] = right[j++];
            }
            else if(j >= right.length){
                result[index] = left[i++];
            }
            else if(left[i] < right[j]){
                result[index] = left[i++];
            }
            else{
                result[index] = right[j++];
            }
        }
        return result;
    }



    /**
     * 快速排序
     * @param arr
     * @param begin
     * @param end
     */
    // QuickSort
    public static void QuickSort(int[] arr,int begin,int end){

        if(begin < end){
            // 找到pivot的位置
            int index = findIndex(arr,begin,end);
            // 递归左右子数组，直到begin = end, 即只有一个元素
            QuickSort(arr,begin,index - 1);
            QuickSort(arr,index + 1,end);
        }
    }

    /**
     * 找到pivot的位置
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int findIndex(int[] arr,int begin,int end){
        int pivot = arr[begin];

        while(begin < end){
            // 找到第一个比pivot小的，和pivot交换位置
            while(begin < end && arr[end] >= pivot){
                end--;
            }
            arr[begin] = arr[end];
            // 找到第一个比pivot大的，和pivot交换位置
            while(begin < end && arr[begin] <= pivot){
                begin++;
            }
            arr[end] = arr[begin];
        }
        // 赋值pivot
        arr[begin] = pivot;

        return begin;
    }


    /**
     * 堆排序
     * @param arr
     */
    public static void HeapSort(int[] arr){
        // 建堆
        for(int i = arr.length /2 - 1;i >= 0;i--){
            ajustHeap(arr,i,arr.length);
        }
        // 调整
        for(int i = arr.length - 1;i>=0;i--){
            swap(arr,0,i);
            ajustHeap(arr,0,i);
        }
    }

    /**
     * 调整
     * @param a
     * @param begin
     * @param length
     */
    public static void ajustHeap(int[] a,int begin,int length){
        // temp 第一个非叶子节点的值
        int temp = a[begin];
        // i = 2 * begin + 1, 刚好找到当前节点的左节点
        for(int i = 2*begin+1;i < length;i = 2*i+1){
            // i + 1 < begin : 如果有右子树，那么右子树要小于左子树的值
            if(i + 1 < length && a[i] < a[i+1]){
                i++;
            }
            // temp小于a[i], 那么把两个孩子中的最大值换上当顶点
            if(temp < a[i]){
                a[begin] = a[i];
                // begin = i, 继续向下调整
                begin = i;
            }else{
                break;
            }
        }
        // 找到合适位置的值
        a[begin] = temp;
    }

    public static void swap(int[] a,int i,int j){
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
