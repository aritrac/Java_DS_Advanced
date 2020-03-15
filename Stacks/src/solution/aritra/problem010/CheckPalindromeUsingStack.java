package solution.aritra.problem010;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: We have two strings made out of a's and b's with X marking the middle of the string. Using a stack find
 * if such string is a palindrome or not
 * Description: We can use the following algo:
 * ->Traverse the list till we encounter X as input element
 * ->During the traversal push all the elements (until X) on to the stack.
 * ->For the second half of the list, compare each element's content with top of the stack. If they are the same
 * then pop the stack and go to the next element in the input list
 * ->If they are not the same then the given string is not a palindrome
 * ->Continue this process until the stack is empty or the string is not a palindrome.
 */
public class CheckPalindromeUsingStack {
    public static void main(String[] args) {
        String test1 = "abababXbababa"; //palindromic
        String test2 = "aabbaaXbbaabb"; //non palindromic
        System.out.println("Is test1 palindrome? " + isPalindrome(test1));
        System.out.println("Is test2 palindrome? " + isPalindrome(test2));
    }

    public static boolean isPalindrome(String testString){
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while(testString.charAt(i) != 'X'){
            stk.push(testString.charAt(i));
            i++;
        }

        i++; //incrementing to position past X
        while(i < testString.length() && testString.charAt(i) == stk.pop())
            i++;
        return i == testString.length();
    }
}
