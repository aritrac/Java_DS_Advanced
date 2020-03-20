import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Posted!");
        System.out.println("1.Sign in");
        System.out.println("2.Quit");
        System.out.println("Please Enter your choice:");

        int StudentMenu = userInput.nextInt();

        String StudentUsername;

        while(true) {

            System.out.println("Enter Username:");
            StudentUsername = userInput.nextLine();
            switch(StudentMenu) {

                case 1:
                    System.out.println("Welcome to your posted page!!:"  +StudentUsername+ "!" );
                    System.out.println("~~~~~~~~~~~~~~~~~");
                    System.out.println("1.New Event Post"); //done
                    System.out.println("2.New Sale Post");  //done
                    System.out.println("3.New Job Post");   //done
                    System.out.println("4.Reply to Post");
                    System.out.println("5.Display My Post");
                    System.out.println("6.Display All Post"); //done
                    System.out.println("7.Close Post");
                    System.out.println("8.Delete Post");
                    System.out.println("9.Log Out");
                    System.out.println("Enter your choice:");
                    int choice = userInput.nextInt();
                    userInput.nextLine();
            }
        }
    }
}
