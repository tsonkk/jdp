import java.util.List;

public class Vip extends Customer {
  private List<Event> events;
  
  @Override
  public void gd1() {
    System.out.println("Thực hiện gd1() trong Vip");
  }
}