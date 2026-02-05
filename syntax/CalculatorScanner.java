import java.util.Scanner;

public class CalculatorScanner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number 1: ");
    int num1 = scanner.nextInt();
    System.out.print("Enter number 2: ");
    int num2 = scanner.nextInt();
    int sum = num1 + num2;
    int diff = num1 - num2;
    int prod = num1 * num2;
    double quot = (double)num1 / num2;
    System.out.printf("%d + %d = %d\n", num1, num2, sum);
    System.out.printf("%d - %d = %d\n", num1, num2, diff);
    System.out.printf("%d * %d = %d\n", num1, num2, prod);
    System.out.printf("%d / %d = %.2f\n", num1, num2, quot);
  }
}