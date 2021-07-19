package leetcode.greedy;

public class LC134 {
    public static void main(String[] args) {
        LC134 l = new LC134();
        l.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
