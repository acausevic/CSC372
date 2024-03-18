import java.util.Scanner;

public class RecursiveExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five numbers:");

        double[] numbers = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        double product = calculateProduct(numbers);
        System.out.println("The product of the five numbers is: " + product);

        scanner.close();
    }

    public static double calculateProduct(double[] numbers) {
        return calculateProductHelper(numbers, 0);
    }

    private static double calculateProductHelper(double[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }
        return numbers[index] * calculateProductHelper(numbers, index + 1);
    }
}
