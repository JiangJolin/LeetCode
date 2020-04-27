class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if(s.length() == k) return true;
        boolean[] char_array = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'a';
            if(char_array[temp] == false){
                char_array[temp] = true;
            }else{
                char_array[temp] = false;
            }
        }
        for(int i = 0; i < 26; i++){
            if(char_array[i] == true){
                k--;
            }
        }
        return k >= 0 ? true : false;
    }
}