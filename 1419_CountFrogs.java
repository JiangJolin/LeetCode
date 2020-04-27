class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, count = 0;
        for(int i = 0; i < croakOfFrogs.length(); i++){
            char temp = croakOfFrogs.charAt(i);
            switch (temp){
                case 'c':
                    c++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    break;
                default:
                    return -1;
            }
            if(r > c || o > r || a > o || k > a) return -1;
            count = Math.max(c, count);
            if(k == 1){
                c --;
                r --;
                o --;
                a --;
                k --;
            }
        }
        return (c + r + o + a + k == 0) ? count : -1;
    }
}