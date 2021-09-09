package InterviewTest.Meituan.meituan2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class meituan202101 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 0; i < n ; i++) {
            int m = cin.nextInt();
            int result = 0;
            HashMap<Integer, String> map = new HashMap<>();
            for (int j = 0; j < m;j++) {
                int key = cin.nextInt();
                int value = cin.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + String.valueOf(value));
                } else {
                    map.put(key, String.valueOf(key)+String.valueOf(value));
                }
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + String.valueOf(key));
                } else {
                    map.put(value, String.valueOf(value)+String.valueOf(key));
                }
                Integer maxIndex = 0;
                int[] temp = new int[2];
                int z = 0;
                for(Integer k : map.keySet()) {
                    char[] c = map.get(k).toCharArray();
                    if (result >= c.length) {
                        temp[z] = k;
                    }
                }
                String tempresult = map.get(temp[0]) + map.get(temp[1]);
                Set<Character> s = new HashSet<>();
                char[] c = tempresult.toCharArray();
                for(int l = 0; l < c.length;l++) {
                    s.add(c[i]);
                }
                result = s.size();
            }
            System.out.println(result);
            result = 0;
            map.clear();
        }
    }
}
