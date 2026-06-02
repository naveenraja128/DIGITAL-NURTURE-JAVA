import java.util.Random;
import java.util.Scanner;

public class GuessNumber{
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = 0;

        while(guess != number){

            System.out.println("enter the number between 1 to 100 : ");
            guess = sc.nextInt();

            if(guess > number){
                System.out.println("too high");
            }
            
            else if(guess < number){
                System.out.println("too low");
            }

            else{
                System.out.println("Correct! you guessed number");
            }
        }

        sc.close();
    }
}