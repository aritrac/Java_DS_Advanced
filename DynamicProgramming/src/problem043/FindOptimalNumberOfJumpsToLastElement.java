package problem043;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array, start from the first element and reach the last by jumping. The jump length can be at most
 * the value at the current position in the array. The optimum result is when you reach the goal in the minimum number
 * of jumps.
 * Description: Given array A = {2,3,1,1,4}. Possible ways to reach the end index are:
 *              0,2,3,4 (jump 2 to index 2, then jump 1 to index 3 and then jump 1 to index 4)
 *              0,1,4 (jump 1 to index 1 and then jump 3 to index 4)
 *              Since the second solution has only 2 jumps it is the optimum result
 * This problem is a classic example of dynamic programming. Though we can solve this by brute force, it would be
 * complex. We can use the LIS problem approach for solving this. As soon as we traverse the array, we should find
 * the minimum number of jumps for reaching that position (index) and update our result array. Once we reach the end
 * we have the optimum solution at last index in result array
 */
public class FindOptimalNumberOfJumpsToLastElement {
    public static Collection<Integer> optimalJumps(int[] A){
        int[] jumpLength = new int[A.length];
        int[] prevIndex = new int[A.length];
        for(int i = 1; i < A.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                int diff = i -j; //calculate differences in array indices
                //if jump is possible and if this is the shortest jump from the start
                if((A[j] >= diff) && (jumpLength[j] < min)){
                    min = jumpLength[j] + 1;
                    jumpLength[i] = min;
                    prevIndex[i] = j;
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        int ctr = A.length - 1;
        while(ctr > 0){
            list.add(ctr);
            ctr = prevIndex[ctr];
        }
        list.add(0);
        Collections.reverse(list);
        return Collections.unmodifiableCollection(list);
    }
}
