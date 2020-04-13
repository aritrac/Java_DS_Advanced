package problem014;

/**
 * Author: Aritra Chatterjee
 * Problem: How can we improve upon the approach of problem013?
 * Description: The recursive call Cn depends only on the numbers C0 to Cn-1 and for any value of i, there are a lot of
 * recalculations. We will keep a table of previously calculated values of Ci. If the function CatalanNumber() is
 * called with parameter i, and if it has already been computed before, then we can simple avoid recalculation of the
 * same subproblem.
 */

public class CatalanNumbers {
    public static void main(String[] args) {
        System.out.println("The number of BSTs possible with n as 3 is = " + catalanNumber(n));
    }
    private static int n = 3;
    private static int[] table = new int[n+1];
    public static int catalanNumber(int n){
        if(table[n] != -1)
            return table[n];
        table[n] = 0;
        for(int i = 1; i <= n; i++){
            table[n] += catalanNumber(i-1) * catalanNumber(n-i);
        }
        return table[n];
    }
}
