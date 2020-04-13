package problem013;

/**
 * Author: Aritra Chatterjee
 * Problem: How many BSTs are possible with n vertices?
 * Description: If we select ith element as root then we get i-1 elements on left subtree and n-i elements on the
 * right sub tree. Since Cn is the Catalan number for n elements, Ci-1 represents the Catalan number for left subtree
 * elements (i-1) and Cn-i represents the Catalan number for right subtree elements. The two subtrees are
 * independent of each other, so we simply multiply the two numbers. That means, the Catalan number for a fixed value
 * i is Ci-1 X Cn-i, Since there are n nodes, for i we will get n choices. The total Catalan number with n nodes can
 * be given as
 * Cn = Summation of i = 0 to n [Ci-1 X Cn-i]
 */
public class CatalanNumbers {
    public static void main(String[] args) {
        System.out.println("No of BSTs possible with 3 nodes = " + catalanNumber(3));
    }

    public static int catalanNumber(int n){
        if(n == 0)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++)
            count += catalanNumber(i-1) * catalanNumber(n-i);
        return count;
    }
}
