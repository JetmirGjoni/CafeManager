package model;

import java.util.ArrayList;

public interface TableSpecification{

    void addOrder(Item item);

    void removeOrder(Item item);

    void setOccupied();

    void setAvaliable();

    void setReserved();

    void setOrders(ArrayList<Item> orders);

    boolean isReserved();

    boolean isOccupied();

    boolean isAvaliable();

    ArrayList<Item> getOrder();

    double getTotalOrder();

    void setTotalOrder(double totalOrder);

    String getID();

}
