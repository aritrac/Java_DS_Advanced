/**
 * Author: Aritra Chatterjee
 * Problem: Find the longest common subsequence in two arrays of characters
 * Solution: Let us start with some simple observations about the LCS problem. If we have two strings say
 * "ABCBDAB" and "BDCABA" and if we draw lines from the letters in the first string to the corresponding letters
 * in the second, no two lines cross. So in the above example there will be three possibilities
 * {"BCBA","BDAB","BCAB"}. Here is the algorithm described below for a recursive solution, next we will discuss DP
 * -> if X[i] == Y[j] : 1 + LCS(i+1,j+1)
 * -> if X[i] != Y[j] : Max{LCS(i,j+1), LCS(i+1,j)}
 * -> if i == m and j == n then return 0
 */
public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        System.out.println("Longest common subsequence = " + LCSLength(X,Y));
    }

    public static String LCSLength(String X, String Y){
        int m = X.length();
        int n = Y.length();
        if(m == 0 || n == 0)
            return "";
        else if(X.charAt(m-1) == Y.charAt(n-1))
            return LCSLength(X.substring(0,m-1),Y.substring(0,n-1)) + X.charAt(m-1);
        else{
            String x = LCSLength(X,Y.substring(0,n-1));
            String y = LCSLength(X.substring(0,m-1),Y);
            return (x.length() > y.length()) ? x:y;
        }
    }
}
