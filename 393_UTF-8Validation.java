class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for(int i = 0; i < data.length; i++){
            String temp = Integer.toBinaryString(data[i]);
            //System.out.println(temp);
            if(count == 0){
                if(temp.length() >= 8){
                    temp = temp.substring(temp.length() - 8);
                    int cur = 0;
                    while(cur < 5 && temp.charAt(cur) == '1') cur ++;
                    if(cur == 5 || cur == 1) return false;
                    count = cur == 0 ? 0 : cur - 1;
                    //System.out.println(count);
                }
            }else{
                count --;
                if(temp.length() < 8) return false;
                if(temp.charAt(temp.length() - 8) == '0' || temp.charAt(temp.length() - 7) == '1') return false;
            }
        }
        return count == 0 ? true : false;
    }
}