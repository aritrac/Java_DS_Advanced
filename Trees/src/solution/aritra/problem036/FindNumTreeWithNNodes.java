package solution.aritra.problem036;

/**
 * Author: Aritra Chatterjee
 * Problem: How many different binary trees are possible with n nodes?
 * Description: The number of BSTs can be calculated using the catalan number,which can be expressed using the
 * folowing formula
 * f(n) = f(0)f(n-1) + f(1)f(n-2) + .......... + f(n-1)f(0)
 * The code below does the same
 */
public class FindNumTreeWithNNodes {
    public static void main(String[] args) {
        System.out.println("How many trees are possible with 3 nodes? " + numOfBinaryTrees(3));
    }

    public static int numOfBinaryTrees(int numOfNodes){
        int[] count = new int[numOfNodes + 1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= numOfNodes; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i-j-1];
            }
        }
        return count[numOfNodes];
    }
}
