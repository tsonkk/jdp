import java.util.List;

public class Customer implements Giaodien1 {
  private List<Order> orders;
  
  @Override
  public void gd1() {
    System.out.println("Thực hiện gd1() trong Customer");
  }
}