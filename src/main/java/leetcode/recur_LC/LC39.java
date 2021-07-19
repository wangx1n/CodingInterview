package leetcode.recur_LC;

import java.util.*;

public class LC39 {
    public static void main(String[] args) {
        LC39 l = new LC39();
        int[] c = new int[]{2,3,6,7};
        l.combinationSum(c, 7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return list;

        List<Integer> res = new ArrayList<Integer>();
        recur(candidates, target, res, list, 0,0);

        return list;
    }

    private void recur(int[] can, int target, List<Integer> res, List<List<Integer>> list, int sum,int index) {
        //if(index > can.length - 1) return;
        if (sum == target) {
            List<Integer> a = new ArrayList<Integer>();
            for(int c : res) {
                a.add(c);
            }
            Collections.sort(a);
            if(list.size() == 0) {
                list.add(a);
                index += 1;
                return;
            }
            list.add(a);
        }
        if(sum > target) return;

        for(int i = index;i < can.length;i++) {
            res.add(can[i]);
            sum += can[i];
            recur(can, target,res,list,sum,index);
            sum -= can[i];
            res.remove(res.size() - 1);
        }
    }
}
