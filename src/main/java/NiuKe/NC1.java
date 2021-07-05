package NiuKe;

public class NC1 {
    public String solve (String s, String t) {
        int lens = s.length() - 1;
        int lent = t.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (lens >= 0 && lent >= 0 || carry != 0) {
            int a = lens < 0 ? 0 : s.charAt(lens--) - '0';
            int b = lent < 0 ? 0 : t.charAt(lent--) - '0';
            res.insert(0, (a + b) / 10);
            carry = (a + b) % 10;
        }
        return res.toString();
    }
}
