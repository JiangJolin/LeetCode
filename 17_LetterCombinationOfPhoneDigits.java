class Solution {
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new LinkedList<String>();

    public void generate(String s, String digits){
        if(digits.length() == 0){
            ans.add(s);
            return;
        }
        String letter = letters[digits.charAt(0) - '2'];
        for(int i = 0; i < letter.length(); i++){
            generate(s + letter.substring(i, i+1), digits.substring(1));
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() > 0){
            generate("", digits);
        }  
        return ans;
    }
}