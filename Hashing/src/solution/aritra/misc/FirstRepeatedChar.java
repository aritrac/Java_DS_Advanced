package solution.aritra.misc;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for printing the first repeated character if there are duplicated elements in it.
 * Description: We know that the number of possible characters is 256. Create an array of size 256 and initialize it
 * will all zeroes.For each of the input characters go to the corresponding position and increment its count.
 * will all zeroes.For each of the input characters go to the corresponding position and increment its count. Since
 * we are using arrays, it takes constant time for reaching any location. While scanning the input, if we get a
 * character whose counter is already 1 then we can say that the character is the one which is repeating for the
 * first time.
 */
public class FirstRepeatedChar {
    public char firstRepeatedChar(char[] str){
        int[] count = new int[256]; //additional array
        int i;
        for(i = 0; i < 256; ++i){
            count[i] = 0;
        }
        for(i = 0; i < str.length; ++i){
            if(count[str[i]] == 1){
                System.out.println(str[i]);
                break;
            }else{
                count[str[i]]++;
            }
        }
        if(i == str.length)
            System.out.println("No repeated characters");
        return 0;
    }
}
