package problem042;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a number, write a program to find out minimun numbers required whose square is equal to the number
 * Description:
 * Given Number: N
 *
 * Find the square root of a given number ‘N’ and take the integer part of it, say it is ‘x’
 *
 * Now numbers from 1 to x are the options which can be used, whose square sum is equal to N.
 * Now of you notice, this problem has been reduced to “Minimum Coin Change Problem” with some modification.
 * In “Minimum Coin Change Problem“, the minimum numbers of coins are required to make change of a given amount,
 * here minimum numbers required whose square sum is equal to given number.
 */
public class MinNumbersWhoseSquareSumResultsToGivenNumber {
    //Recursive solution
    public static void solve(int n) {
        int options = (int) Math.sqrt(n);
        //solve using recursion
        System.out.println("Minimum Numbers are Required Whose Square Sum is Equal To a "+n+": " + solveRecursively(n, options));
    }

    public static int solveRecursively(int n, int options) {
        if (n <= 0) {
            return 0;
        }
        int min = solveRecursively(n - 1 * 1, options);
        for (int i = 2; i <= options; i++) {
            if (n >= i * i) {
                min = Math.min(min, solveRecursively(n - i * i, options));
            }
        }
        return min + 1;
    }
    public static void main(String[] args) {
        int N = 12;
        solve(N);
        solveDP(N);
    }

    //DP Solution
    public static void solveDP(int n) {
        int options = (int) Math.sqrt(n);
        //solve using Dynamic programming
        System.out.println("Minimum Numbers are Required Whose Square Sum is Equal To a "+n+": " + solveUsingDP(n, options));
    }
    public static int solveUsingDP(int n, int options) {
        int MN[] = new int[n+1]; // Minimum numbers required whose sum is = n
        MN[0] = 0; // if number is 0 the answer is 0.
        int[] NUM = new int[options+1];
        // solve in bottom up manner
        for (int number = 1; number <= n; number++) {
            // reset the NUM[] for new i
            for (int j = 0; j <= options; j++) {
                NUM[j] = 0;
            }
            // now try every option one by one and fill the solution in NUM[]
            for (int j = 1; j <= options; j++) {
                // check the criteria
                if (j * j <= number) {
                    // select the number, add 1 to the solution of number-j*j
                    NUM[j] = MN[number - j * j] + 1;
                }
            }

            //Now choose the optimal solution from NUM[]
            MN[number]=-1;
            for(int j=1;j<NUM.length;j++){
                if(NUM[j]>0 && (MN[number]==-1 || MN[number]>NUM[j])){
                    MN[number]=NUM[j];
                }
            }
        }
        return MN[n];
    }
}
