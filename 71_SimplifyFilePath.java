class Solution {
    public String simplifyPath(String path) {
        Stack<String> addr = new Stack<>();
        String[] components = path.split("/");
        for(int i = 0 ; i < components.length; i++){
            String temp = components[i];
            if(temp.length() == 0 || temp.equals(".")) continue;
            if(temp.equals("..")){
                if(!addr.isEmpty()) addr.pop();
            }else{
                addr.push(temp);
            }
        }
        StringBuilder ans = new StringBuilder();
        if(addr.isEmpty()) return "/";
        while(!addr.isEmpty()){
            ans.insert(0, '/' + addr.pop());
        }
        return ans.toString();
    }
}