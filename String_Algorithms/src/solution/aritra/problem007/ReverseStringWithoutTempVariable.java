package solution.aritra.problem007;

/**
 * Author: Aritra Chatterjee
 * Problem: Reverse a string without using any temporary variable
 * Description: We can use XOR logic for swapping the variables as shown in the algorithm below
 */
public class ReverseStringWithoutTempVariable {
    public static void main(String[] args) {
        String s = "Aritra";
        System.out.println(reverseString(new StringBuffer(s)));
    }

    public static String reverseString(StringBuffer str){
        int end = str.length() - 1;
        int start = 0;
        while(start < end){
            str.setCharAt(start, (char)(str.charAt(start) ^ str.charAt(end)));
            str.setCharAt(end, (char)(str.charAt(end) ^ str.charAt(start)));
            str.setCharAt(start, (char)(str.charAt(start)^str.charAt(end)));
            ++start;
            --end;
        }
        return str.toString();
    }
}
