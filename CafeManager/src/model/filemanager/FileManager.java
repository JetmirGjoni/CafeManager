package model.filemanager;

import model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FileManager {
    private Properties prop;
    public FileManager(){
        prop = new Properties();
    }
    public void addParameter(String parameterName, String value){
        prop.put(parameterName, value);
    }

    public void clear(){
        prop.clear();
    }

    public void writeFile(String filename){
        try {
            prop.store(new FileOutputStream("resources/" + filename), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        clear();
    }

    public void writeWaiterFile(WaiterClass waiter){
        addParameter("id", waiter.getID());
        addParameter("firstName", waiter.getFirstName());
        addParameter("lastName", waiter.getLastName());
        addParameter("phoneNumber", waiter.getPhoneNumber());
        addParameter("address", waiter.getAddress());
        addParameter("email", waiter.getEmail());
        addParameter("password", waiter.getPassword());

        writeFile("waiter/" + waiter.getID() + ".waiter");//id
    }

    public void writeOrderFile(TableClass table){
        ArrayList<Item> orders = table.getOrder();
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i) instanceof DrinkClass)
                addParameter("item" + i, orders.get(i).getID() + ".drink");
            else if(orders.get(i) instanceof FoodClass){
                addParameter("item" + i, orders.get(i).getID() + ".food");
            }
        }
        addParameter("id", table.getID());
        addParameter("totalOrder", "" + table.getTotalOrder());
        addParameter("reserved", table.isReserved() + "");
        addParameter("taken", table.isOccupied() + "");
        writeFile("order/" + table.getID() + ".order");
    }

    public void writeDrinkFile(DrinkClass drink){
        addParameter("id",drink.getID());
        addParameter("drinkName", drink.getName());
        addParameter("drinkDescription", drink.getDescription());
        addParameter("drinkSize", drink.getSize());
        addParameter("drinkPrice", drink.getPrice());

        writeFile("drink/" + drink.getID() + ".drink");
    }

    public void writeFoodFile(FoodClass food){
        addParameter("id",food.getID());
        addParameter("foodName", food.getName());
        addParameter("foodDescription", food.getDescription());
        addParameter("foodSize", food.getSize());
        addParameter("foodPrice", food.getPrice());

        writeFile("food/" + food.getID() + ".food");
    }

    public void deleteWaiterFile(WaiterClass waiter){
        String fileName = "resources/waiter/" + waiter.getID() + ".waiter";
        deleteFile(fileName);
    }

    public void deleteFoodFile(FoodClass food){
        String fileName = "resources/food/" + food.getID() + ".food";
        deleteFile(fileName);
    }

    public void deleteDrinkFile(DrinkClass drink){
        String fileName = "resources/drink/" + drink.getID() + ".drink";
        deleteFile(fileName);
    }

    public void deleteTableFile(TableClass table){
        String fileName = "resources/order/" + table.getID() + ".order";
        deleteFile(fileName);
    }

    public void deleteFile(String fileName){
        try
        {
            File f = new File(fileName);
            f.delete();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}