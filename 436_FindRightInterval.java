//执行用时 :23 ms, 在所有 Java 提交中击败了70.32%的用户
//内存消耗 :45.6 MB, 在所有 Java 提交中击败了90.80%的用户

import java.util.TreeMap;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> intv_tree = new TreeMap<Integer, Integer>();
        for(int i = 0; i < intervals.length; i++){
            intv_tree.put(intervals[i][0], i);
        }
        int[] ans = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            Integer right = intv_tree.ceilingKey(intervals[i][1]);
            ans[i] = right == null ? -1 : intv_tree.get(right);
        }
        return ans;
    }
}