class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] array = new int[m+1];
        for(int i = 0; i < m + 1; i ++){
            array[i] = i;
        }
        int[] ans = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            int x = queries[i];
            int pre = x; //用来替换的
            int cur = 1;
            while(cur < m + 1 && array[cur] != x){ //x 之前所有数字右移一位
                int temp = array[cur]; //替换
                array[cur] = pre;
                pre = temp;
                cur ++;
            }
            array[cur] = pre;
            ans[i] = cur - 1; //index
        }
        return ans;
    }
}