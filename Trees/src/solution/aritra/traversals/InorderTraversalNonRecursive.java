package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Do an inorder traversal without recursion
 * Description: See the code below which uses a stack which simulates recursion.
 */
public class InorderTraversalNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        List<Integer> list = inorderTraversalNonRecursive(root);
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static ArrayList<Integer> inorderTraversalNonRecursive(BinaryTreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        boolean done =false;
        BinaryTreeNode currentNode = root;
        while(!done){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else{
                if(stack.isEmpty())
                    done = true;
                else{
                    currentNode = stack.pop();
                    System.out.println(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return result;
    }
}
