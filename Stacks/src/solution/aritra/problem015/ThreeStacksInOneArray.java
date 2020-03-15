package solution.aritra.problem015;

/**
 * Author: Aritra Chatterjee
 * Problem: How to implement 3 stacks in one array
 * Description:
 * -> For pushing on to the first stack, we need to see if adding a new element causes it to bump into the third stack.
 * if so, try to shift the third stack upwards. Insert the new element at (start1 + top1)
 * -> For pushing to the second stack, we need to see if adding a new element causes it to bump into the third stack.
 * If so, try to shift the third stack downwards. Insert the new element at (start2 - top2)
 * -> When pushing to the third stack, see if it bumps into the second stack. If so, try to shift the third stack
 * downward and try pushing again. Insert the new element at (start3 + top3)
 * -> For popping, we don't need to shift, just decrement the size of the appropriate stack.
 */
public class ThreeStacksInOneArray {
    private int[] dataArray;
    private int size, topOne, topTwo, baseThree, topThree;

    public ThreeStacksInOneArray(){
        if(size < 3)
            throw new IllegalStateException("Size < 3 is not permissible");
        dataArray = new int[size];
        this.size = size;
        topOne = -1;
        topTwo = size;
        baseThree = size/2;
        topThree = baseThree;
    }

    public void push(int stackId, int data){
        if(stackId == 1){
            if(topOne + 1 == baseThree){
                if(stack3IsRightShiftable()){
                    shiftStack3ToRight();
                    dataArray[++topOne] = data;
                }else{
                    System.out.println("Stack 1 has reached max limit");
                    return;
                }
            }else{
                dataArray[++topOne] = data;
            }
        }else if(stackId == 2){
            if(topTwo - 1 == topThree){
                if(stack3IsLeftShiftable()){
                    shiftStack3ToLeft();
                    dataArray[--topTwo] = data;
                }else{
                    System.out.println("Stack 2 has reached max limit");
                }
            }else{
                dataArray[--topTwo] = data;
            }
        }else if(stackId == 3){
            if(topTwo - 1 == topThree){
                if(stack3IsLeftShiftable()){
                    shiftStack3ToLeft();
                    dataArray[++topThree] = data;
                }else{
                    System.out.println("Stack 3 has reached max limit");
                }
            }
        }else
            return;
    }

    public int pop(int stackId){
        if(stackId == 1){
            if(topOne == -1){
                System.out.println("Stack 1 is empty");
                return Integer.MIN_VALUE;
            }
            int toPop = dataArray[topOne];
            dataArray[topOne--] = Integer.MIN_VALUE;
            return toPop;
        }else if(stackId == 2){
            if(topTwo == this.size){
                System.out.println("Stack 2 is empty");
                return Integer.MIN_VALUE;
            }
            int toPop = dataArray[topTwo];
            dataArray[topTwo++] = Integer.MIN_VALUE;
            return toPop;
        }else if(stackId == 3){
            if(topThree == baseThree || dataArray[topThree] == Integer.MIN_VALUE){
                System.out.println("Stack 3 is empty");
                return Integer.MIN_VALUE;
            }
            int toPop = dataArray[topThree];
            if(topThree > baseThree)
                dataArray[topThree--] = Integer.MIN_VALUE;
            if(topThree == baseThree)
                dataArray[topThree] = Integer.MIN_VALUE;
            return toPop;
        }else
            return Integer.MIN_VALUE;
    }

    public int top(int stackId){
        if(stackId == 1){
            if(topOne == -1){
                System.out.println("Stack 1 is empty");
                return Integer.MIN_VALUE;
            }
            return dataArray[topOne];
        }else if(stackId == 2){
            if(topTwo == this.size){
                System.out.println("Stack 2 is empty");
                return Integer.MIN_VALUE;
            }
            return dataArray[topTwo];
        }else if(stackId == 3){
            if(topThree == baseThree || dataArray[topThree] == Integer.MIN_VALUE){
                System.out.println("Stack 3 is empty");
                return Integer.MIN_VALUE;
            }
            return dataArray[topThree];
        }else
            return Integer.MIN_VALUE;
    }

    public boolean isEmpty(int stackId){
        if(stackId == 1){
            return topOne == -1;
        }else if(stackId == 2) {
            return topTwo == this.size;
        }else if(stackId == 3){
            return topThree == baseThree && dataArray[baseThree] == Integer.MIN_VALUE;
        }else return true;
    }

    private void shiftStack3ToLeft(){
        for(int i = baseThree - 1; i <= topThree - 1;i++){
            dataArray[i] = dataArray[i+1];
            dataArray[topThree--] = Integer.MIN_VALUE;
            baseThree--;
        }
    }

    private boolean stack3IsLeftShiftable(){
        if(topOne + 1 < baseThree)
            return true;
        return false;
    }

    private void shiftStack3ToRight(){
        for(int i = topThree + 1; i >= baseThree + 1; i--){
            dataArray[i] = dataArray[i - 1];
        }
        dataArray[baseThree++] = Integer.MIN_VALUE;
        topThree++;
    }

    private boolean stack3IsRightShiftable(){
        if(topThree + 1 < topTwo)
            return true;
        return false;
    }
}
