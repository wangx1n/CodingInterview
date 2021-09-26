package Interview.tencent;

import java.util.Scanner;

public class tencent202103 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int result = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j % m != 0) {
                result += (-1) * (i+1);
                j++;
            } else {
                result += (i+1);
            }
        }
        System.out.println(result);
        result = 0;
    }
}
