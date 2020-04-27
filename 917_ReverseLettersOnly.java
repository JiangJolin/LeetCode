class Solution {
    public String reverseOnlyLetters(String S) {
        int l = 0;
        int r = S.length() - 1;
        if (r < 1) {
            return S;
        }
        char[] s_array = S.toCharArray();
        while (true) {
            while (l < S.length() && !Character.isLetter(s_array[l])) {
                l++;
            }
            while (r > 0 && !Character.isLetter(s_array[r])) {
                r--;
            }
            if (l >= r) {
                break;
            }
            Character temp = s_array[l];
            s_array[l] = s_array[r];
            s_array[r] = temp;
            l++;
            r--;
        }
        String ans = new String(s_array);
        return ans;
        // Stack<Character> letters = new Stack<>();
        // Queue<Integer> others = new LinkedList<Integer>();
        // for(int i = 0; i < S.length(); i++){
        // Character temp = S.charAt(i);
        // if (Character.isLetter(temp)){
        // letters.push(temp);
        // }else{
        // others.offer(i);
        // }
        // }
        // String ans = "";
        // int next_other_pos = -1;
        // int letter_num = letters.size();
        // if (others.size() != 0){
        // next_other_pos = others.poll();
        // }
        // int count = 0;
        // for(int i = 0; i < letter_num; i ++){
        // while ( i+count == next_other_pos ){
        // ans += S.charAt(next_other_pos);
        // if (others.size() != 0){
        // next_other_pos = others.poll();
        // }
        // count ++;
        // }
        // ans += letters.pop();
        // }
        // while ( letter_num+count == next_other_pos ){
        // ans += S.charAt(next_other_pos);
        // if (others.size() != 0){
        // next_other_pos = others.poll();
        // }
        // count ++;
        // }
        // return ans;
    }
}