package solution.aritra.problem014;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the first non-repeated character in a string. For example, the first
 * non-repeated character in the string "abzddab" is "z"
 * Description: The solution to this problem is trivial. For each character in the given string, we can scan the
 * remaining string if that character appears in it. If it does not appear then we are done with the solution and we
 * return that character. If the character appears in the remaining string, then go to the next character.
 */
public class FirstNonRepeatedChar {
    public static char firstNonRepeatedChar(char[] str, int len){
        int i,j, repeated = 0;
        for(i = 0; i < len; i++){
            repeated = 0;
            for(j = 0; j < len; j++){
                if(i != j && str[i] == str[j]){
                    repeated = 1;
                    break;
                }
            }
            if(repeated == 0){          //Found the first non repeated character
                return str[i];
            }
        }
        return ' ';
    }
}
