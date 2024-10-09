import java.util.Scanner;

public class InputChecker {

    public String checkInput(String input) {
        return switch (input) {
            case "S", "SI", "OK", "certo", "perché no?" -> "OK";
            case "N", "No" -> "Fine";
            default -> "Dato non corretto";
        };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Dammi l'input di verifica: ");
        String input = in.nextLine();

        InputChecker inputChecker = new InputChecker();
        System.out.println(inputChecker.checkInput(input));
    }
}