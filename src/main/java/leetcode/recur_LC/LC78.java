package leetcode.recur_LC;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> result = new ArrayList<>();
        recur(nums, 0, nums.length, result);
        return res;
    }

    private void recur(int[] nums, int index, int len, List<Integer> result) {
        res.add(new ArrayList<>(result));

        for (int i = index; i < len; i++) {
            result.add(nums[i]);
            recur(nums, i + 1, len, result);
            result.remove(result.size() - 1);
        }
    }
}
