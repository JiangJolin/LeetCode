class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] units = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < 13 && num > 0; i++){
            while(num >= units[i]){
                ans.append(symbol[i]);
                num -= units[i];
            }
        }
        return ans.toString();
    }
}