package solution.aritra.problem001;

/**
 * Author: Aritra Chatterjee
 * Description: This problem shows the approach of tower of hanoi and its solution
 * How to solve: We can solve this by the following approach
 * #1 Move n-1 disk from source to auxilliary rod
 * #2 Move nth disk from source to destination
 * #4 Move n-1 disk from auxilliary to destination rod
 * The approach is provided below
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        //Calculating the solution of tower of hanoi using 3 disks
        towerOfHanoi(3,'S','D','A');
    }

    public static void towerOfHanoi(int n, char sourcePeg, char destPeg, char auxPeg){
        //If only one disk make the move and then return
        if(n == 1){
            System.out.println("Move disk 1 from peg " + sourcePeg + " to peg " + destPeg);
            return;
        }
        //Move top n-1 disks from source to auxilliary peg
        towerOfHanoi(n-1,sourcePeg,auxPeg,destPeg);
        //Move nth disk from source to destination
        System.out.println("Move disk from peg " + sourcePeg + " to peg " + destPeg);
        //Move n-1 disks from auxilliary to destination
        towerOfHanoi(n-1,auxPeg,destPeg,sourcePeg);
    }
}
