package solution.aritra.problem001;

/**
 * Author: Aritra Chatterjee
 */
public class HashTableOperations {
    public final static int LOADFACTOR = 20;
    public static HashTable createHashTable(int size){
        HashTable h = new HashTable();
        //count is set to zero by default
        h.setTSize(size/LOADFACTOR);
        for(int i = 0; i < h.getTSize(); i++){
            h.getTable()[i].setStartNode(null);
        }
        return h;
    }

    public static int hashSearch(HashTable h, int data){
        ListNode temp;
        temp = h.getTable()[hash(data,h.getTSize())].getStartNode();
        while(temp != null){
            if(temp.getData() == data)
                return 1;
            temp = temp.getNext();
        }
        return 0;
    }

    public static void hashInsert(HashTable h,int data){
        int index;
        ListNode temp, newNode;
        if(hashSearch(h,data) == 0)
            return;
        index = hash(data,h.getTSize());
        temp = h.getTable()[index].getNext();
        newNode = new ListNode();
        if(newNode == null){
            System.out.println("Memory Error");
            return;
        }
        newNode.setKey(index);
        newNode.setData(data);
        newNode.setNext(h.getTable()[index].getNext());
        h.getTable()[index].setNext(newNode);
        h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount() + 1);
        h.setCount(h.getCount() + 1);
        if(h.getCount() / h.getTSize() > LOADFACTOR)
            rehash(h);
        return;
    }

    public static boolean hashDelete(HashTable h, int data){
        ListNode temp,prev;
        int index = hash(data,h.getTSize());
        for(temp = h.getTable()[index].getNext(),prev = null; temp != null; prev = temp, temp = temp.getNext()){
            if(temp.getData() == data){
                if(prev != null)
                    prev.setNext(temp.getNext());
                temp = null;
                h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount() - 1);
                h.setCount(h.getCount() - 1);
                return true;
            }
        }
        return false;
    }

    public static int hash(int data, int tSize){
        return data % tSize;
    }

    public static void rehash(HashTable h){
        int oldSize, i, index;
        ListNode p, temp, temp2;
        HashTableNode oldTable;
        oldSize = h.getTSize();
        oldTable = h.getTable()[0];
        h.setTSize(h.getTSize() * 2);
        h = new HashTable();
        if(h.getTable() == null){
            System.out.println("Memory Error");
            return;
        }
        for(i = 0; i < oldSize; i++){
            for(temp = oldTable.getNext(); temp != null; temp = temp.getNext()){
                index = hash(temp.getData(), h.getTSize());
                temp2 = temp;
                temp = temp.getNext();
                temp2.setNext(h.getTable()[i].getNext());
                h.getTable()[index].setNext(temp2);
            }
        }
    }
}
