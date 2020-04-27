class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) return ans;
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            builder.append(words[i]);
            builder.append("|");
        }
        
        String long_str = builder.toString();
        for (int i = 0; i < words.length; i++){
            String temp = words[i];
            if(long_str.indexOf(temp) != long_str.lastIndexOf(temp)) ans.add(temp);
        }
        return ans;
    }
}