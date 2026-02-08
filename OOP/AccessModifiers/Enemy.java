package yours;

import mine.Example;

public class Enemy {
  public Enemy() {
    Example example = new Example();
    // System.out.println(example.privateNumber);   // not-accessible
    // System.out.println(example.defaultNumber);   // not-accessible
    // System.out.println(example.protectedNumber); // not-accessible
    System.out.println(example.publicNumber);    // accessible
  }
}