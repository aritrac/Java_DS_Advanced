import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueCities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> cityList = new ArrayList<String>();
        //Entering T <= 50
        int T = in.nextInt();
        if(T > 50)
            System.exit(0);
        for(int i = 0; i < T; i++){
            int n = in.nextInt();
            if(n > 100) //at most 100 trips
                continue;
            for(int j = 0; j < n; j++){
                String city = in.next();
                if(city.length() > 20)
                    continue;
                if(!cityList.contains(city))
                    cityList.add(city);
            }
            System.out.println(cityList.size());
            cityList.clear();
        }
    }
}
