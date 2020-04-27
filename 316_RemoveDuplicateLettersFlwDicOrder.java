import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int s_len = s.length();
        if (s_len < 2)
            return s;

        // 记录每个字符出现的最后一个位置
        int[] lastAppear = new int[26];
        for (int i = 0; i < s_len; i++) {
            lastAppear[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        // 此时 `a` 作为哨兵，这个 `a` 永远不会被弹出
        // 如此一来，在遍历的时候，就不用判断栈是否为空了
        stack.push('a');

        for (int i = 0; i < s_len; i++) {
            char currentChar = s.charAt(i);
            if (lastAppear[currentChar - 'a'] < 0) {
                continue;
            }

            while (stack.peek() > currentChar && -lastAppear[stack.peek() - 'a'] >= i) {
                char top = stack.pop();
                lastAppear[top - 'a'] *= -1;
            }

            stack.push(currentChar);
            lastAppear[currentChar - 'a'] *= -1;
        }

        int size = stack.size();
        String ans = "";
        // 注意：这里只弹栈 size - 1 次
        for (int i = 0; i < size - 1; i++) {
            ans = stack.pop() + ans;
        }
        return ans;

        // Map<Character, Integer> letter_count = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        // if(letter_count.containsKey(s.charAt(i))){
        // letter_count.put(s.charAt(i), letter_count.get(s.charAt(i)) + 1);
        // }else{
        // letter_count.put(s.charAt(i), 1);
        // }
        // }
        // Stack<Character> ans_stack = new Stack<>();
        // ans_stack.push(s.charAt(0));
        // letter_count.put(s.charAt(0), -1 * letter_count.get(s.charAt(0)) + 1);
        // for(int i = 1; i < s.length(); i++){
        // Character temp = s.charAt(i);
        // Character peek = ans_stack.peek();
        // if(letter_count.get(temp) < 0){
        // letter_count.put(temp, letter_count.get(temp) + 1);
        // continue;
        // }else{
        // while(ans_stack.empty() == false){
        // peek = ans_stack.peek();
        // if ((temp > peek) || (letter_count.get(peek) == 0)){
        // break;
        // }
        // ans_stack.pop();
        // letter_count.put(peek, -1 * letter_count.get(peek));

        // }
        // letter_count.put(temp, -1 * letter_count.get(temp) + 1);
        // ans_stack.push(s.charAt(i));
        // }
        // }
        // String ans = "";
        // while( ans_stack.empty() == false){
        // ans = ans_stack.pop() + ans;
        // }
        // return ans;
    }
}