package Interview.meituan;

import java.math.BigInteger;
import java.util.Scanner;

public class meituan01 {
    private static BigInteger last = new BigInteger("-1");
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        System.out.println(isDivied(s));
    }
    public static int isDivied(String s) {
        int result = 0;
        int k = 0;
        for (int i = 0; i < s.length();i++) {
            for (int j = 0; j <= i; j++) {
                String temp = s.substring(j, i + 1);
                Long l = Long.valueOf(temp).longValue();
                BigInteger c = BigInteger.valueOf(l);
                if (divide(c)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean divide(BigInteger i) {
        BigInteger b = new BigInteger("22");
        BigInteger r = new BigInteger("0");
        BigInteger rear = i.divideAndRemainder(b)[1];
        if (!last.equals(i) && rear.toString() != r.toString()) {
            last = i;
            return false;
        }
        return true;
    }
}
