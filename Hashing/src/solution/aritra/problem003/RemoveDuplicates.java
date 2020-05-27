package solution.aritra.problem003;

import java.util.Arrays;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we find any other idea to solve problem 2 in better time than O(n^2)? Observe that the order
 * of the characters in the solution does not matter.
 * Description: Use sorting to bring the repeated characters together. Finally scan through the array to remove
 * duplicates in consecutive positions
 */
public class RemoveDuplicates {
    //With char[] as input
    public static void removeDuplicates(char[] str, int len){
        if(str == null)
            return;
        if(len < 2)
            return;
        int tail = 1;
        int i,j;
        for(i = 1; i < len; ++i){
            for(j = 0; j < tail; ++j){
                if(str[i] == str[j])
                    break;
            }
            if(j == tail){
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }
    //With String as input
    public static String removeDuplicates(String s){
        StringBuilder noDupes = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            String si = s.substring(i,i+1);
            if(noDupes.indexOf(si) == -1){
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }
    //Sorting approach
    public static String removeDuplicates2(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
        return sorted;
    }
}
