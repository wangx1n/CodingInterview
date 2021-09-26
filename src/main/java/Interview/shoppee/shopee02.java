package InterviewTest.Meituan.meituan2021.shoppee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class shopee02 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(9);
        System.out.println(minEffort(a));
    }
    public static int minEffort(ArrayList<Integer> cases) {
        int res = 0;
        while (cases.size() != 1) {
            Collections.sort(cases);
            Integer a = cases.get(0), b = cases.get(1);
            Integer c = a + b;
            cases.remove(a);
            cases.remove(b);
            cases.add(c);
            res+=c;
            HashMap
        }
        return res;
    }
}
