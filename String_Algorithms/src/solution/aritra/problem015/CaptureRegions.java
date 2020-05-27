package solution.aritra.problem015;

import java.util.ArrayDeque;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. A region is captured by
 * flipping  all Os into Xs in that surrounded region.
 * Description: We use backtracking to identify the elements not surrounded by 'X' and we mark those with a temporal
 * symbol '$'.The elements not surrounded by 'X' means there exists a path of elements 'O' to the border. So we start
 * the backtracking algorithm with the borders. The last thing is replacing the temporal element by 'O' and the
 * rest of the elements to 'X'
 */
public class CaptureRegions {
    final static char TEMPORARY_MARKED = '$';
    final static char TO_CAPTURE = 'O';
    final static char CAPTURED = 'X';

    public void solve(char[][] board){
        if(board.length == 0)
            return;
        int numberRows = board.length;
        int numberCols = board[0].length;
        //Doing marking for top and bottom row
        for(int col = 0; col < numberCols; col++){
            mark(board,0,col);
            mark(board,numberRows-1,col);
        }
        //Doing marking for left and right col
        for(int row = 0; row < numberRows; row++){
            mark(board,row,0);
            mark(board,row,numberCols-1);
        }
        for(int row = 0; row < numberRows; row++){
            for(int col = 0; col < numberCols; col++){
                board[row][col] = board[row][col] == TEMPORARY_MARKED ? TO_CAPTURE: CAPTURED;
            }
        }
    }

    public void mark(char[][] board, int row, int col){
        int position = row * board[0].length + col;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(position);
        while(!stack.isEmpty()){
            position = stack.pop();
            row = position / board[0].length;
            col = position % board[0].length;
            if(board[row][col] != TO_CAPTURE)
                continue;
            board[row][col] = TEMPORARY_MARKED;
            if(row > 0)
                stack.push((row - 1) * board[0].length + col);
            if(col > 0)
                stack.push(row * board[0].length + col - 1);
            if(row < board.length - 1)
                stack.push((row + 1) * board[0].length + col);
            if(col < board[0].length - 1)
                stack.push(row * board[0].length + col + 1);
        }
    }
}
