class Solution {
    int n;
    String s;
    List<String> output = new LinkedList<String>();
    
    public boolean valid(String segment) {
        int m = segment.length();
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void dfs(int start, int dots, String[] trial){
        if(dots == 0){
            if(valid(s.substring(start))){
                StringBuilder ans = new StringBuilder();
                for(String str: trial){
                    ans.append(str);
                    ans.append(".");
                }
                ans.append(s.substring(start)); 
                output.add(ans.toString());
            }
            return;
        }
        
        int end = start + 3 < n - 1 ? start + 3 : n - 1; //to ensure the last segment has at least 1 char
        for(int i = end; i >= start + 1 && i > n - dots * 3 - 1; i--){ //start from the furthest, reduce # of iteration
            if(valid(s.substring(start, i))){
                trial[3 - dots] = s.substring(start, i);
                dfs(i, dots - 1, trial);
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        dfs(0, 3, new String[3]);
        return output;
    }
}