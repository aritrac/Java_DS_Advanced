package solution.aritra.problem010;

/**
 * Author: Aritra Chatterjee
 * Problem: Unlike permutations, two combinations are considered to be the same if they contain the same characters,
 * but may be in a different order. Give an algorithm that prints all possible combinations of the characters
 * in a string. For example, "ac" and "ab" are different combinations from the input string "abc", but "ab" is the same
 * as "ba"
 * Description: The solution is achieved by generating n!/r!(n-r)! strings, each of length between 1 and n where n is
 * the length of the given input string.
 * For each of the input characters
 *  a)Put the current character in output string and print it
 *  b)If there are any remaining characters, generate combinations with those remaining characters
 */
public class CombinationsOfAString {
    public static void main(String[] args) {
        String s = "abcd";
        combinationsOne(s);
        System.out.println("****************");
        combinationsTwo(s);
    }
    //print all subsets of the characters in str
    public static void combinationsOne(String str){
        combinationsOne("",str);
    }

    //print all subsets of the remaining elements, with given prefix
    private static void combinationsOne(String prefix, String str){
        if(str.length() > 0){
            System.out.println(prefix + str.charAt(0));
            combinationsOne(prefix + str.charAt(0), str.substring(1));
            combinationsOne(prefix,str.substring(1));
        }
    }
    //alternate implementation
    public static void combinationsTwo(String str){
        combinationsTwo("",str);
    }

    private static void combinationsTwo(String prefix, String str){
        System.out.println(prefix);
        for(int i = 0; i < str.length(); i++)
            combinationsTwo(prefix + str.charAt(i), str.substring(i+1));
    }
}
