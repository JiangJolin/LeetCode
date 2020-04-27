//执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 : 33.6 MB, 在所有 java 提交中击败了100.00%的用户

class Solution {
    private static String[] dayname_set = { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday",
            "Wednesday" };
    private static int[] day_mounth_set = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public String dayOfTheWeek(int day, int month, int year) {
        int days = (year - 1971) * 365 + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            days += day_mounth_set[i];
        }
        if ((year % 4 == 0) && (month > 2))
            days++;
        days += day;
        return dayname_set[days % 7];
    }
}