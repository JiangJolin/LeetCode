class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] array = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--){
            ans = ans.append(array[i]+" ");
        }
        return ans.length() > 0 ? ans.deleteCharAt(ans.length() - 1).toString() : "";
    }
}