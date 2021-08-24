package fr.alexgamma.tictactoe;

public class TicTacToeTable {

    private int[] grid = new int[9];
    private boolean xTurn = true;

    /**
     * Play a turn
     * @param position
     * @return false if an error occured and true if the play was successful
     */
    boolean play(int position) {
        if(grid[position] != 0) return false;
        grid[position] = xTurn ? 1 : 2;
        xTurn = !xTurn;
        return true;
    }

    /**
     * Generate a visual version of the grid
     * @return the grid as String
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 8; i >= 0; i-=3) {
            result += "+---+---+---+\n| " + getGridSymbol(i-2) + " | " + getGridSymbol(i-1) + " | " + getGridSymbol(i) + " |\n";
        }
        result += "+---+---+---+\n";
        return result;
    }

    /**
     * Get the symbol representing the player at the given position
     * @param position
     * @return the symbol, either X or O
     */
    private String getGridSymbol(int position) {
        return grid[position] == 0 ? " " : grid[position] == 1 ? "X" : "O";
    }

    /**
     * Give the name of the player who need to play next
     * @return the name of the player
     */
    public String nextTurnPlayer() {
        return playerName(xTurn ? 1 : 2);
    }

    /**
     * Evalute the current grid to find the potential winner
     * @return 0 if there is no winner, 1 if x wins, 2 if o wins, 3 if the game is over and nobody won
     */
    public int evaluate() {
        // Horizontal
        if(grid[0] == grid[1] && grid[1] == grid[2] && grid[0] != 0) return grid[0];
        if(grid[3] == grid[4] && grid[4] == grid[5] && grid[3] != 0) return grid[3];
        if(grid[6] == grid[7] && grid[7] == grid[8] && grid[6] != 0) return grid[6];

        // Vertical
        if(grid[0] == grid[3] && grid[3] == grid[6] && grid[0] != 0) return grid[0];
        if(grid[1] == grid[4] && grid[4] == grid[7] && grid[1] != 0) return grid[1];
        if(grid[2] == grid[5] && grid[5] == grid[8] && grid[2] != 0) return grid[2];

        // Diagonals
        if(grid[0] == grid[4] && grid[4] == grid[8] && grid[0] != 0) return grid[0];
        if(grid[2] == grid[4] && grid[4] == grid[6] && grid[2] != 0) return grid[2];

        boolean draw = true;
        for(int e : grid) {
            if (e == 0) {
                draw = false;
                break;
            }
        }
        return draw ? 3 : 0;
    }

    /**
     * Return the player name from the input int
     * i == 1 ? "Cross (X)" : "Circle (O)"
     * @param i the integer representing the player
     * @return the player name
     */
    public static String playerName(int i) {
        return (i == 1 ? "Cross (X)" : "Circle (O)");
    }
}
