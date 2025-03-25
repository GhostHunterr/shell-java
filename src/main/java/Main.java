import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        boolean exitShell = false;

        while (!exitShell) {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input.trim();


            boolean validInput = false;
            String command = input.split("\\s+")[0];

            switch (command) {
                case "echo":
                    System.out.println(input.substring(input.indexOf(" ") + 1));
                    validInput = true;
                    break;
                case "exit":
                    String[] slicedInput = input.split("\\s+");
                    switch (slicedInput.length > 1 ? slicedInput[1] : "") {
                        case "0":
                            validInput = true;
                            exitShell = true;
                            break;
                    }
                    break;
            }

            if (!validInput) {
                System.out.println(input + ": command not found");
            }
        }
    }
}
