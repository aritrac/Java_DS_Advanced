package solution.aritra.problem009;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for printing all possible permutations of the characters in a string. Unlike
 * combinations, two permutations are considered distinct if they contain the same characters but in a different
 * order. For simplicity assume that each occurrence of a repeated character is a distinct character. That is,
 * if the input is "aaa", the output should be six repetitions of "aaa". The permutations may be output in any order.
 * Description: The solution is reached by generating n! strings, each of length n, where n is the length of the
 * input string.
 */
public class PermutationsOfAString {
    public static void main(String[] args) {
        String s = "abcd";
        permutationsInOrder(s);
        System.out.println("***************************");
        permutationsNotInOrder(s);
    }

    public static void permutationsInOrder(String s){
        permutationsInOrder("",s);
    }
    private static void permutationsInOrder(String prefix, String s){
        int len = s.length();
        if(len == 0){
            System.out.println(prefix);
        }else{
            for(int i = 0; i < len; i++){
                permutationsInOrder(prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1, len));
            }
        }
    }
    public static void permutationsNotInOrder(String s){
        int len = s.length();
        char[] a = new char[len];
        for(int i = 0; i < len; i++)
            a[i] = s.charAt(i);
        permutationsNotInOrder(a,len);
    }
    public static void permutationsNotInOrder(char[] a, int n){
        if(n == 1){
            System.out.println(a);
            return;
        }
        for(int i = 0; i < n; i++){
            swap(a,i,n-1);
            permutationsNotInOrder(a,n-1);
            swap(a,i,n-1);
        }
    }
    //swap the characters at indices i and j
    private static void swap(char[] a, int i, int j){
        char c;
        c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}
