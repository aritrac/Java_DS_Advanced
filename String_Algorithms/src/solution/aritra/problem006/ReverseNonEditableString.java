package solution.aritra.problem006;

/**
 * Author: Aritra Chatterjee
 * Problem: If the string is non editable, how do we create a string that is the reverse of given string
 * Description: If the string is not editable, then we need to create an array and return the pointer of that
 */
public class ReverseNonEditableString {
    public static String reverse(String str){
        int i, len = str.length();
        StringBuffer dest = new StringBuffer(len);
        for(i = len - 1; i >= 0; i--){
            dest.append(str.charAt(i));
            return dest.toString();
        }
        return null;
    }
}
