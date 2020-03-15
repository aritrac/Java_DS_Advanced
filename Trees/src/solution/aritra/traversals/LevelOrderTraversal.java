package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.*;

/**
 * Author: Aritra Chatterjee
 * Problem: Do a level order traversal
 * Description: Follow the following algorithm
 * -> Visit the root
 * -> While traversing level 1, keep all the elements at level 1+1 in queue
 * -> Go to the next level and visit all the nodes at that level
 * -> Repeat this until all levels are completed
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        List<ArrayList<Integer>> result = levelOrder(root);
        Iterator<ArrayList<Integer>> iter = result.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static List<ArrayList<Integer>> levelOrder(BinaryTreeNode root){
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        //initialization
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null); //signifies the end of a level
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll(); //take out the next node from the queue for processing
            if(tmp != null){
                curr.add(tmp.getData());
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
            }else{
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                res.add(c_curr);
                curr.clear();//Java will clear the reference, so have to use a new ArrayList
                //completion of a level
                if(!q.isEmpty())
                    q.offer(null); //adding completion of a level in queue
            }
        }
        return res;
    }
}
