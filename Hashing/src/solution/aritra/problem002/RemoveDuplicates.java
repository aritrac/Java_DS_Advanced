package solution.aritra.problem002;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of characters, give an algorithm for removing the duplicates
 * Description: Start with the first character and check whether it appears in the remaining part of the string
 * using a simple linear search. If it repeats bring the last character to that position and decrement the size of
 * the string by one. Continue this process for each distinct character of the given string.
 */
public class RemoveDuplicates {
    public static void removeDuplicates(char[] s, int n){
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n;){
                if(s[i] == s[j])
                    s[j] = s[--n];
                else
                    j++;
            }
        }
        for(int i = 0; i <=n ; i++){
            System.out.print(s[i]);
        }
    }

    public static void main(String[] args) {
        String s = "ABCCBAAAC";
        removeDuplicates(s.toCharArray(),s.length());
    }
}
