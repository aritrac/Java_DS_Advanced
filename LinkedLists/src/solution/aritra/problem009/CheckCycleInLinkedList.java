package solution.aritra.problem009;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Description: We need to check for a cycle in the linked list using next pointer sorting algorithm.
 * We will put all the next pointer values in an array and then sort. If there is a cycle, one of the
 * pointer values would be repeated, hence we can conclude that a cycle exists
 */
public class CheckCycleInLinkedList {
    public static void main(String[] args) {
        GenerateSLL newSLLGen = new GenerateSLL();
        LinkedList sll = newSLLGen.createSLL(10);
        System.out.println(sll);

        //generate start of cycle position
        int startOfCycleIndex = new Random().nextInt(10);

        //navigate to start of cycle node
        int index = 1;
        ListNode startOfCycleNode = sll.getHead();
        while(index < startOfCycleIndex){
            startOfCycleNode = startOfCycleNode.getNext();
            index++;
        }

        System.out.println("startOfCycleIndex = " + startOfCycleIndex);
        System.out.println("startOfCycleNode = " + startOfCycleNode.getData());
        System.out.println("Before cycle creation: isCyclePresent? " + isCyclePresent(sll));

        //get the lastnode in the SLL
        ListNode temp = sll.getHead();
        while(temp.getNext() != null)
            temp = temp.getNext();

        //create cycle
        temp.setNext(startOfCycleNode);

        //now check if cycle is present using a hash table
        System.out.println("After cycle creation: isCyclePresent? " + isCyclePresent(sll));
    }

    public static boolean isCyclePresent(LinkedList sll){
        ListNode temp = sll.getHead();
        //Using hashmap instead of hashtable, as we will expect a null key to be inserted if cycle is not present,
        //which hashtable being synchronized will not permit
        Map<ListNode,Boolean> presenceTable = new HashMap<ListNode,Boolean>();
        while (temp != null){
            if(presenceTable.containsKey(temp.getNext())){
                //cycle detected
                return true;
            }else{
                presenceTable.put(temp.getNext(),true);
            }
            temp = temp.getNext();
        }
        return false;
    }
}
