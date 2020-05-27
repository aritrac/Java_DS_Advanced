package solution.aritra.problem015;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we improve the time complexity of problem 14?
 * Description: By using hash tables we can reduce the time complexity. Create a hash table by reading all the
 * characters in the input string and keeping count of the number of times each character appears. After creating the
 * hash table, we can read the hash table entries to see which element has a count equal to 1. This approach takes
 * O(n) space but reduces the time complexity also to O(n)
 */
public class RemoveChars {
    public static char firstNonRepeatedCharUsingHash(char[] str, int len){
        int i;
        int[] count = new int[256];
        for(i = 0; i < len; ++i)
            count[i]=0;
        for(i=0;i<len;++i)
            count[str[i]]++;
        for(i = 0; i<len;++i){
            if(count[str[i]] == 1){
                System.out.println(str[i]);
                break;
            }
        }
        if(i == len)
            System.out.println("No non repeated characters");
        return 0;
    }
}
