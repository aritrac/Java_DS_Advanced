package solution.aritra.problem049;

import solution.aritra.tree.defs.KaryTreeNode;
/**
 * Author: Aritra Chatterjee
 * Problem: A full k-ary tree is a tree where each node has either 0 or k children. Given an array which contains the
 * preorder traversal of full k-ary tree, give an algorithm for constructing the full k-ary tree.
 * Description: In a k-ary tree, for a node at ith position its children will be at k*i + 1 to k*i + k.
 */
public class CreateKNaryTreeFromPreOrderArray {
    private static int ind = 0;
    public static void main(String[] args) {

    }

    public static KaryTreeNode buildKaryTree(int[] A,int n,int k){
        if(n <= 0)
            return null;
        KaryTreeNode newNode = new KaryTreeNode(k);

        newNode.setData(A[ind]);
        for(int i = 0; i < k; i++){
            if(k * ind + i < n){
                ind++;
                newNode.setChild(i,buildKaryTree(A,n,k));
            }else
                newNode.setChild(i,null);
        }
        return newNode;
    }
}