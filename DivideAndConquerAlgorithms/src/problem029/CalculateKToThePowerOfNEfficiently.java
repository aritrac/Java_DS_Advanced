package problem029;

/**
 * Author: Aritra Chatterjee
 * Problem: Calculate k^n efficiently
 * Description: the naive algorithm to compute k^n is: start with 1 and multiply by k until reaching k^n. For this
 * approach, there are n-1 multiplications and each takes constant time giving O(n) algorithm.
 * But there is a faster way to coompute k^n. For example,
 * 9^24 = (9^12)^2 = (9^6)^2^2 = (9^3)^2^2^2 = (9^2x9)^2^2^2
 * Note that taking square of a number needs only one multiplication, in this way to compute 9^24 we need only 5
 * multiplications instead of 23.
 */
public class CalculateKToThePowerOfNEfficiently {
    public static double exponentiation(double x, int n){
        if(n == 0)
            return 1.0;
        double half = exponentiation(x, n/2);
        if(n %2 == 0)
            return half * half;
        else if( n > 0)
            return half * half * x;
        else return half * half / x;
    }
}
