package InterviewTest.Meituan.meituan2021.tencent;

import java.util.LinkedList;

public class tencent202101 {
    public static void main(String[] args) {
        String result = compress("HG[3|B[2|CA]]F");
        System.out.println(result);
    }
    public static String compress (String str) {
        // write code here
        int len = str.length();
        StringBuilder r = new StringBuilder(str);
        StringBuilder res = new StringBuilder();
        int begin = str.indexOf('[');
        int end = str.lastIndexOf(']');
        StringBuilder tempResult = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = end; i  > begin ; i--) {
            if(str.charAt(i) == ']' && str.charAt(i - 1) == ']') {
                continue;
            }
            if (str.charAt(i) == '|') {
                int tempMul = str.charAt(i - 1) - '0';
                temp = temp.append(tempResult);
                tempResult = mul(tempMul, temp);
            }
            if (str.charAt(i) == ']' || str.charAt(i) == '[') {
                temp = new StringBuilder();
                for (int j = i - 1; j >0;j--) {
                    if (str.charAt(j) == '|') {
                        break;
                    } else {
                        temp.insert(0, str.charAt(j));
                    }
                }
            }
        }
        r = r.replace(begin, end + 1, tempResult.toString());
        return r.toString();
    }

    public static StringBuilder mul(int m, StringBuilder builder) {
        String temp = builder.toString();
        StringBuilder b = new StringBuilder();
        for(int i = 0;i < m;i++) {
            b.append(temp);
        }
        return b;
    }
}
