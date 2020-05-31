package solution.aritra.problem008;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for reversing words in a sentence
 * Description: If the input string is say "I am a good programmer" then the output should be
 * "programmer good a am I".
 * We will start from the beginning and keep reversing the words. The below implementation assumes that space is
 * the delimiter for words in a given sentence
 */
public class ReverseWordsInASentence {

    public static void main(String[] args) {
        String s = "I am a good programmer";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s){
        if(s == null || s.length() == 0)
            return "";
        int curr = 0, start = 0;
        s=reverse(s);
        StringBuilder sb = new StringBuilder();
        while(curr < s.length()){
            //start = curr
            if(s.charAt(curr) != ' '){
                //word
                curr++;
            }else{
                if(start != curr){
                    sb.append(reverse(s.substring(start,curr)) + " ");
                    start = curr;
                }else {
                    //space
                    curr++;
                    start++;
                }
            }
        }
        if(start != curr){
            sb.append(reverse(s.substring(start,curr)) + " ");
        }
        return sb.length() != 0 ? sb.toString().substring(0,sb.length() - 1): "";
    }

    public static String reverse(String s){
        if(s == null || s.length() == 0)
            return "";
        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < length/2; i++){
            char c = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = c;
        }
        return new String(chars);
    }
}
