//执行用时 : 2 ms, 在所有 java 提交中击败了99.75%的用户
//内存消耗 : 35.9 MB, 在所有 java 提交中击败了88.19%的用户
import java.util.*;

class Solution {
    private boolean isInt(char c) {
        return (c >= 48 && c <= 57);
    }

    public int myAtoi(String str) {
        int cur = 0;
        int len = str.length();
        char[] str_arr = str.toCharArray();
        long ans = 0;
        boolean neg = false;
        short bit_count = 0;
        while (cur < len && str_arr[cur] > 0) {
            char temp = str_arr[cur];
            if (isInt(temp)) {
                ans = ans * 10 + temp - 48;
                bit_count++;
                if (bit_count > 9 && ans != (int) ans) {
                    if (neg)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            } else if ((temp == 45 || temp == 43) && bit_count == 0) {
                if (cur < len - 1 && isInt(str_arr[cur + 1])) {
                    neg = temp == 45 ? true : false;
                } else {
                    break;
                }
            } else if (temp != 32 || bit_count > 0) {
                break;
            }
            cur++;
        }

        if (neg)
            return -(int) ans;
        return (int) ans;
    }
}