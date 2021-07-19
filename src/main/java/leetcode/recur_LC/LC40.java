package leetcode.recur_LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC40 {
    public static void main(String[] args) {
        LC40 l = new LC40();
        int[] c = new int[]{1, 2, 7, 6, 1, 5};
        l.combinationSum2(c, 8);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return list;

        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(candidates);
        recur(candidates, target, res, list, 0,0);

        return list;
    }

    private void recur(int[] can, int target, List<Integer> res, List<List<Integer>> list, int sum,int index) {
        //if(index > can.length - 1) return;
        if (target == 0) {
            list.add(new ArrayList<>(res));
            return;
        }
        if(sum > target) return;

        for(int i = index;i < can.length;i++) {
            if (target - can[i] < 0) {
                break;
            }
            if (i > index && can[i] == can[i - 1]) {
                continue;
            }
            res.add(can[i]);
            recur(can, target - can[i],res,list,target - can[i],i + 1);
            res.remove(res.size() - 1);
        }
    }
}
