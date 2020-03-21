package solution.aritra.problem044;

/**
 * Author: Aritra Chatterjee
 * Problem: The given array represents the parent array. That means, we need to consider the tree for that array
 * and find the depth of the tree. The tree is an N-ary tree.
 * -1   0   1   6   6   0   0   2   7 <- node index of parent(for example parent of 8th node is 7th node) of
 *                                       corresponding index i
 * 0    1   2   3   4   5   6   7   8 <- array indices represented by i
 *
 * From the above array, we should get the following tree
 *                           0
 *                        /  |  \
 *                       5   1   6
 *                           |   |
 *                           2   4
 *                           |
 *                           7
 *                           |
 *                           8
 *  Description: If we carefully observe, we just need to start at every node and keep going to its parent until we
 *  reach -1 and also keep track of the maximum depth among all nodes
 */
public class CalcHeightAndDepthFromArrayRepresentation {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,6,6,0,0,2,7};
        System.out.println("The max depth of the above array representation is " + findDepthInGenericTree(arr));
    }

    public static int findDepthInGenericTree(int[] arr){
        int maxDepth = -1, currentDepth = -1,j;
        for(int i = 0; i< arr.length; i++){
            currentDepth = 0;
            j = i;
            while(arr[j] != -1){
                currentDepth++;
                j = arr[j];
            }
            if(currentDepth > maxDepth)
                maxDepth = currentDepth;
        }
        return maxDepth;
    }
}
