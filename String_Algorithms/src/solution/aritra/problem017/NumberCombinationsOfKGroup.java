package solution.aritra.problem017;

import java.util.ArrayList;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example if n = 4 and k = 2, a solution is [2,4],[3,4],[2,3],[1,2],[1,3],[1,4]
 * Description: Refer to problem 10. It is very much similar to that, only we use numbers instead of characters from
 * a given string.
 */
public class NumberCombinationsOfKGroup {
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        ArrayList<ArrayList<Integer>> res = numberCombinations(n,k);
        for(ArrayList<Integer> result : res){
            for(Integer num : result){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> numberCombinations(int n,int k){
        if(n < k)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k == 1){
            for(int i = 1; i <= n; i++){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                res.add(arr);
            }
            return res;
        }
        for(int i = n; i >= k; i--){
            for(ArrayList<Integer> arr: numberCombinations(i-1,k-1)){
                arr.add(i);
                res.add(arr);
            }
        }
        return res;
    }
}
