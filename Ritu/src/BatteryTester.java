import java.util.Scanner;

public class BatteryTester {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int current = 0;
        while((current = in.nextInt()) != 0){
            if(current == 1)
                System.out.println(0);
            else if(current == 2)
                System.out.println(1);
            else
                System.out.println(minTriesForCurrent(2,current));
        }
    }


    static int max(int a, int b) { return (a > b)? a: b; }

    static int minTriesForCurrent(int n, int k)
    {
        int currents[][] = new int[n+1][k+1];
        int res;
        int i, j, x;

        for (i = 1; i <= n; i++)
        {
            currents[i][1] = 1;
            currents[i][0] = 0;
        }

        for (j = 1; j <= k; j++)
            currents[1][j] = j;

        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                currents[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                    res = 1 + max(currents[i-1][x-1], currents[i][j-x]);
                    if (res < currents[i][j])
                        currents[i][j] = res;
                }
            }
        }

        return currents[n][k];

    }
}
