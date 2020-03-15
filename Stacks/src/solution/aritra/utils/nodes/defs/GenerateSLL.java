package solution.aritra.utils.nodes.defs;

import solution.aritra.linkedlists.operations.LinkedList;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Description: Generates SLL of N size
 */
public class GenerateSLL {
    private int N;

    public int getRandomInt(){
        Random rnd = new Random();
        return rnd.nextInt(20);
    }

    public LinkedList createSLL(int N){
        LinkedList newSLL = new LinkedList();
        while(N > 0){
            ListNode newNode = new ListNode(getRandomInt());
            newSLL.insertAtEnd(newNode);
            N--;
        }
        return newSLL;
    }

    public ListNode createListCopy(ListNode head){
        LinkedList newList = new LinkedList();
        while(head != null){
            ListNode newNode = new ListNode(head.getData());
            newList.insertAtEnd(newNode);
            head = head.getNext();
        }
        return newList.getHead();
    }

    public LinkedList createSortedSLL(int N){
        int[] sortedArr = generateSortedArray(N);
        LinkedList sll = new LinkedList();
        for(int num : sortedArr){
            sll.insertAtEnd(new ListNode(num));
        }
        return sll;
    }

    public LinkedList createPalindromicSLL(int N){
        int[] sortedArr = generatePalindromicArray(N);
        LinkedList sll = new LinkedList();
        for(int num : sortedArr){
            sll.insertAtEnd(new ListNode(num));
        }
        return sll;
    }

    public int[] generateSortedArray(int size){
        int[] arr = new int[size];
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            arr[i] = rnd.nextInt(100); //will generate random integers till 99
        }
        Arrays.sort(arr); //sort the array in ascending order
        return arr;
    }

    public int[] generatePalindromicArray(int size){
        int[] arr = new int[size];
        int counter = 30;
        for(int i = 0,j=size - 1; i <= size/2; i++,j--){
            arr[i] = counter;
            arr[j] = counter;
            counter++;
        }
        return arr;
    }
}
