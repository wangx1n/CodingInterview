package Interview.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class tencent2021092601 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int T = sin.nextInt();
        while (T > 0) {
            int x = sin.nextInt();
            System.out.println(minSub(x));
            T--;
        }
    }

    public static Long minSub(int x) {
        for (long i = x; i < 10000000; i++) {
            if (i == 2029099) {
                int a = 1;
                if (a == 1);
            }
            ArrayList<Long> l = factor(i, x);
            if (l != null) {
                Long L = new Long(l.size() - 1);
                return i;
            }
        }
        return Long.MAX_VALUE;
    }

    public static ArrayList<Long> factor(long a, int x) {
        ArrayList<Long> l = new ArrayList<>();
        int cnt = 0;
        for (long i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                l.add(i);
                cnt++;
                if (i * i != a) {
                    cnt++;
                    l.add(a / i);
                }
            }
        }
        if (cnt < 4) {
            return null;
        }
        if (sub(l, x)) {
            return l;
        }
        return null;
    }

    public static boolean sub(ArrayList<Long> l, int x) {
        Collections.sort(l);
        for (int i = 1; i < l.size();i++) {
            if (l.get(i) - l.get(i - 1) < x) {
                return false;
            }
        }
        return true;
    }
}
