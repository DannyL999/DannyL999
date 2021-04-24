package Manager;

import Entity.Fruit;
import Entity.Order;
import Entity.OrderList;
import Entity.Store;
import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Manager {

    public Manager() {
    }

    //display menu
    public static int menu() {
        //loop until user want to exit
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //allow user create fruit
    static void createFruit(Store store) {
        ArrayList<Fruit> lf = getListStore(store);
        //loop until user don't want to create fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            store.setListFruit(lf);
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    //allow user show view order
    static void viewOrder(OrderList orderList) {
        ArrayList<Order> orders = getListOrder(orderList);
        for (Order order : orders) {
            String name = order.getCustomerName();
            ArrayList<Fruit> listOrder = getListFruitOrder(order);
            if (name == null) {
                System.err.println("");
            } else {
                System.out.println("Customer: " + name);
            }
            displayListOrder(listOrder);
        }
    }

    static ArrayList<Fruit> getListFruitOrder(Order order) {
        if (order.getListFruit() != null) {
            return order.getListFruit();
        } else {
            return new ArrayList<>();
        }
    }

    static ArrayList<Fruit> getListStore(Store store) {
        if (store.getListFruit() != null) {
            return store.getListFruit();
        } else {
            return new ArrayList<>();
        }
    }

    static ArrayList<Order> getListOrder(OrderList orderList) {
        if (orderList.getListOrders() != null) {
            return orderList.getListOrders();
        } else {
            return new ArrayList<>();
        }
    }

    /*
       allow user buy items
     */
    static void shopping(Order order, Store store, OrderList orderList) {
        ArrayList<Order> orders = getListOrder(orderList);
        ArrayList<Fruit> listFruit = getListStore(store);
        //check list empty user can't buy
        if (listFruit.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        //loop until user don't want to buy continue
        ArrayList<Fruit> listOrder = getListFruitOrder(order);

        while (true) {
            // display item in store
            displayListFruit(listFruit);
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, listFruit.size());
            Fruit fruit = getFruitByItem(listFruit, item);
            if (fruit == null) {
                System.out.println("No item!");
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //check item exist or not
            if (!Validation.checkIdExist(listOrder, fruit.getFruitId())) {
                System.out.println("on update");
                updateOrder(listOrder, fruit.getFruitId(), quantity);
            } else {
                System.out.println("on add");
                listOrder.add(new Fruit(fruit.getFruitId(), fruit.getFruitName(),
                        fruit.getPrice(), quantity));
            }
            order.setListFruit(listOrder);
            if (!Validation.checkInputYN()) {
                break;
            }
        }

        displayListOrder(listOrder);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        order.setCustomerName(name);
        System.err.println("Add successfull");
        orders.add(order);
        orderList.setListOrders(orders);
    }

    /*
        display list fruit in shop
     */
    static void displayListFruit(ArrayList<Fruit> listFruit) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : listFruit) {
            //check shop have item or not
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    /*
        get fruit user want to by
     */
    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    /*
        display list order
     */
    static void displayListOrder(ArrayList<Fruit> listFruit) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listFruit) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    /*if order exist then update order*/
    static void updateOrder(ArrayList<Fruit> listOrder, String id, int quantity) {
        for (Fruit fruit : listOrder) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                fruit.setQuantity(fruit.getQuantity() + quantity);
                return;
            }
        }
    }
}
