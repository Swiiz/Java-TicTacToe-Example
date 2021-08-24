package fr.alexgamma.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToeTable table = new TicTacToeTable();
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while(result==0) {
            System.out.println("It is " + table.nextTurnPlayer() + " turn to play! Use the numpad (1-9) to play.");
            if(!table.play(scanner.nextInt() - 1)) continue;
            System.out.println("Current grid:\n" + table);
            result = table.evaluate();
        }
        if(result == 3) {
            System.out.println("The match finished in a draw!");
        }else {
            System.out.println(TicTacToeTable.playerName(result) + " won the match!");
        }
    }

}
