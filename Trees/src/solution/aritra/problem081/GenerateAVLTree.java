package solution.aritra.problem081;

import solution.aritra.tree.defs.AVLTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a height h, give an algorithm for generating an AVL tree with minimum number of nodes
 * Description: To get the minimum number of nodes, fill one level with h-1 and the other with h-2
 */
public class GenerateAVLTree {
    private static int count = 0;
    public static AVLTreeNode generateAVLTree(int h){
        AVLTreeNode temp;
        if(h == 0)
            return null;
        temp = new AVLTreeNode();
        temp.setLeft(generateAVLTree(h-1));
        temp.setData(count++);
        temp.setRight(generateAVLTree(h-2));
        temp.setHeight(temp.getLeft().getHeight() + 1);
        return temp;
    }
}
