package InterviewTest.Meituan.meituan2021.wangyihuyu;

import java.util.*;

public class wangyihuyu01 {
    static Map<Character, String> toLower = new HashMap<Character, String>() {
        {
            put('1', "1");
            put('2', "10");
            put('3', "11");
            put('4', "100");
            put('5', "101");
            put('6', "110");
            put('7', "111");
            put('8', "1000");
            put('9', "1001");
            put('0', "0");
        }
    };
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for(int i = 0;i < T;i++) {
            int N = cin.nextInt();
            ArrayList<String> l = toArray(N);
            StringBuilder builder = new StringBuilder();
            for(String e : l) {
               builder.append(e);
            }
            builder.reverse();
            builder = removeZeroS(builder);
            StringBuilder b = removeC(builder);
            System.out.println(b);
        }
    }

    public static ArrayList toArray(int n) {
        ArrayList<String> l = new ArrayList<>();
        String s = String.valueOf(n);
        for (int i = 0; i < s.length();i++) {
            l.add(toLower.get(s.charAt(i)));
        }
        return l;
    }

    public static StringBuilder removeC(StringBuilder b) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b.length();i++) {
            Character c = b.charAt(i);
            res.append(c);
            for (int j = i + 1;j < b.length();j++) {
                Character c1 = b.charAt(j);
                if (c1 == c) {
                    i++;
                    continue;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static StringBuilder removeZeroS(StringBuilder b) {
        int i = 0;
        for(i = 0; i < b.length();i++) {
            if (b.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }
        String s = b.substring(i, b.length());
        return new StringBuilder(s);
    }
}
