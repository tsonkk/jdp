package yours;

import mine.Example;

public class SubEx extends Example {
  public SubEx() {
    // System.out.println(privateNumber);   // not-accessible
    // System.out.println(defaultNumber);   // not-accessible
    System.out.println(protectedNumber); // accessible
    System.out.println(publicNumber);    // accessible
  }
}