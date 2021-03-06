package solution.aritra.util;

/**
 * Author: Aritra Chatterjee
 * Description: This code will show the various operations we can do on a linked list
 */
public class LinkedList {
    //This class has a default constructor
    public LinkedList(){
        length = 0;
    }
    //This is the only field of the class. It holds the head of the list
    ListNode head;

    //Length of the linked list
    private int length = 0;

    //Return the first node in the list
    public synchronized ListNode getHead(){
        return head;
    }

    //Sets the head node in the list
    public synchronized void setHead(ListNode head){
        this.head = head;
    }

    //Insert a node at the beginning of the list
    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    //Insert a node at the end of the list
    public synchronized void insertAtEnd(ListNode node){
        if(head == null){
            head = node;
        }else{
            ListNode p,q;
            for(p = head;(q = p.getNext()) != null; p = q); //p and q both point at the last node at the end
            p.setNext(node);
        }
        length++;
    }

    //Add a new value to the list at a given position
    //All values at that position till the end move over to make room(this is an inherent property of linked lists)
    public void insert(int data, int position){
        //fix the position
        if(position < 0)
            position = 0;
        if(position > length)
            position = length;
        //if the list is empty, make it to be the only element
        if(head == null)
            head = new ListNode(data);
        //if adding at the front of the list
        else if(position == 0){
            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head = temp;
        }
        //else find the correct position and insert
        else{
            ListNode temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        //the list is now one value longer
        length++;
    }

    //Remove and return the node at the head of the list
    public synchronized ListNode removeFromBegin(){
        ListNode node = head;
        if(node != null){
            head = node.getNext();
            node.setNext(null);
            length--;
        }
        return node;
    }

    //Remove and return the node at the end of the list
    public synchronized ListNode removeFromEnd(){
        if(head == null)
            return null;
        ListNode p = head, q = null, next = head.getNext();
        if(next == null){
            head = null;
            length--;
            return p;
        }
        //q is previous, p is next
        while((next = p.getNext()) != null){
            q = p;
            p = next;
        }
        q.setNext(null);
        length--;
        return p;
    }

    //Remove a node matching the specified node from the list
    //Use equals() instead of == to test for a matched node.
    public synchronized void removeMatched(ListNode node){
        if(head == null)
            return;
        if(node.equals(head)){
            head = head.getNext();
            length--;
            return;
        }
        //p is previous, q is next
        ListNode p = head, q = null;
        while((q = p.getNext())!= null){
            if(node.equals(q)){
                p.setNext(q.getNext());
                length--;
                return;
            }
            p = q;
        }
    }

    //Remove the value at a given position
    //If the position is less than 0, remove the value at position 0
    //If the position is greater than 0, remove the value at the last position
    public void remove(int position){
        //fix position
        if(position < 0){
            position = 0;
        }
        if(position >= length){
            position = length;
        }
        //if nothing is there in the list, do nothing
        if(head == null)
            return;
        //if removing the head element
        if(position == 0){
            head = head.getNext();
        }
        //else advance to the correct position and remove
        else {
            ListNode temp = head;
            for(int i = 1; i <= position; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        //reduce the length of the list
        length--;
    }

    //Return a string representation of this collection, in the form ["str1","str2",...]
    public String toString(){
        String result = "[";
        if(head == null){
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while(temp != null){
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    //Return the current length of the list
    public int length(){
        return length;
    }

    //Find the position of the first value that is equal to the given value
    //The equals method is used to determine equality
    public int getPosition(int data){
        //go looking for the data
        ListNode temp = head;
        int pos = 0;
        while(temp != null){
            if(temp.getData() == data){
                //return the position if found
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        //else return some large value
        return Integer.MIN_VALUE;
    }

    //Remove everything from the list
    public void clearList(){
        head = null;
        length = 0;
    }
}
