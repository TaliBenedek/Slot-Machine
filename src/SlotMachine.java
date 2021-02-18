
import java.util.*;
/**
 *
 * @author Tali
 */
public class SlotMachine
{
    final static int STAR = 6;
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        System.out.println("This is a slot machine game.");
        char repeat = 'n';
        int rounds = 0;
        double winnings = 0;
        Random rnum = new Random();
        do {
            System.out.println("\nHow much money do you want to bet? ");
            double bet = kbd.nextDouble();
            int num1 = rnum.nextInt(7);
            int num2 = rnum.nextInt(7);
            int num3 = rnum.nextInt(7);
            showOutcome(num1, num2, num3);
            winnings += getWinnings(num1, num2, num3, bet);
            rounds++;
            System.out.println("\nDo you want to play again? Enter Y for yes"
                    + " and N for no: ");
            String input = kbd.next();
            repeat = input.charAt(0);
        } while (repeat == 'y' || repeat == 'Y');
        showResults(winnings, rounds);

    }

    public static void showOutcome(int num1, int num2, int num3)
    {
        getImage(num1);
        getImage(num2);
        getImage(num3);
    }

    public static void getImage(int num)
    {
        String [] show = {"A ","B ","C ","D ","E ","F ","* "};
        System.out.print(show[num]);
    }

    public static double getWinnings(int num1, int num2, int num3, double bet)
    {
        double wonThisRound = bet;
        if (num1 == STAR && num2 == STAR && num3 == STAR)
        {
            System.out.printf("\nAll three are stars! You "
                    + "win $%.2f", (bet*9));
            if (num1 == STAR && num2 == STAR && num3 == STAR)
                wonThisRound *= 9;
        }

        else if (num1 == num2 && num2 == num3)
        {
            System.out.printf("\nAll three match! You win $%.2f", (bet*3));
            wonThisRound *= 3;
        }

        else if ((num1 == STAR && num2 == STAR) ||
                (num1 == STAR && num3 == STAR) ||
                (num2 == STAR && num3 == STAR) ||
                (num1 == STAR && num2 == num3) ||
                (num2 == STAR && num1 == num3) ||
                (num3 == STAR && num1 == num2)
        )
        {
            System.out.printf("\nAll three match! You win $%.2f", (bet*3));
            wonThisRound *= 3;
        }

        else if (num1 == num2 || num1 == num3 || num2 == num3 ||
                num1 == STAR || num2 == STAR || num3 == STAR)
        {
            System.out.printf("\nTwo match! You win $%.2f", (bet));
            wonThisRound += bet;
        }

        else
        {
            System.out.println("\nYou lose!");
            wonThisRound = (-bet);
        }
        return wonThisRound;
    }

    public static void showResults(double winnings, int rounds)
    {
        if (winnings < 0)
        {
            System.out.printf("\nWe played " + rounds + " round(s). "
                    + "\nYou lost $%.2f\n", (winnings*=(-1)));
        }
        else if (winnings > 0)
        {
            System.out.printf("\nWe played " + rounds + " round(s). "
                    + "\nYou won $%.2f\n", winnings);
        }
        else
        {
            System.out.println("\nWe played " + rounds + " round(s). "
                    + "\nYou broke even.\n");
        }
    }


}

