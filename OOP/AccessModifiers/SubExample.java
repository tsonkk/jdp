package mine;

public class SubExample extends Example {
  public SubExample() {
    // System.out.println(privateNumber);   // not-accessible
    System.out.println(defaultNumber);   // accessible
    System.out.println(protectedNumber); // accessible
    System.out.println(publicNumber);    // accessible
  }
}