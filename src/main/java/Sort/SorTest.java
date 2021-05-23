package Sort;

import org.junit.Test;

import java.util.Arrays;

public class SorTest {

    @Test
    public void sortTest(){
        int[] a = new int[]{9,1,2,4,8,7,6,0,3,5};
        quickSort(a,0,9);
        System.out.println(Arrays.toString(a));

        int[] a2 = new int[]{9,1,2,4,8,7,6,0,3,5};
        heapSort(a2);
        System.out.println(Arrays.toString(a2));
    }

    public void heapSort(int[] a){

        for(int i = a.length / 2 - 1;i >= 0;i--){
            ajustHeap(a,i,a.length);
        }

        for(int i = a.length - 1;i > 0;i--){
            swap(a,0,i);
            ajustHeap(a,0,i);
        }
    }

    public void swap(int[] a,int i,int j){
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public void ajustHeap(int[] a,int begin,int end){
        int temp = a[begin];
        for(int i = 2*begin + 1;i < end;i = 2 * i + 1){

            if(i + 1 < end && a[i+1] > a[i]){
                i++;
            }

            if(a[i] > temp){
                a[begin] = a[i];
                begin = i;
            }else{
                break;
            }
        }
        a[begin] = temp;

    }

    public void quickSort(int[] a,int begin,int end){
        if(begin < end){

            int index = findIndex(a,begin,end);

            quickSort(a,begin,index - 1);
            quickSort(a,begin + 1,end);
        }
    }

    public int findIndex(int[] a,int begin,int end){
        int pivot = a[begin];

        while(begin < end){

            while(begin < end && a[end] >= pivot){

                end--;

            }

            a[begin] = a[end];

            while(begin < end && a[begin] <= pivot){

                begin++;

            }

            a[end] = a[begin];
        }

        a[begin] = pivot;

        return begin;
    }
}
