package Manager;

import Entity.Order;
import Entity.OrderList;
import Entity.Store;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
//        Manager manager = new Manager();
        OrderList orderList = new OrderList();
        Store store = new Store();
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createFruit(store);
                    break;
                case 2:
                    Manager.viewOrder(orderList);
                    break;
                case 3:
                    Manager.shopping(new Order(), store, orderList);
                    break;
                case 4:
                    return;
            }
        }
    }

}
