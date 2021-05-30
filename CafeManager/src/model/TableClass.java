package model;

import java.util.ArrayList;

public class TableClass implements TableSpecification{
    private final String ID;
    private double totalOrder;
    private boolean reserved;
    private boolean occupied;

    private ArrayList<Item> orders = new ArrayList<>();

    public TableClass(String ID){
        reserved = occupied = false;
        this.ID = ID;
    }

    public TableClass(String ID, ArrayList<Item> orders, boolean reserved, boolean occupied){
        this.occupied = occupied;
        this.reserved = reserved;
        this.ID = ID;
        this.orders = orders;
    }

    public void addOrder(Item item){
        orders.add(item);
        occupied = true;
        reserved = false;
        try{
            totalOrder += Double.parseDouble(item.getPrice());
        }catch (ArithmeticException ignored){

        }
    }

    public void removeOrder(Item item){
        orders.remove(item);
        if(orders.isEmpty()){
            occupied = false;
            reserved = false;
        }
        try{
            totalOrder -= Double.parseDouble(item.getPrice());
        }catch (ArithmeticException ignored){

        }
    }

    public void setOccupied(){
        occupied = true;
        reserved = false;
    }

    public void setAvaliable(){
        orders.clear();
        setTotalOrder(0.0);
        occupied = false;
        reserved = false;
    }

    public void setReserved(){
        orders.clear();
        setTotalOrder(0.0);
        reserved = true;
        occupied = false;
    }

    public void setOrders(ArrayList<Item> orders) {
        this.orders = orders;
    }

    public boolean isReserved(){
        return reserved;
    }

    public boolean isOccupied(){return occupied;}

    public boolean isAvaliable(){
        return ! (occupied || reserved);
    }

    public ArrayList<Item> getOrder(){
        return orders;
    }

    public double getTotalOrder(){
        return totalOrder;
    }

    public String getID(){
        return ID;
    }

    public void setTotalOrder(double totalOrder){
        this.totalOrder = totalOrder;
    }

}