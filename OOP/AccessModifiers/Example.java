package mine;

public class Example {
  private int privateNumber;
  int defaultNumber;
  protected int protectedNumber;
  public int publicNumber;
  
  public Example() {
    privateNumber = 1;   // accessible
    defaultNumber = 2;   // accessible
    protectedNumber = 3; // accessible
    publicNumber = 4;    // accessible
  }
}