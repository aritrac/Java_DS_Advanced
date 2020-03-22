package solution.aritra.problem050;

import java.util.*;

/**
 * Author: Aritra Chatterjee
 * Problem: A tree representing an expression us called an expression tree. In expression trees, leaf nodes are
 * operands and non-leaf nodes are operators. The figure below shows a simple expression tree for (A + B * C)/D
 *                              /
 *                             / \
 *                            +   D
 *                           / \
 *                          A   *
 *                             / \
 *                            B   C
 * Description: The postfix expression is ABC*+D/
 * The first 3 symbols are operands, so create tree nodes and push pointers to them onto a stack
 * Next, an operator '*' is read, so two pointers to trees are popped, a new tree is formed, and a pointer to that
 * trees root is pushed onto the stack
 * Next an operator '+' is read, so two pointers to trees are popped, a new tree is formed and a pointer to it is
 * pushed onto the stack.
 * Next an operand 'D' is read, a one node tree is created and a pointer to the corresponding tree is pushed onto the
 * stack.
 * Finally the last symbol / is read, two trees are merged and a pointer to the final tree is left on the stack.
 */
public class ExpressionTreeFromPostfixExpression {
    public static void main(String[] args) {
        char[] postfixExpr = "ABC*+D/".toCharArray();
        BinaryTreeNode root = buildExprTree(postfixExpr,postfixExpr.length);
        root.displayTree(root);
    }

    public static BinaryTreeNode buildExprTree(char[] postfixExpr, int size){
        Stack<BinaryTreeNode> stack = new Stack<>();
        for(int i = 0; i < size; i++){
            if(postfixExpr[i] >= 'A' && postfixExpr[i] <= 'Z'){
                BinaryTreeNode newNode = new BinaryTreeNode(postfixExpr[i]);
                newNode.setLeft(null);
                newNode.setRight(null);
                stack.push(newNode);
            }else{
                BinaryTreeNode t2 = stack.pop(), t1 = stack.pop();
                BinaryTreeNode newNode = new BinaryTreeNode(postfixExpr[i]);
                //Make t2 as the right child and t1 as left child for new node
                newNode.setLeft(t1);
                newNode.setRight(t2);
                stack.push(newNode);
            }
        }
        return stack.pop();
    }
}

class BinaryTreeNode {
    public char data;
    public BinaryTreeNode left,right;

    public BinaryTreeNode(char data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData(){
        return data;
    }

    public void setData(char data){
        this.data = data;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public void setRight(BinaryTreeNode right){
        this.right = right;
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
                    System.out.print(" " + (char)((int)iter.next()));
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
