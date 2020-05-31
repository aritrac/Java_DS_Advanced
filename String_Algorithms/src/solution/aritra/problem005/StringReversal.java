package solution.aritra.problem005;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for reversing a string
 * Description: The solution is quite simple. Please see the code below
 */
public class StringReversal {
    public String reversingString(StringBuffer str){
        char temp;
        int start = 0, end = str.length();
        for(start = 0; start < end; start++, end--){
            temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end,temp);
        }
        return str.toString();
    }
}
