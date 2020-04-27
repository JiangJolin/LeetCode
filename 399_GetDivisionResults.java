class Solution {
    class Node{
        public double ratio;
        public String parent;
        public Node(String parent){
            this.parent = parent;
            this.ratio = 1.0;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> var = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            List<String> eq = equations.get(i);
            String x = eq.get(0), y = eq.get(1);
            if(!var.containsKey(x)){
                var.put(x, new Node(x));
            }
            if(!var.containsKey(y)){
                var.put(y, new Node(y));
            }

            double weight_x = 1.0;
            while(var.get(x).parent != x){
                weight_x *= var.get(x).ratio;
                x = var.get(x).parent;
            }
            double weight_y = 1.0;
            while(var.get(y).parent != y){
                weight_y *= var.get(y).ratio;
                y = var.get(y).parent;
            }

            if(x != y){
                // System.out.printf("Set %s to be parent of %s, with ratio = %f, (wx%f, wy%f)\n", x, y, values[i] * weight_x / weight_y, weight_x, weight_y);
                Node root_y = var.get(y);
                root_y.parent = x;
                root_y.ratio = values[i] * weight_x / weight_y;
                var.put(y, root_y);
                // System.out.printf("Now %s has parent %s and ration %f\n", y, var.get(y).parent, var.get(y).ratio);
            }
        }
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> q = queries.get(i);
            String x = q.get(0), y = q.get(1);
            if(!var.containsKey(x) || !var.containsKey(y)){
                ans[i] = -1.0;
            }else{
                double weight_x = 1.0;
                while(var.get(x).parent != x){
                    weight_x *= var.get(x).ratio;
                    x = var.get(x).parent;
                }
                double weight_y = 1.0;
                while(var.get(y).parent != y){
                    weight_y *= var.get(y).ratio;
                    y = var.get(y).parent;
                }
                if(x != y){
                    ans[i] = -1.0;
                }else{
                    ans[i] = weight_y / weight_x;
                }
            }
        }
        return ans;
    }
}