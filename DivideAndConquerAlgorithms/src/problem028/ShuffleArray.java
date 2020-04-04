package problem028;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of 2n integers in the following format a1a2a3...anb1b2b3...bn, shuffle the array to
 * a1 b1 a2 b2 a3 b3 anbn without any extra memory
 * Description:
 * ->Start with the array: a1 a2 a3 a4 b1 b2 b3 b4
 * ->Split the array into two halves: a1 a2 a3 a4 : b1 b2 b3 b4
 * ->Exchange elements around the center: exchange a3 a4 with b1 b2 you get: a1 a2 b1 b2 a3 a4 b3 b4
 * ->Split a1 a2 b1 b2 into a1 a2 : b1 b2 then split a3 a4 b3 b4 into a3 a4 : b3 b4
 * ->Exchange elements around the center for each subarray you get: a1 b1 a2 b2 and a3 b3 a4 b4
 */
public class ShuffleArray {
    public static void shuffleArray(int[] A, int l, int r){
        //array center
        int c = (l + r)/2, q = l + (l+c)/2;
        if(l == r)//base case when the array has only one element
            return;
        for(int k = l, i = q; i <= c; i++, k++){
            //swap elements around the center
            int temp = A[i];
            A[i] = A[c+k];
            A[c + k] = temp;
        }
        shuffleArray(A,l,c); //recursively call the function on the left and right
        shuffleArray(A,c+l,r); //recursively call the function on the right
    }
}
