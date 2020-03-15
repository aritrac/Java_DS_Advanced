package solution.aritra.problem044;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: N people have decided to elect a leader by arranging themselves in a circle and eliminating every Mth
 * person around the circle, closing ranks as each person drops out. Find which person will be the last man remaining.
 */
public class GetJosephusPosition {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        int MAX_SIZE = 10;
        LinkedList cll = listGen.createSLL(MAX_SIZE);
        //the original list of people
        System.out.println(cll);
        //move to the last of the list
        ListNode temp = cll.getHead();
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(cll.getHead()); //making the list circular
        int N = MAX_SIZE; //no of people
        int M = 7; //count of steps to go around the loop eliminating people
        temp = cll.getHead(); //reassigning head node to temp
        //Now repeating the elimination process N times for N people
        for(int i = N; i > 0; i--){
            //now taking M steps in the circular list to identify member to be eliminated
            for(int j = 0; j < M; j++){
                temp = temp.getNext();
            }
            //now delete the node temp is pointing to to mimic that the member is being deleted
            temp.setNext(temp.getNext().getNext());
        }
        System.out.println("The last man standing(Josephus Position) is " + temp.getData());
    }
}
