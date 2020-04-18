package problem022;

/**
 * Author: Aritra Chatterjee
 * Problem: Assume that we are given a set of n rectangular 3-d boxes. The dimensions of ith box are height hi, width
 * wi and depth di. Now we want to create a stack of boxes which is as tall as possible, but we can only stack a
 * box on top of another box if the dimensions of the 2-d base of the lower box are each strictly larger than those
 * of the 2-d base of the higher box. We can rotate a box so that any side functions as its base. It is possible
 * to use multiple instances of the same type of box.
 * Description: Box stacking problem can be reduced to the longest increasing subsequence problem.
 * Let us say that H(j) represents the tallest stack of boxes with box j on top. This is very similar to the LIS problem
 * because the stack of n boxes with ending box j is equal to finding a subsequence with the first j boxes due to the
 * sorting by decreasing base area. The order of the boxes on the stack is going to be equal to the order of the
 * sequence.
 * 1) Generate all 3 rotations of all boxes. The size of rotation array becomes 3 times the size of original array. For
 * simplicity, we consider depth as always smaller than or equal to width.
 *
 * 2) Sort the above generated 3n boxes in decreasing order of base area.
 *
 * 3) After sorting the boxes, the problem is same as LIS with following optimal substructure property.
 * MSH(i) = Maximum possible Stack Height with box i at top of stack
 * MSH(i) = { Max ( MSH(j) ) + height(i) } where j < i and width(j) > width(i) and depth(j) > depth(i).
 * If there is no such j then MSH(i) = height(i)
 *
 * 4) To get overall maximum height, we return max(MSH(i)) where 0 < i < n
 *
 * Following is the implementation of the above solution.
 */

public class BoxStackingProblem {

}
