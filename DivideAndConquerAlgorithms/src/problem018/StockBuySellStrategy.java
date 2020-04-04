package problem018;

/**
 * Author: Aritra Chatterjee
 * Problem: The problem is to find the day on which we can buy the stock and the day on which we can sell the stock
 * so that we can make maximum profit.
 * Description: Let us assume that the input is an array with stock prices. Let us say the given array is
 * A[1]...A[n].From this array we have to find two days[one for buy and one for sell] in such a way that we can make
 * maximum profit. Also, another point to make is that the buy date should be before sale date. One simple approach
 * is to look at all possible buy and sell options as below
 */
public class StockBuySellStrategy {
    public static void stockStrategy(int[] A,int buyDateIndex, int sellDateIndex){
        int profit = 0;
        buyDateIndex =0; sellDateIndex = 0;
        for(int i = 1; i < A.length; i++){ //indicates buy date
            //indicates sell date
            for(int j = i; j < A.length; j++){
                if(A[j] - A[i] > profit){
                    profit = A[j] - A[i];
                    buyDateIndex = i;
                    sellDateIndex = j;
                }
            }
        }
    }
}
