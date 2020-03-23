package solution.aritra.problem061;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sorted array, give an algorithm for converting the array to BST
 * Description: If we have to choose an array element to be the root of a balanced BST, which element should we
 * pick? The root of a balanced BST should be the middle element from the sorted array. We would pick the middle
 * element from the sorted array in each iteration. We then create a node in the tree initialized with this element.
 * After the element is chosen, what is left? Could you identify the sub problems within the problem?
 * There are two arrays left - the one on its left and the one on its right. These two arrays are the sub-problems
 * of the original problem, since both of them are sorted. Furthermore they are subtrees of the current node's
 * left and right child.
 */
public class BuildBSTFromArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7}; //sorted array

        BinarySearchTreeNode root = buildBST(array,0,array.length - 1);

        BinarySearchTree.displayTree(root);
    }

    public static BinarySearchTreeNode buildBST(int[] arr, int left, int right){
        if(left > right)
            return null;
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(0);
        if(left == right){
            newNode.setData(arr[left]); //right can also be used as they are equal, no case of mid here.
        }else {
            int mid = left + (right - left)/2;
            newNode.setData(arr[mid]);
            newNode.setLeft(buildBST(arr,left,mid - 1));
            newNode.setRight(buildBST(arr,mid + 1, right));
        }
        return newNode;
    }
}
