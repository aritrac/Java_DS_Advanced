package solution.aritra.util;

/**
 * Author: Aritra Chatterjee
 * Problem: Implementation of a ternary search tree
 */
public class TernarySearchTree {
    public TSTNode insertInTST(TSTNode root, String word, int position){
        if(root == null) {
            if (word.length() <= position) //all the chars are processed
                return root;
            root = new TSTNode();
            root.data = word.charAt(position);
            root.left = null;
            root.eq = null;
            root.right = null;
            if (position == word.length() - 1) {
                root.isEndOfString = true;
                return root;
            } else {
                return root.eq = insertInTST(root, word, position + 1);
            }
        }
        if(word.charAt(position) < root.data){
            root.left = insertInTST(root.left, word, position);
        }else if(word.charAt(position) == root.data){
            if(word.length() > position) //if still characters are remaining to be processed
                root.eq = insertInTST(root.eq, word, position + 1);
            else
                root.isEndOfString = true;
        }else{
            root.right = insertInTST(root.right, word, position);
        }
        return root;
    }

    public boolean searchInTSTRecursive(TSTNode root, String word, int position){
        if(root == null)
            return false;
        if(word.charAt(position) < root.data){
            return searchInTSTRecursive(root.left,word,position);
        }else if(word.charAt(position) > root.data){
            return searchInTSTRecursive(root.right, word, position);
        }else if(root.isEndOfString && word.length() <= position){
            return true;
        }
        return searchInTSTRecursive(root.eq, word, position + 1);
    }

    public boolean searchInTSTNonRecursive(TSTNode root, String word, int position){
        while(root != null){
            if(word.charAt(position) < root.data)
                root = root.left;
            else if(word.charAt(position) == root.data){
                if(root.isEndOfString && word.length() <= position)
                    return true;
                position++;
                root = root.eq;
            }else{
                root = root.right;
            }
        }
        return false;
    }
    StringBuffer word;
    int i = 0;
    public void displayAllWordsInTST(TSTNode root){
        if(root == null)
            return;
        displayAllWordsInTST(root.left);
        word.setCharAt(i,root.data);
        if(root.isEndOfString){
            System.out.println(word);
        }
        i++; //when going down the recursive tree towards leaves
        displayAllWordsInTST(root.eq);
        i--; //when going up the recursive tree
        displayAllWordsInTST(root.right);
    }

    //Finding the length of the largest word
    public int maxLengthOfLargestWordInTST(TSTNode root){
        if(root == null)
            return 0;
        return Math.max(maxLengthOfLargestWordInTST(root.left), Math.max(maxLengthOfLargestWordInTST(root.eq) + 1, maxLengthOfLargestWordInTST(root.right)));
    }
}
