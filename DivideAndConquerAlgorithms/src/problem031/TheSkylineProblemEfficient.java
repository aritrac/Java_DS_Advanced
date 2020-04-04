package problem031;

/**
 * Author: Aritra Chatterjee
 * Problem: Given the exact locations and shapes of n rectangular buildings in a 2 dimensional city. There is no
 * particular order for these rectangular buildings.Assume that the bottom of all buildings lie on a fixed horizontal
 * line. The input is a list of triples, one per building. A building Bi is represented by the triplet (l,h,r) where
 * l denotes the x position of the left edge and r denotes the x position of the right edge and h denotes the
 * buildings height. Give an algorithm that computes the skyline of these buildings, eliminating hidden lines.
 * The r of the rightmost building is < 1000 and l of the leftmost building is 1
 * Description:
 * It would be a hugh speed up if somehow we could determine the skyline by calculating the height for those coordinates
 * only where it matters. Intuition tells us that if we can insert a building into an existing skyline then instead
 * of all the coordinates the building spans over, we only need to check the height of the left and right coordinates of
 * the building plus those coordinates of the skyline the building overlaps with and may modify.
 */

public class TheSkylineProblemEfficient {
    static Skyline getSkyLine(Building[] buildings, int start, int end){
        if(start == end){
            Skyline skl = new Skyline(2);
            skl.append(new Strip(buildings[start].left, buildings[start].h));
            skl.append(new Strip(buildings[start].right,0));
            return skl;
        }
        int mid = (start + end )/2;
        Skyline sk1 = getSkyLine(buildings,start,mid);
        Skyline sk2 = getSkyLine(buildings,mid + 1, end);
        return mergeSkylines(sk1,sk2);
    }

    static Skyline mergeSkylines(Skyline sk1, Skyline sk2){
        Skyline newSkl = new Skyline(sk1.count + sk2.count); //allocate array space
        int currentHeight1 = 0;
        int currentHeight2 = 0;
        while(sk1.count > 0 && sk2.count > 0){
            if(sk1.head().left < sk2.head().left){
                int curX = sk1.head().left;
                currentHeight1 = sk1.head().h;
                int maxH = currentHeight1;
                if(currentHeight2 > maxH)
                    maxH = currentHeight2;
                newSkl.append(new Strip(curX,maxH));
                sk1.removeHead();
            }else{
                int curX = sk2.head().left;
                currentHeight2 = sk2.head().h;
                int maxH = currentHeight1;
                if(currentHeight2 > maxH)
                    maxH = currentHeight2;
                newSkl.append(new Strip(curX,maxH));
                sk2.removeHead();
            }
        }
        while(sk1.count > 0) {
            Strip str = sk1.removeHead();
            newSkl.append(str);
        }
        while(sk2.count > 0){
            Strip str = sk2.removeHead();
            newSkl.append(str);
        }
        return newSkl;
    }
}

class Building {
    int left,right,h;
    public Building(int x1, int h1, int x2){
        left = x1;
        h = h1;
        right = x2;
    }
}

class Strip{
    int left,h;
    Strip(int x1, int h1){
        left = x1;
        h = h1;
    }
}

class Skyline{
    Strip[] strips;
    public int count;
    int startLoc;

    public Skyline(int n){
        count = 0;
        startLoc = 0;
        strips = new Strip[n];
    }

    public void append(Strip str){
        strips[startLoc + count] = str;
        count++;
    }

    public Strip head(){
        return strips[startLoc];
    }

    public Strip removeHead(){
        Strip str = strips[startLoc];
        count--;
        startLoc++;
        return str;
    }

    public String toString(){
        String str = "";
        for(int i = startLoc; i < startLoc + count; i++){
            if(i > startLoc)
                str = str + ", ";
            str = str + strips[i].left + "," + strips[i].h;
        }
        return "(" + str + ")";
    }
}
