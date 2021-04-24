package Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author THAYCACAC
 */
public class Order {

    private String CustomerName;
    private ArrayList<Fruit> ListFruit;

    public Order() {
    }

    public Order(String CustomerName, ArrayList<Fruit> ListFruit) {
        this.CustomerName = CustomerName;
        this.ListFruit = ListFruit;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public ArrayList<Fruit> getListFruit() {
        return ListFruit;
    }

    public void setListFruit(ArrayList<Fruit> ListFruit) {
        this.ListFruit = ListFruit;
    }

    @Override
    public String toString() {
        return "Order{" + "CustomerName=" + CustomerName + ", ListFruit=" + ListFruit + '}';
    }
}
