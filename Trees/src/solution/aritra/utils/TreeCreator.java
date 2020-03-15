package solution.aritra.utils;

import solution.aritra.tree.defs.BinaryTreeNode;

import java.util.*;

/**
 * Author: Aritra Chatterjee
 * Description: Various helper methods wrt Trees
 */
public class TreeCreator {

    public BinaryTreeNode createTree(){
        BinaryTreeNode nodeOne = new BinaryTreeNode(1);
        BinaryTreeNode nodeTwo = new BinaryTreeNode(2);
        BinaryTreeNode nodeThree = new BinaryTreeNode(3);
        BinaryTreeNode nodeFour = new BinaryTreeNode(4);
        BinaryTreeNode nodeFive = new BinaryTreeNode(5);
        BinaryTreeNode nodeSix = new BinaryTreeNode(6);
        BinaryTreeNode nodeSeven = new BinaryTreeNode(7);

        nodeOne.setLeft(nodeTwo);
        nodeOne.setRight(nodeThree);

        nodeTwo.setLeft(nodeFour);
        nodeTwo.setRight(nodeFive);

        nodeThree.setLeft(nodeSix);
        nodeThree.setRight(nodeSeven);
        return nodeOne;
    }

    public void displayTree(BinaryTreeNode root){
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> row = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                row.add(tmp.getData());
                if(tmp.getLeft() != null){
                    q.offer(tmp.getLeft());
                }
                if(tmp.getRight() != null){
                    q.offer(tmp.getRight());
                }
            }else{ //this means row finished, now print it out
                Iterator<Integer> iter = row.iterator();
                while(iter.hasNext()){
                    System.out.print(" " + iter.next());
                }
                System.out.println();
                row.clear();
                if(!q.isEmpty()){
                    q.offer(null); //put marker for the next row
                }
            }
        }
    }
}
