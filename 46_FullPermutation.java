class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    // public void backtrack(int n, List<Integer> output, int first) {
    // // 所有数都填完了
    //     if (first == n) res.add(new ArrayList<Integer>(output));
    //     for (int i = first; i < n; i++) {
    //         // 动态维护数组
    //         Collections.swap(output, first, i);
    //         // 继续递归填下一个数
    //         backtrack(n, output, first + 1);
    //         // 撤销操作
    //         Collections.swap(output, first, i);
    //     }
    // }

    // public List<List<Integer>> permute(int[] nums) {
    //     res = new LinkedList();

    //     ArrayList<Integer> output = new ArrayList<Integer>();
    //     for (int num : nums) output.add(num);

    //     int n = nums.length;
    //     backtrack(n, output, 0);
    //     return res;
    // }
}