package InterviewTest.Meituan.meituan2021.wangyihuyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class wangyihuyu02 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int M = cin.nextInt() - 1; // 小E位置
            int[] size = new int[N];
            if (N <= 2) {
                System.out.println(0);
                continue;
            }
            for(int j = 0; j < N;j++) {
                size[j] = cin.nextInt();
            }
            ArrayList<Integer> range = ERange(size, M);
            Collections.sort(range);
            int begin = range.get(0), end = range.get(range.size() - 1);
            boolean upper = false;
            int result = 0;
            for (int z = 0; z < size.length; z ++) {
                if (z >= begin && z <= end) {
                    continue;
                }else {
                    if (z + 1 == begin || z - 1 == end){
                        continue;
                    }else {
                        upper = z - 1 >= 0 && size[z] >= size[z-1];
                        break;
                    }
                }
            }

            for (int j = 1; j < size.length; j++) {
                if (j >= begin && j <= end) {
                    continue;
                }
                if (upper) {
                    for (int k = j;  k < size.length; k++) {
                        if (k >= begin && k <= end) {
                            break;
                        }
                        if (k + 1 == begin || k - 1 == end) {
                            //j++;
                            continue;
                        }
                        if(size[k] < size[k - 1]){
                            upper = false;
                            break;
                        }
                        j++;
                    }
                    result++;
                } else {
                    for (int k = j;  k < size.length; k++) {
                        if (k >= begin && k <= end) {
                            break;
                        }
                        if (k + 1 == begin || k - 1 == end) {
                            //j++;
                            continue;
                        }
                        if(size[k] > size[k - 1]){
                            upper = true;
                            break;
                        }
                        j++;
                    }
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    public static ArrayList<Integer> ERange(int[] size, int E) {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = E; i > 0; i--) {
            if (size[i] > size[E]) {
                range.add(i);
                break;
            } else if (size[i] < size[E]){
                range.add(i);
            }
        }
        for (int i = E; i < size.length; i++) {
            if (size[i] > size[E]) {
                range.add(i);
                break;
            } else if (size[i] < size[E]){
                range.add(i);
            }
        }
        return range;
    }
}
