class Solution {
    public String reformat(String s) {
        Queue<Character> iq = new LinkedList<>();
        Queue<Character> cq = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            Character temp = s.charAt(i);
            if(temp - '0' < 10 && temp - '0' > -1){
                iq.offer(temp);
                count ++;
            }else{
                cq.offer(temp);
                count --;
            }
        }
        StringBuilder ans = new StringBuilder();
        if(count == 0){
            while(!iq.isEmpty()){
                ans.append(iq.poll());
                ans.append(cq.poll());
            }
        }else if(count == 1){
            while(!cq.isEmpty()){
                ans.append(iq.poll());
                ans.append(cq.poll());
            }
            ans.append(iq.poll());
        }else if(count == -1){
            while(!iq.isEmpty()){
                ans.append(cq.poll());
                ans.append(iq.poll());
            }
            ans.append(cq.poll());
        }else{
            return "";
        }
        return ans.toString();
    }
}