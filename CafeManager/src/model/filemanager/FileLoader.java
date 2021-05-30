package model.filemanager;

import model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

public class FileLoader {
    Properties prop;

    public FileLoader() {
        prop = new Properties();
    }

    public ArrayList<WaiterSpecification> loadWaiters() {
        File[] waiterFiles = new Filter().finder( "resources/waiter" , ".waiter");
        ArrayList<WaiterSpecification> waiters = new ArrayList<>();
        for(File f: waiterFiles){
            waiters.add(getWaiter(removeExtension(f)));
        }
        return waiters;
    }

    public ArrayList<DrinkClass> loadDrinks() {
        File[] drinkFiles = new Filter().finder( "resources/drink" , ".drink");
        ArrayList<DrinkClass> drinks = new ArrayList<>();
        for(File f: drinkFiles){
            drinks.add(getDrink(removeExtension(f)));
        }
        return drinks;
    }

    public ArrayList<FoodClass> loadFoods() {
        File[] foodFiles = new Filter().finder( "resources/food" , ".food");
        ArrayList<FoodClass> foods = new ArrayList<>();
        for(File f: foodFiles){
            foods.add(getFood(removeExtension(f)));
        }
        return foods;
    }

    public ArrayList<TableSpecification> loadOrders() {
        File[] orders = new Filter().finder( "resources/order" , ".order");
        ArrayList<TableSpecification> tables = new ArrayList<>();
        for(File f: orders){
            tables.add(getOrder(removeExtension(f)));
        }
        return tables;
    }

    public WaiterClass getWaiter(String ID){
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("waiter/" + ID + ".waiter"));
        }catch(Exception eta){
            eta.printStackTrace();
        }
        String firstName , lastName , phoneNumber , address , email,id, password;
        id = prop.getProperty("id");
        firstName = prop.getProperty("firstName");
        lastName = prop.getProperty("lastName");
        phoneNumber = prop.getProperty("phoneNumber");
        address = prop.getProperty("address");
        email = prop.getProperty("email");
        password = prop.getProperty("password");

        return new WaiterClass(firstName, lastName, phoneNumber, address, email, id, password);
    }

    public TableClass getOrder(String tableID){
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("order/" + tableID + ".order"));
        }catch(Exception eta){
            eta.printStackTrace();
        }

        ArrayList<Item> orders = new ArrayList<>();
        for(String item: prop.stringPropertyNames()){
            String itemProperty = prop.getProperty(item);
            if( prop.getProperty(item).endsWith(".drink") )
                orders.add(getDrink(removeExtension(itemProperty)));
            else if(prop.getProperty(item).endsWith(".food"))
                orders.add(getFood(removeExtension(itemProperty)));
        }

        boolean reserved = prop.getProperty("reserved").equals("true");
        boolean taken = prop.getProperty("taken").equals("true");

        TableClass table = new TableClass(tableID, orders, reserved, taken);
        table.setTotalOrder(Double.parseDouble(prop.getProperty("totalOrder")));
        return table;
    }

    public DrinkClass getDrink(String drinkID){
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("drink/" + drinkID + ".drink"));
        }catch(Exception eta){
            eta.printStackTrace();
        }
        String drinkName, drinkDescription, drinkSize, drinkPrice, id;
        id = prop.getProperty("id");
        drinkName = prop.getProperty("drinkName");
        drinkDescription = prop.getProperty("drinkDescription");
        drinkPrice = prop.getProperty("drinkPrice");
        drinkSize = prop.getProperty("drinkSize");
        return new DrinkClass(drinkName, drinkDescription, drinkSize, drinkPrice, id);
    }

    public FoodClass getFood(String foodID){
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("food/" + foodID + ".food"));
        }catch(Exception eta){
            eta.printStackTrace();
        }
        String foodName, foodDescription, foodSize, foodPrice, id;
        id = prop.getProperty("id");
        foodName = prop.getProperty("foodName");
        foodDescription = prop.getProperty("foodDescription");
        foodPrice = prop.getProperty("foodPrice");
        foodSize = prop.getProperty("foodSize");
        return new FoodClass(foodName, foodDescription, foodSize, foodPrice, id);
    }

    private String removeExtension(File f){
        return f.getName().substring(0, f.getName().lastIndexOf('.'));
    }

    private String removeExtension(String f){
        return f.substring(0, f.lastIndexOf('.'));
    }
}