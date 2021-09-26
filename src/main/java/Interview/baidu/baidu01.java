package InterviewTest.Meituan.meituan2021.baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baidu01 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        if (n == 0 || k == 0) {
            System.out.println(0);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < k; i++) {
            res.add(reverse(n * i));
        }
        Collections.sort(res);
        if (res.size() == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(res.get(res.size() - 1));
    }

    public static int reverse(int n) {
        int result = 0;
        while(n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        return result;
    }
}
