class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        //(x, y) is such a point
        //x1 <= x <= x2
        //y1 <= y <= y2
        //(x - xc)^2 + (y - yc)^2 <= r^2
        //xi = x - xc, yi = y - yc
        int xi_min, yi_min;
        if(x1 < x_center && x2 > x_center){
            xi_min = 0;
        }else{
            xi_min = Math.min(Math.abs(x1 - x_center), Math.abs(x2 - x_center));
        }
        if(y1 < y_center && y2 > y_center){
            yi_min = 0;
        }else{
            yi_min = Math.min(Math.abs(y1 - y_center), Math.abs(y2 - y_center));
        }

        if(Math.pow(xi_min, 2) + Math.pow(yi_min, 2) <= Math.pow(radius, 2)){
            return true;
        }else{
            return false;
        }
        
    }
}