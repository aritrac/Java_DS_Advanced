package solution.aritra.problem021;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a string containing n S's and n X's where S indicates a push operation and X indicates a pop
 * operation, and with the stack initially empty,formulate a rule to check whether a given string Q of operations
 * will result in an error or not.
 * Solution: The only restricted operation is pop whose prior requirement is that the stack should not be empty. So
 * while traversing the string from left to right, prior to any pop the stack shouldn't be empty.
 */

public class FindPushPopSequencePossibleOrNot {
    public static void main(String[] args) {
        String opStringValid = "SSSXXSSXSXXX";
        System.out.println("Is the operation string valid ? " + isValidSetOfOperations(opStringValid));
        String opStringInvalid = "SSSXXXXSSX";
        System.out.println("Is the operation string invalid ? " + isValidSetOfOperations(opStringInvalid));
    }

    public static boolean isValidSetOfOperations(String opString){
        int pushCount = 0;
        for(int i = 0 ; i < opString.length(); i++){
            if(opString.charAt(i) == 'S') //normal push
                pushCount++;
            else if(pushCount == 0 && opString.charAt(i) == 'X') //no element on stack and we do a pop
                return false;
            else
                pushCount--; //pop when there are already elements on the stack
        }
        return true;
    }
}
