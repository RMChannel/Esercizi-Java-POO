import java.util.Scanner;

public class TicTacToe {

    private final String[][] board;
    static final int ROWS = 3;
    static final int COLUMNS = 3;
    static final String player1 = "x";
    static final String player2 = "o";

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            r.append("|");
            for (int j = 0; j < COLUMNS; j++)
                r.append(board[i][j]);
            r.append("|\n");
        }
        return r.toString();
    }

    public void set(int i, int j, String player) {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    public boolean controlRow(String player) {
        for(int i=0;i<COLUMNS;i++) {
            if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) return true;
        }
        return false;
    }

    public boolean controlVetical(String player) {
        for(int i=0;i<ROWS;i++) {
            if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) return true;
        }
        return false;
    }

    public boolean controlDiagonal(String player) {
     if(board[1][1].equals(player)) {
         if(board[0][0].equals(player) && board[2][2].equals(player)) return true;
         else if(board[0][2].equals(player) && board[2][0].equals(player)) return true;
     }
     return false;
    }

    public String getWinner() {
        if (controlRow(player1)) return player1;
        else if (controlRow(player2)) return player2;
        else if (controlVetical(player1)) return player1;
        else if (controlVetical(player2)) return player2;
        else if (controlDiagonal(player1)) return player1;
        else if (controlDiagonal(player2)) return player2;
        else return "Nessun vincitore";
    }

    public static void main(String[] args) {
        String player = player1;
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, column;
        System.out.println(game);

        do {

            if (game.getWinner().equals(player1) || game.getWinner().equals(player2)) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci riga per " + player + " (-1 per uscire):");
            row = in.nextInt();

            if (row == -1) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci colonna per " + player + ":");
            column = in.nextInt();

            if (row >= ROWS || column >= COLUMNS) {
                System.out.println("Combinazione non valida");
            } else {
                /* TODO */
            }

        } while (row < ROWS && column < COLUMNS);
    }
}