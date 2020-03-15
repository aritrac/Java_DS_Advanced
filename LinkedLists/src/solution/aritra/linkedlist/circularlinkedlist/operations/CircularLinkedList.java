package solution.aritra.linkedlist.circularlinkedlist.operations;

import solution.aritra.utils.node.defs.CLLNode;

/**
 * Author: Aritra Chatterjee
 * Description: Shows the different operations that can be performed on a circular linked list
 */
public class CircularLinkedList {
    protected CLLNode tail;
    protected int length;

    //constructs a new circular list
    public CircularLinkedList(){
        tail = null;
        length = 0;
    }

    //Adds data to beginning of list
    public void add(int data){
        addToHead(data);
    }

    //Adds element to head of list
    public void addToHead(int data){
        CLLNode temp = new CLLNode(data);
        if(tail == null){ //list is empty
            tail = temp;
            tail.setNext(tail); //if only one node, make it circular
        }else{ //elements exists in the list
            temp.setNext(tail.getNext()); //tail.getNext() points to the beginning of the list
            tail.setNext(temp);
        }
        length++;
    }

    //Adds element to tail of list
    public void addToTail(int data){
        //new entry
        addToHead(data);
        tail = tail.getNext(); //since the list is circular, make the head node as the tail now
    }

    //returns data at head of list
    public int peek(){
        return tail.getNext().getData();
    }

    //returns data at tail of list
    public int tailPeek(){
        return tail.getData();
    }

    //returns and removes data from head of list
    public int removeFromHead(){
        CLLNode temp = tail.getNext(); //i.e. the head of the list
        if(tail == tail.getNext()){//only one node in the list
            tail = null;
        }else{
            tail.setNext(temp.getNext());
            temp.setNext(null); //temp is free or deleted
        }
        length--;
        return temp.getData();
    }

    //returns and removes data from tail of list
    public int removeFromTail(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        CLLNode listIter = tail;
        while(listIter.getNext() != tail){
            listIter = listIter.getNext();
        }
        //listIter now points to second to last data
        CLLNode temp = tail;
        if(listIter == tail){ //if there is only one node
            tail = null;
        }else{
            listIter.setNext(temp.getNext());
            tail = listIter;
        }
        length--;
        return temp.getData();
    }

    //returns true if list contains data, else false
    public boolean contains(int data){
        if(tail == null) //list is empty
            return false;
        CLLNode listIter = tail.getNext();
        while(listIter != tail && (!(listIter.getData() == data))){
            listIter = listIter.getNext();
        }
        return listIter.getData() == data;
    }

    //removes and returns element equal to data or null
    public int remove(int data){
        if(tail == null) //list is empty
            return Integer.MIN_VALUE;
        CLLNode listIter = tail.getNext();
        CLLNode previous = tail; //points to the node previous to listIter
        for(int i = 0; i < length && (!(listIter.getData() == data)); i++){
            previous = listIter;
            listIter = listIter.getNext();
        }
        if(listIter.getData() == data){
            if(tail == tail.getNext()){//only a single node
                tail = null;
            }else{
                if(listIter == tail){ //at last node or tail node
                    tail = previous;
                }
                previous.setNext(listIter.getNext());
            }
            //free the listIter data
            listIter.setNext(null); //disconnect the node
            length--;
            return  listIter.getData();
        }else{
            return Integer.MIN_VALUE;
        }
    }

    //return the current length of the CLL
    public int length(){
        return length;
    }

    //returns true if no elements in list
    public boolean isEmpty(){
        return tail == null;
    }

    //remove everything from the CLL
    public void clear(){
        length = 0;
        tail = null;
    }

    //returns a string representation of this collection, in the form: ["str1","str1",...]
    public String toString(){
        String result = "[";
        if(tail == null)
            return result + "]";
        result = result + tail.getData();
        CLLNode temp = tail.getNext();
        while(temp != tail){
            result = result + ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}
