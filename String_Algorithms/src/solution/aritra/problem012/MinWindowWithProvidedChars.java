package solution.aritra.problem012;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a set of chars and a input string, find the minimum window in str which will contain all the
 * characters in chars in complexity O(n). For example, INPUT = ABBACBAA and CHARS = AAB has the minimum window
 * BAA
 * Description: This approach is based on the sliding window approach. In this approach we start from the beginning
 * of the array and move to the right. As soon as we have a window which has all the required elements, try sliding
 * the window as far right as possible with all the required elements. If the current window length is less than
 * the minimum window length found so far, update the minimum length.
 * Algo:
 * The input is the given array and chars is the array of characters that need to be found
 * 1.Make an integer array shouldfind[] of length 256. The ith element of this array will have the count of how
 * many times we need to find the element of ASCII value i.
 * 2.Make another array hasFound of 256 elements, which will have the count of the required elements found until now
 * 3.Count <= 0
 * 4.While input[i]
 *  a.If input[i] element is not to be found -> continue
 *  b.If input[i] element is required => increase count by 1
 *  c.If count is length of chars[] array, slide the window as much right as possible
 *  d.If current window length is less than min length found until now, update min length
 */
public class MinWindowWithProvidedChars {
    public static void main(String[] args) {
        String input = "ABBACBAA";
        String chars = "AAB";
        System.out.println("Min window = " + minWindow(input,chars));
    }
    public static String minWindow(String input, String chars){
        int inputLen = input.length();
        int charsLen = chars.length();

        //initialize needToFind array
        int[] needToFind = new int[256];
        for(int i = 0; i < charsLen; i++){
            needToFind[chars.charAt(i)]++;
        }
        int[] hasFound = new int[256];
        int minWinLen = Integer.MAX_VALUE;
        int minWinBegin = 0;
        int minWinEnd = 0;
        int count = 0;
        for(int begin = 0, end = 0; end < inputLen; end++){
            //skip characters not in chars
            if(needToFind[input.charAt(end)] == 0)
                continue;
            hasFound[input.charAt(end)]++;
            if(hasFound[input.charAt(end)] <= needToFind[input.charAt(end)])
                count++;
            //if window constraint is satisfied
            if(count == charsLen){
                //advance begin index as far as possible, stop when advancing breaks window constraint
                while(needToFind[input.charAt(begin)] == 0 || hasFound[input.charAt(begin)] > needToFind[input.charAt(begin)]){
                    if(hasFound[input.charAt(begin)] > needToFind[input.charAt(begin)])
                        hasFound[input.charAt(begin)]--;
                    begin++;
                }
                //update minWindow if a minimum length is satisfied
                int windowLen = end - begin + 1;
                if(windowLen < minWinLen){
                    minWinBegin = begin;
                    minWinEnd = end;
                    minWinLen = windowLen;
                }
            }
        }
        return (count == charsLen)? input.substring(minWinBegin, minWinEnd + 1):"";
    }
}
