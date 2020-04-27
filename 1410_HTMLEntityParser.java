import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public String entityParser(String text) {
        // StringBuilder ans = new StringBuilder();
        // String reg = "&[a-z]*;";
        // Pattern p = Pattern.compile(reg);
        // Matcher m = p.matcher(text);
        // int start = 0, end = 0;
        // while(m.find()){
        //     start = m.start();
        //     ans = ans.append(text.substring(end, start));
        //     end = m.end();
            
        //     String special = text.substring(start, end);

        //     if(special.equals("&quot;")){
        //         ans = ans.append("\"");
        //         //System.out.println(1);
        //     }else if(special.equals("&apos;")){
        //         ans = ans.append("'");
        //         // System.out.println(2);
        //     }else if(special.equals("&amp;")){
        //         ans = ans.append("&");
        //         // System.out.println(3);
        //     }else if(special.equals("&gt;")){
        //         ans = ans.append(">");
        //         // System.out.println(4);
        //     }else if(special.equals("&lt;")){
        //         ans = ans.append("<");
        //         // System.out.println(5);
        //     }else if(special.equals("&frasl;")){
        //         ans = ans.append("/");
        //         // System.out.println(6);
        //     }else{
        //         ans = ans.append(special);
        //         // System.out.println(7);
        //     }
            
        // }

        // ans = ans.append(text.substring(end));
        // return ans.toString();
        return text.replace("&quot;", "\"").replace("&apos;", "'").replace("&amp;", "&").replace("&gt;", ">").replace("&lt;", "<").replace("&frasl;", "/");

    }
}