class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList();
        dfs("(", n-1, n);
        return ans;
    }

    private void dfs(String s, int left, int right){
        if(left > right) return;
        if(left == 0 && right == 1){
            ans.add(s+")");
            return;
        }
        if(left > 0){
            dfs(s+"(", left - 1, right);
        }
        if(right > 0){
            dfs(s+")", left, right-1);
        }
    }
}