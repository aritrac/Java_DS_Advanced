package solution.aritra.problem013;

/**
 * Author: Aritra Chatterjee
 * Problem: We are given a 2D array of characters and a character pattern. Give an algorithm to find if the pattern
 * is present in the 2D array. The pattern can be in any order (all 8 neighbors to be considered) but we cant use
 * the same character twice while matching. Return 1 if match is found, 0 if not.
 * Description:First we match the first element, and when it is matched we match the second element in the 8
 * neighbors of the first match. We do this process recursively, and when the last character of the input pattern
 * matches, return true. During the above process, take care not to use any cell in the2D array twice. For this
 * purpose, you mark every visited cell with some sign. If matching fails at some point, start matching from the
 * beginning(of the pattern) in the remaining cells. When returning you unmark the visited cells.
 */
public class FindPatternIn2DMatrix {
    static private int MAX = 100;

    public static void main(String[] args) {
        char[][] mat = {
                {'A', 'C', 'P', 'R', 'C', 'X'},
                {'X' ,'S' ,'O' ,'P' ,'C', 'X'},
                {'V', 'O', 'V', 'N', 'I', 'X'},
                {'W', 'G', 'F', 'M', 'N', 'X'},
                {'Q', 'A', 'T', 'I', 'T', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        char[] pat = {'M','I','C','R','O','S','O','F','T'};
        System.out.println("is it a match? " + findMatchWrapper(mat,pat,pat.length,6,6));
    }
    public static boolean findMatchWrapper(char[][] mat, char[] pat, int patLen, int nrow, int ncol){
        if(pat.length > nrow*ncol)
            return false;
        int[][] used = new int[MAX][MAX];
        return findMatch(mat,pat,patLen,used,0,0,nrow,ncol,0);
    }

    //level: index till which pattern is matched. x,y: current position in 2D array
    static boolean findMatch(char[][] mat, char[] pat, int patLen, int[][] used,int x,int y,int nrow,int ncol,int level){
        if(level == patLen) //pattern matched
            return true;
        if(nrow == x && ncol == y)
            return false;
        if((x >= 0 && y >= 0 && x < 6 && y < 6) && mat[x][y] != pat[level] && level == 0){ //matching first character
            if(x < nrow - 1)
                return findMatch(mat,pat,patLen,used,x+1,y,nrow,ncol,level); //next element in same row
            else if(y < ncol - 1)
                return findMatch(mat,pat,patLen,used,0,y+1,nrow,ncol,level); //next element of the same col
            else
                return false;
        }else if((x >= 0 && y >= 0 && x < 6 && y < 6) && mat[x][y] == pat[level]){
            boolean res;
            used[x][y] = 1; //marking this cell as used
            //finding subpattern in 8 neighbors
            res = (x > 0 ? findMatch(mat,pat,patLen,used,x-1,y,nrow,ncol,level+1):false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x+1,y,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x,y-1,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x,y+1,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x+1,y+1,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x+1,y-1,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x-1,y+1,nrow,ncol,level+1) : false) ||
                    (res = x < (nrow - 1)? findMatch(mat,pat,patLen,used,x-1,y-1,nrow,ncol,level+1) : false);
            used[x][y] = 0; //marking this cell as unused
            return res;
        }else return false;
    }
}
