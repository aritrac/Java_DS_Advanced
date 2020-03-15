package solution.aritra.problem008;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Description: Find if a cycle exists in the list using a HashTable
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
        Map<ListNode,Boolean> presenceTable = new Hashtable<ListNode, Boolean>();
        while (temp != null){
            if(presenceTable.containsKey(temp)){
                //cycle detected
                return true;
            }else{
                presenceTable.put(temp,true);
            }
            temp = temp.getNext();
        }
        return false;
    }
}
