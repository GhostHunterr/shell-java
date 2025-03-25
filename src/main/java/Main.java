import java.util.*;

public class Main {

    private static boolean exitShell = false;

    private static Set<String> BUILTINS = Set.of("exit", "echo", "type");

    public static void main(String[] args) throws Exception {

        while (!exitShell) {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input.trim();

            boolean validInput = false;
            String[] slicedInput = input.toLowerCase().split("\\s+");

            switch (slicedInput[0]) {
                case "echo":
                    System.out.println(input.substring(input.indexOf(" ") + 1));
                    validInput = true;
                    break;

                case "exit":
                    switch (slicedInput.length > 1 ? slicedInput[1] : "") {
                        case "0":
                            validInput = true;
                            exitShell = true;
                            break;
                    }
                    break;
                    
                case "type":
                    if (slicedInput.length > 1 && BUILTINS.contains(slicedInput[1])) {
                        System.out.println(slicedInput[1] + " is a shell builtin");
                    } else if (slicedInput.length > 1) {
                        System.out.println(slicedInput[1] + ": not found");
                    } else {
                        System.out.println("Expected Arguments!");
                    }
                    validInput = true;
                    break;
            }

            if (!validInput) {
                System.out.println(input + ": command not found");
            }
        }
    }
}
