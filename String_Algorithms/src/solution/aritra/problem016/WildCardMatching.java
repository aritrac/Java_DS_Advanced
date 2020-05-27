package solution.aritra.problem016;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement wildcard pattern matching with support for '?' and '*'. Character '?' matches any single
 * character and character '*' matches any sequence of characters (including the empty sequence)
 * Description:
 * wildCardMatch("aa","a")      -> false
 * wildCardMatch("aa","aa")     -> true
 * wildCardMatch("aaa","aa")    -> false
 * wildCardMatch("aa","*")      -> true
 * wildCardMatch("aa","a*")     -> true
 * wildCardMatch("ab","?*")     -> true
 * wildCardMatch("aab","c*a*b") -> false
 */
public class WildCardMatching {
    public static void main(String[] args) {
        System.out.println(wildCardMatch("aa","a"));
        System.out.println(wildCardMatch("aa","aa"));
        System.out.println(wildCardMatch("aaa","aa"));
        System.out.println(wildCardMatch("aa","*"));
        System.out.println(wildCardMatch("aa","a*"));
        System.out.println(wildCardMatch("ab","?*"));
        System.out.println(wildCardMatch("aab","c*a*b"));

    }
    public static boolean wildCardMatch(String text, String pattern){
        int lenText = text.length();
        int lenPattern = pattern.length();
        if(lenText == 0 && lenPattern == 0)
            return true;
        int i = 0, j = 0;
        //save the last matched index
        int startText = -1;
        int startPattern = -1;
        while(i < lenText){
            if(j < lenPattern && ((text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'))){
                i++;
                j++;
            }else if(j < lenPattern && pattern.charAt(j) == '*'){
                while(j < lenPattern && pattern.charAt(j) == '*')
                    j++;
                if(j == lenPattern)
                    return true;
                startPattern = j;
                startText = i;
            }else if((j >= lenPattern || text.charAt(i) != pattern.charAt(j)) && startPattern > -1){
                startText++;
                j = startPattern;
                i = startText;
            }else{
                return false;
            }
        }
        while(j < lenPattern){
            if(pattern.charAt(j) != '*')
                return false;
            j++;
        }
        return true;
    }
}
