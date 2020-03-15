package solution.aritra.linkedlist.unrolledlinkedlist.operations;

import java.io.Serializable;
import java.util.*;

/**
 * Author: Aritra Chatterjee
 * Description: This shows the operations that can be performed on a unrolled linked list
 * In an unrolled linked list, we can find the kth element in O(root n):
 * 1.traverse the list of blocks to the one that contains the kth node,i.e. the mod(k/root n) th block. It takes
 * order of root of n since we may find it by going through no more than root of n blocks
 * 2.Find the (k mod root n) th node in the circular linked list of this block. It also takes order of root of n,
 * since there are no more than root of n nodes in a single block.
 */
public class UnrolledLinkedList<E>  extends AbstractList<E> implements List<E>, Serializable {
    //The maximum number of elements that can be stored in a single node
    private int nodeCapacity;
    //The current size of this list
    private int size = 0;
    //The first node of this list
    private ListNode firstNode;
    //The last node of this list
    private ListNode lastNode;
    //Constructs an empty list with the specified capacity
    public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException{
        if(nodeCapacity < 8){
            throw new IllegalArgumentException("nodeCapacity < 8");
        }
        this.nodeCapacity = nodeCapacity;
        firstNode = new ListNode();
        lastNode = firstNode;
    }
    public UnrolledLinkedList(){
        this(16);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    //returns true if this list contains the specified element
    public boolean contains(Object o){
        return indexOf(o) != -1;
    }

    public ListIterator<E> iterator(){
        return new ULLIterator(firstNode,0,0);
    }

    //Appends the specified element at the end of the list
    public boolean add(E e){
        insertIntoNode(lastNode,lastNode.numElements,e);
        return true;
    }
    //Removes the first occurrence of the specified element from this list
    public boolean remove(Object o){
        int index = 0;
        ListNode node = firstNode;
        if(o == null){ //remove the first occurrence of null from the list
            while(node != null){
                for(int ptr = 0; ptr < node.numElements; ptr++){
                    if(node.elements[ptr] == null){
                        removeFromNode(node,ptr);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        }else{
            while(node != null){
                for(int ptr = 0;ptr < node.numElements; ptr++){
                    if(o.equals(node.elements[ptr])){
                        removeFromNode(node,ptr);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        }
        return false;
    }
    //Removes all the elements from this list
    public void clear(){
        ListNode node = firstNode.next; //not deleting the first node
        while(node != null){
            ListNode next = node.next;
            node.next = null;
            node.previous = null;
            node.elements = null;
            node = next;
        }
        lastNode = firstNode;
        //now not deleting the first node, but emptying out its contents
        for(int ptr = 0; ptr < firstNode.numElements; ptr++){
            firstNode.elements[ptr] = null;
        }
        firstNode.numElements = 0;
        firstNode.next = null;
        size = 0;
    }

    //Returns the element at the specified position in this list
    public E get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        ListNode node;
        int p = 0;
        if(size - index > index){ //search for it in the first half starting from firstNode
            node = firstNode;
            while(p <= index - node.numElements){ //goto the block which contains the global index
                p += node.numElements;
                node = node.next;
            }
        }else{ //search for it in the second half starting from lastNode and proceeding back
            node = lastNode;
            p = size;
            while((p -= node.numElements) > index){ //goto the block which contains the global index
                node = node.previous;
            }
        }
        return (E)node.elements[index - p];//within the block subtract p from index to get the array location element
    }

    //Inserts the specified element at the specified position in this list
    //Shifts the element currently at that position (if any) and any
    //subsequent elements to the right (adds one to their indices).
    public void add(int index, E element) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        ListNode node;
        int p = 0;
        if(size - index > index){ //insertion is in the first half
            node = firstNode;
            while(p <= index - node.numElements){ //go to the block in which the insertion should occur
                p += node.numElements;
                node = node.next;
            }
        }else {
            node = lastNode;
            p = size;
            while((p -= node.numElements) > index){
                node = node.previous;
            }
        }
        insertIntoNode(node,index-p,element);
    }

    //Removes the element at the specified position in this list
    //Shifts any subsequent elements to the left (subtracts one from their indices)
    public E remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E element = null;
        ListNode node;
        int p = 0;
        if(size - index > index){ //deleting in the first half
            node = firstNode;
            while(p <= index - node.numElements){
                p += node.numElements;
                node = node.next;
            }
        }else{ //deleting in the second half
            node = lastNode;
            p=size;
            while((p -= node.numElements) > index){
                node = node.previous;
            }
        }
        element = (E)node.elements[index - p];
        removeFromNode(node,index-p);
        return element;
    }

    private static final long serialVersionUID = -674052309103045211L;
    private class ListNode{
        ListNode next;
        ListNode previous;
        int numElements = 0;
        Object[] elements;
        ListNode(){
            elements = new Object[nodeCapacity];
        }
    }

    private class ULLIterator implements ListIterator<E> {
        ListNode currentNode;
        int ptr;
        int index;
        private int expectedModCount = modCount;

        ULLIterator(ListNode node, int ptr, int index){
            this.currentNode = node;
            this.ptr = ptr;
            this.index = index;
        }
        @Override
        public boolean hasNext() {
            return (index < size - 1);
        }

        @Override
        public E next() {
            ptr++; //local index points within a node
            if(ptr >= currentNode.numElements){ //if ptr points to the next block, then go to that block
                if(currentNode.next != null){
                    currentNode = currentNode.next;
                    ptr=0;
                }else{
                    throw new NoSuchElementException();
                }
            }
            index++; //global index points across the entire list
            checkForModification();
            return (E)currentNode.elements[ptr];
        }

        @Override
        public boolean hasPrevious() {
            return (index > 0);
        }

        @Override
        public E previous() {
            ptr--;//local index
            if(ptr < 0){ //if ptr points to the previous block, then go to that block
                if(currentNode.previous != null){
                    currentNode = currentNode.previous;
                    ptr=currentNode.numElements - 1;
                }else{
                    throw new NoSuchElementException();
                }
            }
            index--;//global index
            return (E)currentNode.elements[ptr];
        }

        @Override
        public int nextIndex() {
            return (index + 1);
        }

        @Override
        public int previousIndex() {
            return (index - 1);
        }

        @Override
        public void remove() {
            checkForModification();
            removeFromNode(currentNode,ptr);
        }

        @Override
        public void set(E e) {
            checkForModification();
            currentNode.elements[ptr] = new Object();
        }

        //@Override
        public void add(E e) {
            checkForModification();
            insertIntoNode(currentNode,ptr+1,e);
        }

        private void checkForModification(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
        }
    }

    private void insertIntoNode(ListNode node, int ptr, E element){
        //if the node is full
        if(node.numElements == nodeCapacity){
            //create a new node
            ListNode newNode = new ListNode();
            //move half of the elements to the new node
            int elementsToMove = nodeCapacity / 2;
            int startIndex = nodeCapacity - elementsToMove;
            for(int i = 0; i < elementsToMove;i++){
                newNode.elements[i] = node.elements[startIndex + i]; //put half of the elements to new node
                node.elements[startIndex + i] = null; //delete the elements from the previous node which are already copied
            }
            //adjust the numElements counter in both the nodes
            node.numElements -= elementsToMove;
            newNode.numElements = elementsToMove;
            //insert the new node into the list
            newNode.next = node.next;
            newNode.previous = node;
            if(node.next != null){
                node.next.previous = newNode;
            }
            node.next = newNode;
            if(node == lastNode){ //if the new node was added at the end of the list
                lastNode = newNode;
            }
            //check whether the element should be inserted into
            //the original node or into the new node
            if(ptr > node.numElements) { //if the insertion has to happen in the newNode
                node = newNode;
                ptr -= node.numElements; //adjust ptr value to serve as a valid index within the new node
            }
        }
        for(int i = node.numElements; i > ptr; i--){ //moving all elements from the insertion index one position to the right
            node.elements[i] = node.elements[i-1];
        }
        node.elements[ptr] = element;
        node.numElements++;
        size++;
        modCount++;
    }

    private void removeFromNode(ListNode node, int ptr){
        node.numElements--;
        for(int i = ptr; i < node.numElements; i++){//moving all elements one place left towards the deletion index
            node.elements[i] = node.elements[i+1];
        }
        node.elements[node.numElements] = null; //delete the extreme right element in the array
        if(node.next != null && node.next.numElements + node.numElements <= nodeCapacity){ //finding out if after deletion the current and the right node
                                                                                           //can be merged into a single node
            mergeWithNextNode(node);
        }else if(node.previous != null && node.previous.numElements + node.numElements <= nodeCapacity){ //finding out if after deletion the current
                                                                                                         //and the left node can be merged into a single node
            mergeWithNextNode(node.previous);
        }
        size--;
        modCount++;
    }

    //this method does merge the specified node with the next node
    private void mergeWithNextNode(ListNode node){
        ListNode next = node.next;
        for(int i = 0; i < next.numElements; i++){
            node.elements[node.numElements + i] = next.elements[i]; //copying the data from the next node into the current node
            next.elements[i]=null; //deleting the same from the next node
        }
        node.numElements += next.numElements;
        //deleting the next node by rearranging the links
        if(next.next != null){
            next.next.previous = node;
        }
        node.next = next.next;
        if(next == lastNode){
            lastNode = node;
        }
    }
}