package solution.aritra.problem013;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm to remove the specified characters from a given string which are given in another
 * string.
 * Description: Let us assume that the maximum number of different characters is 256. First we create an auxiliary
 * array initialized to 0. Scan the characters to be removed, and for each of those characters we set the value to 1.
 * This indicates that we need to remove that character.
 * After initialization, scan the input string, and for each of the characters, we check whether that character needs
 * to be deleted or not. If the flag is set then we simply skip to the next character, otherwise we keep the
 * character in the input string. Continue this process until we reach the end of the input string. All these operations
 * we can do in-place as given below
 */
public class RemoveIntersectingChars {
    public void removeChars(char[] str, char[] removeTheseChars){
        int srcInd, destInd;
        int[] aux = new int[256];
        for(srcInd =0; srcInd < 256; srcInd++)
            aux[srcInd] = 0;
        //set true for all characters to be removed
        srcInd = 0;
        while(srcInd < str.length){
            aux[removeTheseChars[srcInd]] = 1;
            srcInd++;
        }
        //copy chars unless it must be removed
        srcInd = destInd = 0;
        while(srcInd < str.length){
            if(aux[str[srcInd]] == 0)
                str[destInd++] = str[srcInd];
        }
    }
}
