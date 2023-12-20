package unique_chars;

import java.util.HashMap;

public class Solution {

	public static String uniqueChar(String str){
		if(str.length()==0){
            return "\0";
        }

        String out="";
        HashMap<Character,Boolean> ch=new HashMap<>();

        for(int i=0;i<str.length();++i){
            char c=str.charAt(i);
            if(ch.containsKey(c)){
                continue;
            }
            else{
                out+=c;
                ch.put(c, true);
            }

        }

        return out;
	}
}