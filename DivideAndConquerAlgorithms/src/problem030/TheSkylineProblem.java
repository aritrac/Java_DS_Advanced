package problem030;

import java.util.Scanner;

/**
 * Author: Aritra Chatterjee
 * Problem: Given the exact locations and shapes of n rectangular buildings in a 2 dimensional city. There is no
 * particular order for these rectangular buildings.Assume that the bottom of all buildings lie on a fixed horizontal
 * line. The input is a list of triples, one per building. A building Bi is represented by the triplet (l,h,r) where
 * l denotes the x position of the left edge and r denotes the x position of the right edge and h denotes the
 * buildings height. Give an algorithm that computes the skyline of these buildings, eliminating hidden lines.
 * The r of the rightmost building is < 1000 and l of the leftmost building is 1
 * Description:
 * We can assign a height value to every distinct x coordinate where i is between 0 and 999
 * ->Allocate an array for 1000 elements and initialize all of the elements to 0. Let's call this array auxHeights
 * ->Iterate over all the buildings and for every building Bi iterate on the range of li to ri where li is the left
 * and ri is the right coordinate of the building Bi
 * ->For every xj element of this range check if hi > auxHeights[xj], that is if the building Bi is taller than the
 * current height value at position xj. If so, replace auxHeights[xj] with hi
 * ->Once we checked all the buildings, the auxHeights array stores the heights of the tallest buildings at every
 * position. There is one more thing to do. Convert the auxHeights array to the expected output format, that is to a
 * sequence of position-height pairs
 */

public class TheSkylineProblem {
    public static void main(String[] args) {
        int[] auxHeights = new int[1000];
        int rightMostBuildingRi = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int left = in.nextInt(), h = in.nextInt(), right = in.nextInt();
            for(int i = left; i < right; i++){
                auxHeights[i] = Math.max(h,auxHeights[i]);
            }
            if(rightMostBuildingRi < right)
                rightMostBuildingRi = right;
        }
        int prev=0,left=-1,right=-1;
        for(int i = 0; i < rightMostBuildingRi; i++){
            if(prev != auxHeights[i]){
                if(left > 0)
                    System.out.print(left + " " + right + " ");
                prev = auxHeights[i];
                left = i;
                right = prev;
            }
        }
        System.out.println(left + " " + right);
    }
}
