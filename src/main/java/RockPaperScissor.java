import org.apache.poi.ss.formula.atp.Switch;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] Args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the name of Player1");
        String P1 = myObj.nextLine();

        System.out.println("Enter the name of Player1");
        String P2 = myObj.nextLine();

        boolean playAgain = true;

        String[] options = {"Rock", "Scissor", "Paper"};

        int P1RoundWon = 0;
        int P2RoundWon = 0;

        while (playAgain) {
            Random random = new Random();
            boolean randomBoolean = random.nextBoolean();

            String selectedPlayer = (randomBoolean) ? P1 : P2;
            String otherPlayer = (randomBoolean) ? P2 : P1;

            System.out.println("Selected Player is : " + selectedPlayer);


            for (int i = 0; i < 3; i++) {
                System.out.println("Round " + i+1 + " : ");
                System.out.println(selectedPlayer + " Enter your action : ");
                int P1Action = myObj.nextInt();
                String P1Select = options[P1Action];

                System.out.println(otherPlayer + " Enter your action : ");
                int P2Action = myObj.nextInt();
                String P2Select = options[P2Action];

                if (P1Select == "Rock" && P2Select == "Scissor") {
                    System.out.println(selectedPlayer + " won this round");
                    P1RoundWon++;
                } else if (P1Select == "Rock" && P2Select == "Paper") {
                    System.out.println(otherPlayer + " won this round");
                    P2RoundWon++;
                } else if (P1Select == "Scissor" && P2Select == "Paper") {
                    System.out.println(selectedPlayer + " won this round");
                    P1RoundWon++;
                } else if (P1Select == "Scissor" && P2Select == "Rock") {
                    System.out.println(otherPlayer + " won this round");
                    P2RoundWon++;
                } else if (P1Select == "Paper" && P2Select == "Scissor") {
                    System.out.println(otherPlayer + " won this round");
                    P2RoundWon++;
                } else if (P1Select == "Paper" && P2Select == "rock") {
                    System.out.println(selectedPlayer + " won this round");
                    P1RoundWon++;
                }
            }
            if(P1RoundWon > P2RoundWon){
                System.out.println(selectedPlayer + " is the winner!!!");
            }
            else if(P1RoundWon < P2RoundWon){
                System.out.println(otherPlayer + " is the winner!!!");
            }
            else{
                System.out.println(otherPlayer + " Round Tied!!!");
            }

            System.out.println("Player 1 do you want to play again? Enter 1 for 'Yes' and 0 for 'No' : ");
            int P1Ans = myObj.nextInt();

            System.out.println("Player 2 do you want to play again? Enter 1 for 'Yes' and 0 for 'No' : ");
            int P2Ans = myObj.nextInt();

            if(P1Ans == 0 && P2Ans== 0) {
                playAgain = false;
                System.out.println("Thanks for Playing!!");
            }
        }
    }
}
