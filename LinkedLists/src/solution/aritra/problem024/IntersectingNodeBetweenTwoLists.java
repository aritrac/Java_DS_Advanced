package solution.aritra.problem024;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Suppose there are two linked list of differing lengths, and both merge at a particular node and then
 * both have the same nodes post the merging point. We need to find where these lists merge
 * The head pointers of both the lists are known,but the intersecting node is not known. Also the number of nodes
 * in each of the lists before they intersect is unknown and may be different in each list. List1 may have n nodes
 * before it reaches the intersection point and List2 might have m nodes before it reaches the intersection points where
 * m and n may be m == n m < n or m > n. Give an algorithm to find the merging point
 */
public class IntersectingNodeBetweenTwoLists {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        //Generating the merged portion of both the lists
        LinkedList sll = listGen.createSLL(10);

        //generating 3 extra nodes to be inserted in for list1
        ListNode list1head = new ListNode(20);
        ListNode list1node1 = new ListNode(30);
        ListNode list1node2 = new ListNode(40);
        list1head.setNext(list1node1);
        list1node1.setNext(list1node2);
        list1node2.setNext(sll.getHead());

        //generating 4 extra nodes to be inserted in for list2
        ListNode list2head = new ListNode(114);
        ListNode list2node1 = new ListNode(115);
        ListNode list2node2 = new ListNode(116);
        ListNode list2node3 = new ListNode(117);
        list2head.setNext(list2node1);
        list2node1.setNext(list2node2);
        list2node2.setNext(list2node3);
        list2node3.setNext(sll.getHead());

        //printing out list1
        printList(list1head);

        //printing out list2
        printList(list2head);

        //find out the merging start node
        ListNode intersectingNode = findIntersectingNode(list1head, list2head);
        System.out.println("The merge is starting at " + intersectingNode.getData());
    }

    public static ListNode findIntersectingNode(ListNode list1head, ListNode list2head){
        int list1Length = 0;
        int list2Length = 0;
        int diff = 0;
        ListNode temp1 = list1head;
        ListNode temp2 = list2head;
        while(temp1 != null){ //calculating length of list1
            list1Length++;
            temp1 = temp1.getNext();
        }
        while(temp2 != null){ //calculating length of list2
            list2Length++;
            temp2 = temp2.getNext();
        }
        if(list1Length < list2Length){
            temp1 = list2head;
            temp2 = list1head;
            diff = list2Length - list1Length;
        }else{
            temp1 = list1head;
            temp2 = list2head;
            diff = list1Length - list2Length;
        }
        //making the temp1 go diff nodes in front as temp1 is pointing to the longer list
        for(int i = 0; i < diff; i++){
            temp1 = temp1.getNext();
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){ //we found the start node at the merge of the list
                return temp1;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return null;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}