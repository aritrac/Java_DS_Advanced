public class SearchTypeCounts {
    static int kLengthCount = 0;
    public static void main(String[] args) {
        String src = "AGCTAGCT";
        String substr = "AGCT";
//        int type1Count = 0;
//        int type2Count = 0;
//        int type3Count = 0;
//
//        //System.out.println("Number of occurrences = " + countStringOccurrences(src, substr));
//
//        type1Count = countStringOccurrences(src,substr);
//        //type2Count = countAllKLength(substr.toCharArray(),substr.length() - 1, src);
//        System.out.println("type1 = " + type1Count);
//        System.out.println("type2 = " + type2Count);

        printAllKLength(substr.toCharArray(),substr.length() - 1);
    }

    public static int countStringOccurrences(String src, String substr){
        int M = substr.length();
        int N = src.length();
        int count = 0;

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(substr, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (substr.charAt(j) == src.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                count++;
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && substr.charAt(j) != src.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return count;
    }

    public static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    static void printAllKLength(char[] set, int k)
    {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    // The main recursive method
// to print all possible
// strings of length k
    static void printAllKLengthRec(char[] set,
                                   String prefix,
                                   int n, int k)
    {

        // Base case: k is 0,
        // print prefix
        if (k == 0)
        {
            System.out.println(prefix);
            return;
        }

        // One by one add all characters
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i)
        {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because
            // we have added a new character
            printAllKLengthRec(set, newPrefix,
                    n, k - 1);
        }
    }
}
