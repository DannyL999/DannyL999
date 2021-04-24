/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Store {

    private ArrayList<Fruit> ListFruit;

    public Store() {
    }

    public Store(ArrayList<Fruit> ListFruit) {
        this.ListFruit = ListFruit;
    }

    public ArrayList<Fruit> getListFruit() {
        return ListFruit;
    }

    public void setListFruit(ArrayList<Fruit> ListFruit) {
        this.ListFruit = ListFruit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ListFruit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Store other = (Store) obj;
        if (!Objects.equals(this.ListFruit, other.ListFruit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Store{" + "ListFruit=" + ListFruit + '}';
    }

}
