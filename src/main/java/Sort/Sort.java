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


    public static int[] Merge(int a[]){
        if(a.length < 2){
            return a;
        }

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a,0,mid);
        int[] right = Arrays.copyOfRange(a,mid,a.length);
        return MergeSort(Merge(left),Merge(right));
    }

    public static void ShellSort(int[] arr){
        int gap = arr.length / 2;

        while(gap > 0){
            for(int i = gap;i<arr.length;i++){
                int temp = arr[i];

                int pre = i - gap;
                while(pre >=0 && arr[pre] > temp){

                    arr[pre+gap] = arr[pre];
                    pre -= gap;
                }
                arr[pre + gap] = temp;
            }
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
    public static void QuickSort(int[] arr,int begin,int end){

        if(begin < end){
            int index = findIndex(arr,begin,end);

            QuickSort(arr,begin,index - 1);
            QuickSort(arr,index + 1,end);
        }
    }

    public static int findIndex(int[] arr,int begin,int end){
        int pivot = arr[begin];

        while(begin < end){

            while(begin < end && arr[end] >= pivot){
                end--;
            }
            arr[begin] = arr[end];

            while(begin < end && arr[begin] <= pivot){
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = pivot;

        return begin;
    }


    /**
     * 堆排序
     * @param arr
     */
    public static void HeapSort(int[] arr){

        for(int i = arr.length >> 2 - 1;i >= 0;i--){
            ajustHeap(arr,i,arr.length);
        }

        for(int i = arr.length - 1;i>=0;i--){
            swap(arr,0,i);
            ajustHeap(arr,0,i);
        }
    }

    public static void ajustHeap(int[] a,int begin,int length){
        int temp = a[begin];

        for(int i = 2*begin+1;i < length;i = 2*i+1){
            if(i + 1 < length && a[i] < a[i+1]){
                i++;
            }

            if(temp < a[i]){
                a[begin] = a[i];
                begin = i;
            }else{
                break;
            }
        }
        a[begin] = temp;
    }

    public static void swap(int[] a,int i,int j){
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
