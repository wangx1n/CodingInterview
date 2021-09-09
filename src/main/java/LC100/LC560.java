package LC100;

import java.util.HashMap;

public class LC560 {
    public static void main(String[] args) {
        LC560 l = new LC560();
        l.subarraySum(new int[]{3,4,7,2,-3,1,4,2,1}, 7);
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
