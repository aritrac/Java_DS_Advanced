package problem019;

/**
 * Author: Aritra Chatterjee
 * Problem: Given n types of coin denominations of values v1 < v2 < ... < vn (integers). Assume v1 = 1, so that we
 * can always make change for any amount of money C. Give an algorithm which makes change for an amount of money C
 * with as few coins as possible.
 * Description: Let us try formulating the recurrence. Let M(j) indicate the minimum the minimum number of coins
 * required to make change for the amount of money equal to j.
 *                              M(j) = Min i {M(j - vi)} + 1
 * If coin denomination i was the last denomination coin added to the solution, then the optimal way to finish the
 * solution with that one is to optimally make change for the amount of money j - vi and then add an extra coin of
 * value vi.
 */
public class MakeCoinChange {
    // m is size of coins array (number of different coins)
    // V is the change to be made
    // coins are the actual coin denominations
    static int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
    }
}
