/**
 * Author: Aritra Chatterjee
 * Problem: Find the longest common subsequence in two arrays of characters
 * Solution: Let us start with some simple observations about the LCS problem. If we have two strings say
 * "ABCBDAB" and "BDCABA" and if we draw lines from the letters in the first string to the corresponding letters
 * in the second, no two lines cross. So in the above example there will be three possibilities
 * {"BCBA","BDAB","BCAB"}. Here is the algorithm described below for a DP memoization solution, next we will discuss DP
 * -> if X[i] == Y[j] : 1 + LCS(i+1,j+1)
 * -> if X[i] != Y[j] : Max{LCS(i,j+1), LCS(i+1,j)}
 * -> if i == m and j == n then return 0
 * The DP solution is to check, whenever we want to solve a sub problem, whether we've already done it before. So
 * we look up the solution instead of solving it again.Implemented in the most direct way, we just add some code
 * to our recursive solution. First we take care of the base cases. We have created an LCS table with one row and one
 * column larger than the lengths of the two strings. Then run the iterative DP loops to fill each cell in the table.
 * This is link doing recursion backwards, or bottom up. The value of LCS[i][j] depends on three other values
 * (LCS(i,j+1), LCS(i+1,j), LCS(i+1,j+1)) all of which have values larger than LCS[i][j]. They go through the table
 * in the order of decreasing i and j values. This will guarantee that when we need to fill in the value of LCS[i][j],
 * we already know the values of all cells on which it depends.
 */
public class LongestCommonSubsequenceMemoizationDP {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        System.out.println("Longest common subsequence = " + LCSLength(X,Y));
    }

    public static String LCSLength(String X, String Y){
        int[][] table = new int[X.length() + 1][Y.length() + 1];
        //row 0 and col 0 is already initialized to 0
        for(int i = 0; i < X.length(); i++){
            for(int j = 0; j < Y.length(); j++){
                if(X.charAt(i) == Y.charAt(j))
                    table[i+1][j+1] = table[i][j] + 1;
                else
                    table[i+1][j+1] = Math.max(table[i+1][j], table[i][j+1]);
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        //read the substring out from the matrix
        StringBuffer sY = new StringBuffer();
        for(int x = X.length(),y=Y.length(); x != 0 && y != 0;){
            if(table[x][y] == table[x-1][y])
                x--;
            else if(table[x][y] == table[x][y-1])
                y--;
            else{
                sY.append(X.charAt(x-1));
                x--;
                y--;
            }
        }
        return sY.reverse().toString();
    }
}
