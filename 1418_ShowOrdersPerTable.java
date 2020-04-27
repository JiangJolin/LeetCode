class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> dish = new HashMap<>();
        // String[] dish;
        // for(List<String> temp : orders){
        //     if(map)
        // }
        //Collections.sort(orders, (v1, v2) -> v1.get(2).compareTo(v2.get(2)));
        Collections.sort(orders, new Comparator<List<String>>() {
            public int compare(List<String> v1, List<String> v2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                return v1.get(2).compareTo(v2.get(2));
            }
        });
        List<List<String>> ans = new ArrayList<List<String>>(orders.size());
        int count = 0;
        List<String> Head = new LinkedList<String>();
        Head.add("Table");
        for(List<String> temp : orders){
            if(!dish.containsKey(temp.get(2))){
                dish.put(temp.get(2), count);
                Head.add(temp.get(2));
                count ++;
            }
        }
        
        
        Map<String, int[]> order = new HashMap<>();
        for(List<String> temp : orders){
            if(!order.containsKey(temp.get(1))){
                order.put(temp.get(1), new int[count]);
            }
            int[] table = order.get(temp.get(1));
            //System.out.println(table);
            table[dish.get(temp.get(2))] ++;
            order.put(temp.get(1), table);
        }
        
        for(Map.Entry<String, int[]> entry : order.entrySet()){
            List<String> ans_temp = new ArrayList<String>();
            ans_temp.add(entry.getKey());
            for(int i : entry.getValue()){
                ans_temp.add(Integer.toString(i));
            }
            ans.add(ans_temp);
        }
        Collections.sort(ans, (v1, v2) -> Integer.parseInt(v1.get(0)) - Integer.parseInt(v2.get(0)));
        ans.add(0, Head);
        return ans;
    }
}