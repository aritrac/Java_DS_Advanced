package solution.aritra.problem075;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Each node in the BST has an additional field r which indicates the size of the subtree rooted at r. Give
 * an algorithm to find the number of keys that are strictly greater than k.
 */
public class NodesGreaterThanK {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();
        System.out.println("The initial tree");
        BinarySearchTree.displayTree(root);
        int k = 4;
        System.out.println("The number of nodes greater than k = " + greaterThanConstantK(root,k));
    }

    public static int greaterThanConstantK(BinarySearchTreeNode root, int k){
        int keysCount = 0;

        while(root!= null){
            if(k < root.getData()){
                keysCount = keysCount + root.getSize() + 1;
                root = root.getLeft();
            }else if(k > root.getData()){
                root = root.getRight();
            }else{
                keysCount = keysCount + root.getSize();
                break;
            }
        }
        return keysCount;
    }
}
