import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input = input.trim();

            if (input.startsWith("exit")) {
                String code = input.split("\\s+")[1];
                switch (code) {
                    case "1":
                        break;
                    default:
                        System.out.println("Invalid Status Code!");
                }
                break;
            }
            System.out.println(input + ": command not found");
        }
    }
}
