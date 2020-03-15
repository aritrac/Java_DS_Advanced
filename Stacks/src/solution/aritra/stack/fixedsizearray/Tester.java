package solution.aritra.stack.fixedsizearray;

/**
 * Author: Aritra Chatterjee
 * Description: This class tests the functionalities offered by the FixedSizeArrayStack class
 */
public class Tester {
    public static void main(String[] args) {
        FixedSizeArrayStack stack = new FixedSizeArrayStack();
        //Default size of this stack is 10, hence will try inserting 12 elements to check the overflow feature
        for(int i = 0; i < 12; i++){
            try {
                stack.push(i + 3);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        //printing out the stack
        System.out.println(stack);

        //trying to get the size of stack
        System.out.println("size of stack = " + stack.size());

        //trying to pop 12 times even though the stack contains 10 elements to check the underflow feature
        for(int i = 0; i < 12; i++){
            try{
                System.out.print(" " + stack.pop());
            }catch(Exception ex){
                System.out.println("\n" + ex.getMessage());
            }
        }

        //printing out the stack after all elements were deleted
        System.out.println(stack);
    }
}
