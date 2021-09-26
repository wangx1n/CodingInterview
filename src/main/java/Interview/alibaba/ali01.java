package InterviewTest.Meituan.meituan2021.alibaba;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ali01 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int i = 0;i < t;i++) {
            int n = cin.nextInt(), k = cin.nextInt();
            ArrayList<Integer> in = new ArrayList<>();
            ArrayList<Integer> out = new ArrayList<>();
            for (int j = 0; j < n;j++){
                in.add(cin.nextInt());
            }
            for (int z = 0; z < n;z++){
                out.add(cin.nextInt());
            }
            ArrayList<Integer> limitin = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            int lastpos = 0;
            for (int l = 0; l < n ;l++) {
                Integer pop = out.get(l);
                if (limitin.size() < k) {
                    for (; lastpos < n;lastpos++){
                        if (result.contains(in.get(lastpos))) continue;
                        limitin.add(in.get(lastpos));
                        if (limitin.size() == k) {
                            break;
                        }
                    }
                }
                if (valid(limitin, pop)) {
                    limitin.remove(pop);
                } else {
                    result.add(pop);
                }
            }
            System.out.println(result.size());
        }
    }

    public static boolean valid(ArrayList<Integer> push, int pop) {
        Deque<Integer> stack = new LinkedList<>();
        for (Integer num : push) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == pop) {
                return true;
            }
        }
        return false;
    }
}
