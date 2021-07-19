package leetcode.recur_LC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        recur(result, nums.length, nums,used,0);
        return res;
    }

    private void recur(List<Integer> result, int target, int[] nums,boolean[] used,int index) {
        if (result.size() == target) {
            res.add(new ArrayList<>(result));
            return;
        }
        if (result.size() > target) return;

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                index = i;
                //[1,1,2]
                //第二个1的时候，1和1的起点一样，且第一个1没有用过，所以剪
                if (i > index && nums[i] == nums[i - 1] && !used[i-1]) continue;
                result.add(nums[i]);
                used[i] = true;
                recur(result, target, nums, used, index);
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
