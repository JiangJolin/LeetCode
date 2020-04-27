class Solution {
    private void updateRes(double[] ans, double x, double y) {
        if (x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans[0] = x;
            ans[1] = y;
        }
    }
    // 判断 (x, y) 是否在「线段」(x1, y1)~(x2, y2) 上
    // 这里的前提是 (x, y) 一定在「直线」(x1, y1)~(x2, y2) 上
    private boolean isInside(double x1, double y1, double x2, double y2, double x, double y) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        return (x1 == x2 || (Math.min(x1, x2) <= x && x <= Math.max(x1, x2)))
                && (y1 == y2 || (Math.min(y1, y2) <= y && y <= Math.max(y1, y2)));
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double x1 = (double)start1[0], x2 = (double)end1[0];
        double y1 = (double)start1[1], y2 = (double)end1[1];
        double a1 = (double)start2[0], a2 = (double)end2[0];
        double b1 = (double)start2[1], b2 = (double)end2[1];
        double[] ans = new double[2];
        Arrays.fill(ans, Double.MAX_VALUE);

        if((x2 - x1)*(b2 - b1) == (y2 - y1)*(a2 - a1)){
            if ((y2-y1)*(a1-x1) == (b1-y1)*(x2-x1)) {
            // 判断 (a1, b1) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, a1, b1)) {
                    updateRes(ans, a1, b1);
                }
                // 判断 (a2, b2) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, a2, b2)) {
                    updateRes(ans, a2, b2);
                }
                // 判断 (x1, y1) 是否在「线段」(a1, b1)~(a2, b2) 上
                if (isInside(a1, b1, a2, b2, x1, y1)) {
                    updateRes(ans, (double)x1, (double)y1);
                }
                // 判断 (x2, y2) 是否在「线段」(a1, b1)~(a2, b2) 上
                if (isInside(a1, b1, a2, b2, x2, y2)) {
                    updateRes(ans, (double)x2, (double)y2);
                }
            }
        }else{
            double t1 = (double)(a1 * (b2 - b1) + y1 * (a2 - a1) - b1 * (a2 - a1) - x1 * (b2 - b1)) / ((x2 - x1) * (b2 - b1) - (a2 - a1) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + b1 * (x2 - x1) - y1 * (x2 - x1) - a1 * (y2 - y1)) / ((a2 - a1) * (y2 - y1) - (x2 - x1) * (b2 - b1));
      // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
            }
        }
        if (ans[0] == Double.MAX_VALUE) {
            return new double[0];
        }
        return ans;
    }
}