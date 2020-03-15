package solution.aritra.problem014;

public class Tester {
    public static void main(String[] args) {
        TwoStacksUsingOneArray ts1 = new TwoStacksUsingOneArray(20);
        //pushing 11 elements into stack 1
        for(int i = 0; i < 11; i++){
            System.out.println("Pushing " + i + " into stack 1");
            ts1.push(1,i);
        }
        //pushing 11 elements into stack 2
        for(int i = 0; i < 11; i++){
            System.out.println("Pushing " + i + " into stack 2");
            ts1.push(2,i);
        }

        //popping 12 elements from stack 1
        for(int i = 0; i < 12; i++){
            System.out.println("Popping " + ts1.pop(1) + " from stack 1");
        }

        //popping 12 elements from stack 2
        for(int i = 0; i < 10; i++){
            System.out.println("Popping " + ts1.pop(2) + " from stack 2");
        }
    }
}
