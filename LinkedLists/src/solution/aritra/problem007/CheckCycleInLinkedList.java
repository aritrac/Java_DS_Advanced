package solution.aritra.problem007;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Problem: Check whether the given linked list is either NULL terminated or ends in a cycle (brute force or inefficient approach)
 */
public class CheckCycleInLinkedList {
    public static void main(String[] args) {
        GenerateSLL newSLL = new GenerateSLL(); //auto generates a linked list
        LinkedList newList = newSLL.createSLL(10); //auto generating the new list here
        System.out.println(newList);; //printing the auto generated linked list
        //generating a cycle in the above list which starts at any position in the list less than the length of the list
        int startCyclePos = new Random().nextInt(newList.length());
        //get the last node in the list
        ListNode temp = newList.getHead(); //temp contains the address of the last node
        while(temp.getNext() != null)
            temp = temp.getNext();

        //Now goto the startCyclePos node and make the last node point to the node at startCyclePos
        ListNode startCycleNode = newList.getHead();
        int index = 1;
        while(index < startCyclePos){
            startCycleNode = startCycleNode.getNext();
            index++;
        }
        System.out.println("startCyclePos = " + startCyclePos);
        System.out.println("startCycleNode contains " + startCycleNode.getData());

        //Make a cycle
        temp.setNext(startCycleNode);

        //Make sure a cycle exists which can be found if we try to traverse the list but
        //we dont get the end of the list and the loop goes on for more than the predefined size of the list

        temp = newList.getHead();
        index = 0;
        //check if index exceeds the length of the list, then we terminate as we know a loop is present
        while(temp != null && index < newList.length() + 5){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
            index++;
        }
        //from the output it is clear that it is going around in circles
    }
}
