package problem030;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a set of n sorted keys A[1...n], build the best binary search tree for the elements of A. Also
 * assume that each element is associated with frequency which indicates the number of times that a particular item
 * is searched in the binary search tree. That means we need to construct a binary search tree so that the total
 * search time will be reduced.
 * Description: Let us assume that the given array is A and the corresponding frequencies are in array F.
 * F[i] indicates the frequency of ith element A[i]. With this the total search time S(root) of the tree with root
 * can be defined as
 * S(root) = Summation(i = 1 to n)[(depth(root,i) + 1) x F[i]]
 * In the above expression, depth(root,i) + 1 indicates the number of comparisons for searching the ith element.
 * Since we are trying to create a binary search tree, the left subtree elements are less than root element and the
 * right subtree elements are greater than root element.If we separate the left subtree time and the right subtree time
 * then the above expression can be written as
 * S(root) = Summation(i=1 to r-1)[(depth(root,i) + 1) x F[i]] + Summation(i=1 to n)[F(i)] + Summation(i=r+1 to n)[(depth(root,i) + 1) x F[i]]
 * If we replace the left subtree and right subtree times with there corresponding recursive calls, then the expression
 * becomes
 * S(root) = S(root -> left) + S(root -> right) + Summation(i = 1 to n)[F[i]]
 */

public class OptimalBinarySearchTree {
    static int optCost(int freq[], int i, int j)
    {
        // Base cases
        if (j < i)      // no elements in this subarray
            return 0;
        if (j == i)     // one element in this subarray
            return freq[i];

        // Get sum of freq[i], freq[i+1], ... freq[j]
        int fsum = sum(freq, i, j);

        // Initialize minimum value
        int min = Integer.MAX_VALUE;

        // One by one consider all elements as root and
        // recursively find cost of the BST, compare the
        // cost with min and update min if needed
        for (int r = i; r <= j; ++r)
        {
            int cost = optCost(freq, i, r-1) +
                    optCost(freq, r+1, j);
            if (cost < min)
                min = cost;
        }

        // Return minimum value
        return min + fsum;
    }

    // The main function that calculates minimum cost of
    // a Binary Search Tree. It mainly uses optCost() to
    // find the optimal cost.
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // Here array keys[] is assumed to be sorted in
        // increasing order. If keys[] is not sorted, then
        // add code to sort keys, and rearrange freq[]
        // accordingly.
        return optCost(freq, 0, n-1);
    }

    // A utility function to get sum of array elements
    // freq[i] to freq[j]
    static int sum(int freq[], int i, int j)
    {
        int s = 0;
        for (int k = i; k <=j; k++)
            s += freq[k];
        return s;
    }

    // Driver code
    public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " +
                optimalSearchTree(keys, freq, n));
    }
}
