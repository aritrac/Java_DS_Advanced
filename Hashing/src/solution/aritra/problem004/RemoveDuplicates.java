package solution.aritra.problem004;

import solution.aritra.problem001.HashTable;
import solution.aritra.problem001.HashTableOperations;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we solve the problem discussed in problem 2 in a single pass over given array?
 * Description: We can use hashtable to check whether a character is repeating in the given string or not. If the
 * current character is not available in hash table, then insert it into hashtable and keep that character in the
 * given string also. If the current character exists in the hash table then skip that character.
 */
public class RemoveDuplicates {
    public static void removeDuplicates(char[] s){
        HashTable h = new HashTable();
        int current,last = 0;
        current = 0;
        for(;current < s.length; current++){
            if(HashTableOperations.hashSearch(h,s[current]) == 1){
                s[last++] = s[current];
                HashTableOperations.hashInsert(h,s[current]);
            }
        }
    }
}
