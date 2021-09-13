package InterviewTest.Meituan.meituan2021.meituan;

import java.util.*;

public class meituan02 {
    public static String Nill = "0 ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            Map<Integer, List<Integer>> g = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int begin = sc.nextInt();
                int end = sc.nextInt();
                List<Integer> tempBegin = g.getOrDefault(begin, new ArrayList<Integer>());
                tempBegin.add(end);
                g.put(begin, tempBegin);
                List<Integer> tempEnd = g.getOrDefault(end, new ArrayList<Integer>());
                tempEnd.add(begin);
                g.put(end, tempEnd);
            }
            for (int i = 0; i < q; i++) {
                int begin = sc.nextInt();
                int end = sc.nextInt();
                List<Integer> tempBegin = g.get(begin);
                List<Integer> tempEnd = g.get(end);
                g.put(begin, tempEnd);
                g.put(end, tempBegin);
            }
            for (int i = 1;i < n;i++) {
                List<Integer> curr = g.get(i);
                if (curr == null) {
                    System.out.print(Nill);
                } else {
                    System.out.print(curr.size() + " ");
                }
            }
            List<Integer> curr = g.get(n);
            if (curr == null) {
                System.out.println("0");
            } else {
                System.out.println(curr.size());
            }
        }
    }
}
