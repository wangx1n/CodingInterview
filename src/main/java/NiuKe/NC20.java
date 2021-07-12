package NiuKe;

import java.util.ArrayList;

public class NC20 {
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here

        ArrayList<String> list = new ArrayList<>();
        recur(s,0,3,list);
        return list;
    }

    private void recur(String s,int position, int count, ArrayList<String> list) {
        if (count == 0) {
            String[] result = s.split("\\.");
            if (result.length < 4) return;
            for (String res : result) {
                if (res.length() > 1 && res.charAt(0) == '0') {
                    return;
                }
                if (Integer.parseInt(res) < 0 || Integer.parseInt(res) > 255) {
                    return;
                }
            }
            list.add(s);
            return;
        }

        int n = s.length();

        recur(s.substring(0, position + 1) + "." + s.substring(position + 1, n),
                position + 1, count--, list);
        if (position + 2 < n) {
            recur(s.substring(0, position + 2) + "." + s.substring(position + 2, n),
                    position + 2, count--, list);
        }
        if (position + 3 < n) {
            recur(s.substring(0, position + 3) + "." + s.substring(position + 3, n),
                    position + 3, count--, list);
        }
    }
}
