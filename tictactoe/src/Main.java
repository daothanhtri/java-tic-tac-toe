import java.util.Scanner;

public class Main {

    static Scanner in;
    static String[] board;
    static String currentPlayer;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        board = new String[9];
        currentPlayer = "X";
        initializeBoard();
        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();
        while (!gameOver()) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = in.nextInt();
            if (board[move-1].equals(String.valueOf(move))) {
                board[move-1] = currentPlayer;
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
                printBoard();
            } else {
                System.out.println("This slot is taken. Please enter another slot");
            }
        }
        if (whoWins().equals("X")) {
            System.out.println("Congratulations! Player X wins!");
        } else if (whoWins().equals("O")) {
            System.out.println("Congratulations! Player O wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i+1);
        }
    }

    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static boolean gameOver() {
        return (whoWins().equals("X") || whoWins().equals("O") || tie());
    }

    public static boolean tie() {
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(String.valueOf(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static String whoWins() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        return "";
    }
}