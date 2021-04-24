/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class OrderList {

    private ArrayList<Order> listOrders;

    public OrderList() {
    }

    public OrderList(ArrayList<Order> listOrders) {
        this.listOrders = listOrders;
    }

    public ArrayList<Order> getListOrders() {
        return listOrders;
    }

    public void setListOrders(ArrayList<Order> listOrders) {
        this.listOrders = listOrders;
    }

    @Override
    public String toString() {
        return "OrderList{" + "listOrders=" + listOrders + '}';
    }

}
