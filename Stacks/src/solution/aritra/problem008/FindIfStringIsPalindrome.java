package solution.aritra.problem008;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of characters formed with a's and b's. The string is marked with special character X
 * which represents the middle of the list.(For example: ababa.....X.....ababa)
 * Description: We start with two indexes, one at the beginning of the string and the other at the end of the string.
 * Each time compare whether the values at both the indexes are the same or not. If the values are not the same then
 * we say that the given string is not a palindrome.
 */
public class FindIfStringIsPalindrome {
    public static void main(String[] args) {
        String test1 = "ababaaXaababa"; //palindrome
        String test2 = "bbbbaaXbbaaaa"; //not palindrome

        System.out.println("Is test1 palindrome? " + isPalindrome(test1));
        System.out.println("Is test2 palindrome? " + isPalindrome(test2));
    }

    public static boolean isPalindrome(String testString){
        int i = 0, j = testString.length() - 1;
        while(i < j && testString.charAt(i) == testString.charAt(j)){
            i++;
            j--;
        }
        if(i < j)
            return false;
        else
            return true;
    }
}
