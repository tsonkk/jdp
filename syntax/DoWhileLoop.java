public class DoWhileLoop {
  public static void main(String[] args) {
    int sum = 0;
    int i = 1;
    do {
      System.out.println("i = " + i);
      sum += i;
      i++;
    } while (i <= 5);
    System.out.println("Sum = " + sum);
  }
}