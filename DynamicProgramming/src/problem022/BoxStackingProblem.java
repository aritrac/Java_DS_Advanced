package problem022;

import java.util.Arrays;

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
//represents a box
class Box implements Comparable<Box>{
    int h,w,d, area;
    //h -> height, w -> width, d -> depth

    //for simplicity of solution always keep w <= d

    //constructor to initialize the box
    public Box(int h, int w, int d){
        this.h = h;
        this.w = w;
        this.d = d;
    }

    //to sort the box array on the basis of area in decreasing order of area
    public int compareTo(Box o){
        return o.area - this.area;
    }
}

public class BoxStackingProblem {
    /* Returns the height of the tallest
    stack that can be formed with given
    type of boxes */
    static int maxStackHeight( Box arr[], int n){

        Box[] rot = new Box[n*3];

        /* New Array of boxes is created -
        considering all 3 possible rotations,
        with width always greater than equal
        to depth */
        for(int i = 0;i < n;i++){
            Box box = arr[i];

            /* Orignal Box*/
            rot[3*i] = new Box(box.h, Math.max(box.w,box.d),
                    Math.min(box.w,box.d));

            /* First rotation of box*/
            rot[3*i + 1] = new Box(box.w, Math.max(box.h,box.d),
                    Math.min(box.h,box.d));

            /* Second rotation of box*/
            rot[3*i + 2] = new Box(box.d, Math.max(box.w,box.h),
                    Math.min(box.w,box.h));
        }

        /* Calculating base area of
        each of the boxes.*/
        for(int i = 0; i < rot.length; i++)
            rot[i].area = rot[i].w * rot[i].d;

        /* Sorting the Boxes on the bases
        of Area in non Increasing order.*/
        Arrays.sort(rot);

        int count = 3 * n;

        /* Initialize msh values for all
        indexes
        msh[i] --> Maximum possible Stack Height
                   with box i on top */
        int[]msh = new int[count];
        for (int i = 0; i < count; i++ )
            msh[i] = rot[i].h;

        /* Computing optimized msh[]
        values in bottom up manner */
        for(int i = 0; i < count; i++){
            msh[i] = 0;
            Box box = rot[i];
            int val = 0;

            for(int j = 0; j < i; j++){
                Box prevBox = rot[j];
                if(box.w < prevBox.w && box.d < prevBox.d){
                    val = Math.max(val, msh[j]);
                }
            }
            msh[i] = val + box.h;
        }

        int max = -1;

        /* Pick maximum of all msh values */
        for(int i = 0; i < count; i++){
            max = Math.max(max, msh[i]);
        }

        return max;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {

        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println("The maximum possible "+
                "height of stack is " +
                maxStackHeight(arr,4));
    }
}
