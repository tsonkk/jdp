import java.util.List;

public class Order extends Truutuong1 implements Giaodien1 {
  private Customer cus;
  private List<OrderItem> items;
  
  @Override
  public void gd1() {
    System.out.println("Thực hiện gd1() trong Order");
  }
  
  @Override
  public void gd2() {
    System.out.println("Thực hiện gd2() trong Order");
  }
}