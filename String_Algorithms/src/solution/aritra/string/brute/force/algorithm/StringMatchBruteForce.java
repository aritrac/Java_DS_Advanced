package solution.aritra.string.brute.force.algorithm;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate the brute force string match algorithm where T is the main string in which to search which
 * has length n and P is the search string of length m.
 * Description: Follow the code below to understand
 */
public class StringMatchBruteForce {
    //T
    public static int bruteForceStringMatch(String T, int n, String P, int m){
        for(int i = 0; i <= n -m; i++){
            int j = 0;
            while(j < m && P.charAt(j) == T.charAt(j + i))
                j = j + 1;
            if(j == m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String T = "I am a good programmer";
        String P = "good";
        System.out.println("The position of P in T is " + bruteForceStringMatch(T,T.length(),P,P.length()));
    }
}
