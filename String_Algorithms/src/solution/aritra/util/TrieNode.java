package solution.aritra.util;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Author: Aritra Chatterjee
 * Description: Declaration of a trie node
 */
public class TrieNode {
    char data;
    boolean isEndOfString;
    Collection<TrieNode> child;

    public TrieNode(char c){
        child = new LinkedList<TrieNode>();
        isEndOfString = false;
        data = c;
    }
    public TrieNode subNode(char c){
        if(child != null){
            for(TrieNode eachChild : child){
                if(eachChild.data == c)
                    return eachChild;
            }
        }
        return null;
    }
}
