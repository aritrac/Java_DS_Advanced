package solution.aritra.problem016;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a string, give an algorithm for finding the first repeating letter in a string.
 * Description: The solution to this problem is somewhat similar to problem 15. The only difference is instead of
 * scanning the hash table twice we can give the answer in just one scan. This is because while inserting into the
 * hashtable we can see whether that element already exists or not. If it already exists then we just need to return
 * that character.
 */
public class FirstRepeatedCharUsingHash {
    public static char firstRepeatedCharUsingHash(char[] str, int len){
        int i;
        int[] count = new int[256];
        for(i = 0; i < len; ++i)
            count[i] = 0;
        for(i=0; i < len; ++i){
            if(count[str[i]] == 1){
                System.out.println(str[i]);
                break;
            }else
                count[str[i]]++;
        }
        if(i == len)
            System.out.println("No repeated characters");
        return 0;
    }
}
