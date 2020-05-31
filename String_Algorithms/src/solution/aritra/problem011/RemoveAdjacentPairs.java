package solution.aritra.problem011;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a string "ABCCBCBA", give an algorithm for recursively removing the adjacent characters if they are
 * the same. For example, ABCCBCBA -> ABBCBA -> ACBA
 * Description: First we need to check if we have a character pair, if yes, then cancel it. Now check the next character
 * and previous element. Keep cancelling the characters until we either reach the start of the array, reach the end
 * of the array, or dont find a pair
 */
public class RemoveAdjacentPairs {
    public static void main(String[] args) {
        char[] s = {'A','B','C','C','B','C','B','A'};
        removeAdjacentPairs(s,s.length);
    }

    public static void removeAdjacentPairs(char[] str, int len){
        int j = 0;
        for(int i = 1; i < len; i++){
            while(str[i] == str[j] && j>= 0){
                i++;
                j--;
            }
            str[++j] = str[i];
        }
        for(int i = 0; i <= j; i++){
            System.out.print(str[i]);
        }
    }
}
