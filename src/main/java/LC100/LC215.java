package LC100;

import java.util.Arrays;
import java.util.Random;

public class LC215 {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array = new int[]{9,2,7,4,3,5,8,1,0,11,23,-5,78,-20};
        findKthLargest(array, 14);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 13);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 12);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 11);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 10);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 9);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 8);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 7);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 6);
        System.out.println(Arrays.toString(array));

        findKthLargest(array, 5);
        System.out.println(Arrays.toString(array));
        //int[] array = new int[]{9,2,7,4,3,5,8,1,0};
        findKthLargest(array, 4);
        System.out.println(Arrays.toString(array));
        //int[] array = new int[]{9,2,7,4,3,5,8,1,0};
        findKthLargest(array, 3);
        System.out.println(Arrays.toString(array));
        //int[] array = new int[]{9,2,7,4,3,5,8,1,0};
        findKthLargest(array, 2);
        System.out.println(Arrays.toString(array));
        //int[] array = new int[]{9,2,7,4,3,5,8,1,0};
        findKthLargest(array, 1);
        System.out.println(Arrays.toString(array));


    }

    public static int findKthLargest(int[] nums, int k) {
        return fastSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int fastSort(int[] nums, int begin, int end, int target) {
        int p = fast(nums, begin, end);
        if (p == target) {
            return nums[p];
        }else {
            return p > target ? fastSort(nums, begin, p - 1, target) : fastSort(nums, p + 1, end, target);
        }
    }

    public static int fast(int[] nums, int begin, int end)  {
        findPivot(nums, begin, end);
        int x = nums[end];
        int i = begin - 1;
        for(int j = begin;j < end;j++) {
            if(nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    public static void findPivot(int[] nums, int begin, int end) {
        int x = random.nextInt(end - begin + 1) + begin;
        swap(nums, x, end);
    }

    public static void swap(int[] nums, int i, int j) {
        if(nums[i] == nums[j]) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
