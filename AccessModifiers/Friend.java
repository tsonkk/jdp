package mine;

public class Friend {
  public Friend() {
    Example example = new Example();
    // System.out.println(example.privateNumber);   // not-accessible
    System.out.println(example.defaultNumber);   // accessible
    System.out.println(example.protectedNumber); // accessible
    System.out.println(example.publicNumber);    // accessible
  }
}