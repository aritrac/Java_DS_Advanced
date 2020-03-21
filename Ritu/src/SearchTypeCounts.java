import java.util.Scanner;

public class SearchTypeCounts {

    private static int type1Count = 0;
    private static int type2Count = 0;
    private static int type3Count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        if(T > 250)
            System.exit(0);
        while(T-- > 0){
            String S = in.next();
            String L = in.next();
            if(S.length() < 2 || S.length() > 100)
                System.exit(0);
            if(L.length() < 2 || L.length() > 100)
                System.exit(0);
            type1Count = type2Count = type3Count = 0;
            //Generating count of type1
            type1Count = countStringOccurrences(L,S);
            //Generating count of type2
            generateKLengthStrings(S.toCharArray(),S.length() - 1, L);
            //Generating count of type3
            insertAdditionalCharAndPermutate(S.toCharArray(),L);
            System.out.println(type1Count + " " + type2Count + " " + type3Count);
        }
    }

    //################################################################################################################

    public static int countStringOccurrences(String src, String substr){
        int M = substr.length();
        int N = src.length();
        int count = 0;

        int array[] = new int[M];
        int j = 0;

        computeArray(substr, M, array);

        int i = 0;
        while (i < N) {
            if (substr.charAt(j) == src.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                count++;
                j = array[j - 1];
            }

            else if (i < N && substr.charAt(j) != src.charAt(i)) {
                if (j != 0)
                    j = array[j - 1];
                else
                    i = i + 1;
            }
        }
        return count;
    }

    public static void computeArray(String pat, int M, int array[])
    {
        int len = 0;
        int i = 1;
        array[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                array[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = array[len - 1];
                }
                else
                {
                    array[i] = len;
                    i++;
                }
            }
        }
    }

    //################################################################################################################

    static void generateKLengthStrings(char[] set, int k, String src)
    {
        int n = set.length;
        generateKLengthStringsRecursive(set, "", n, k, src);
    }

    static void generateKLengthStringsRecursive(char[] set,String prefix,int n, int k, String src)
    {

        if (k == 0)
        {
            type2Count = type2Count + countStringOccurrences(src,prefix);
            //System.out.println(count);
            return;
        }

        for (int i = 0; i < n; ++i)
        {
            String newPrefix = prefix + set[i];
            generateKLengthStringsRecursive(set, newPrefix,
                    n, k - 1, src);
        }
    }

    //################################################################################################################
    public static void insertAdditionalCharAndPermutate(char[] substr, String src){
        char[] baseChars = {'A','G','C','T'};
        char[] newChars = new char[substr.length + 1];
        for(int i = 0; i < substr.length; i++){
            newChars[i] = substr[i];
        }
        for(int i =0; i < baseChars.length; i++){
            newChars[substr.length] = baseChars[i];
            genPermutations(newChars,0,newChars.length, src);
        }
    }

    static boolean isSwappable(char str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }

    static void genPermutations(char str[], int index, int n, String src) {
        if (index >= n) {
            type3Count += countStringOccurrences(src,str.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            boolean check = isSwappable(str, index, i);
            if (check) {
                swap(str, index, i);
                genPermutations(str, index + 1, n, src);
                swap(str, index, i);
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

    //################################################################################################################
}
