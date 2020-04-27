class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n <= numRows || numRows <= 1) return s;
        
        StringBuilder str = new StringBuilder("");

        int gap = numRows * 2 - 2;
        int count_f = n / gap + 1; //How many on row_0
        for(int i = 0; i < numRows; i++){ //row_i in Z shape
            for(int j = i; j < n; j += gap){
                str.append(s.charAt(j));
                if(2*i < gap && 2*i > 0 && j + gap - 2*i < n){
                    str.append(s.charAt(j + gap - 2*i));
                }
            }
        }
        return str.toString();

        // List<StringBuilder> rows = new ArrayList<StringBuilder>();
        // for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        // int row_i = 0, flag = -1;
        // for(int i = 0; i < n; i++) {
        //     rows.get(row_i).append(s.charAt(i));
        //     if(row_i == 0 || row_i == numRows -1) flag = - flag;
        //     row_i += flag;
        // }
        // StringBuilder res = new StringBuilder();
        // for(StringBuilder row : rows) res.append(row);
        // return res.toString();
        
    }
}