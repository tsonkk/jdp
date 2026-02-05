public class WhileLoop {
  public static void main(String[] args) {
    int sum = 0;
    int i = 1;
    while (i <= 5) {
      System.out.println("i = " + i);
      sum += i;
      i++;
    }
    System.out.println("Sum = " + sum);
  }
}