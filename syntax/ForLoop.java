public class ForLoop {
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 5; i++) {
      System.out.println("i = " + i);
      sum += i;
    }
    System.out.println("Sum = " + sum);
  }
}