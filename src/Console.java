import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readnumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {

        while (true) {
            System.out.print(prompt);

            double value = scanner.nextDouble();

            if (value >= min && value <= max) {
                return value;
            }

            System.out.printf("Number of payments should be between %s and %s%n", (int) min, (int) max);
        }
    }

}
