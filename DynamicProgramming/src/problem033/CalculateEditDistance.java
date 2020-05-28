package problem033;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two strings A of length m and B of length n, transform A into B with a minimum number of operations
 * of the following types: delete a character from A, insert a character into A, or change some characters in A
 * into a new character. The minimal number of such operations required to transform A into B is called the edit
 * distance between A and B.
 * Description:
 * The idea is process all characters one by one staring from either from left or right sides of both strings.
 * Let us traverse from right corner, there are two possibilities for every pair of character being traversed.
 * m: Length of str1 (first string)
 * n: Length of str2 (second string)
 * If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining
 * strings. So we recur for lengths m-1 and n-1.
 * Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last
 * character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
 * Insert: Recur for m and n-1
 * Remove: Recur for m-1 and n
 * Replace: Recur for m-1 and n-1
 */

public class CalculateEditDistance {
    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    //Recursive solution
    static int editDist(String str1, String str2, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editDist(str1, str2, m, n - 1), // Insert
                editDist(str1, str2, m - 1, n), // Remove
                editDist(str1, str2, m - 1, n - 1) // Replace
        );
    }

    //DP Solution
    static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[m][n];
    }

    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
    }
}
