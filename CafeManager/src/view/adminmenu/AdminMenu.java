package view.adminmenu;

import model.*;
import model.filemanager.FileManager;
import view.customcomponents.Butonat;
import view.customcomponents.FushatETekstit;
import view.customcomponents.Labelat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMenu extends JFrame implements ActionListener {

    public Butonat butonat = new Butonat();
    public Labelat labelat = new Labelat();
    public FushatETekstit fushatETekstit = new FushatETekstit();
    public String foodNameText ,tableIdText, foodDescriptionText , foodSizeText , foodPriceText , drinkNameText , drinkDescriptionText , drinkSizeText , drinkPriceText,
                  firstNameText,waiterPasswordText ,drinkIDtext,waiterIDtext, lastNameText , phoneNumberText , addresText  , emailText,foodIDtext;

    JButton addWaiterButton ,removeWaiterButton,addTableButton,removeTableButton,addDrinkButton,removeDrinkButton, editDrinkButton,
            addFoodButton,removeFoodButton,editFoodButton, addButton,saveButtonW,saveButtonF,saveButtonD,cancelButtonW,saveButton,cancelButton,
            returnButton, okButton,saveButtonT,saveButtonEditFood,saveButtonEditDrink,editWaiterButton,saveEditedWatierButton,logOutButton ;


    JTextField foodNameField,foodDescriptionField,foodSizeField,foodPriceField, drinkNameField,drinkDescriptionNameField,
               drinkSizeField,drinkPriceField,firstNameField,lastNameField, phoneNumberField,addresField,emailField,waiterIDField,
               waiterPasswordField,drinkIdField,foodIDField,tableIDField;


    public Container mainContainer;
    public static ArrayList<FoodClass> foods;
    public static ArrayList<DrinkClass> drinks;
    public static ArrayList<WaiterSpecification> waiters;
    public static ArrayList<TableSpecification> tables;
    public static ArrayList<JButton> removeFoodButtons = new ArrayList<>();
    public static ArrayList<JButton> removeFoodButtonsController = new ArrayList<>();
    public static ArrayList<JButton> removeDrinkButtons = new ArrayList<>();
    public static ArrayList<JButton> removeDrinkButtonsController = new ArrayList<>();
    public static ArrayList<JButton> removeWaiterButtons = new ArrayList<>();
    public static ArrayList<JButton> removeWaiterButtonsController= new ArrayList<>();
    public static ArrayList<JButton> editFoodButtons = new ArrayList<>();
    public static ArrayList<JButton> editFoodButtonsController = new ArrayList<>();
    public static ArrayList<JButton> editDrinkButtons = new ArrayList<>();
    public static ArrayList<JButton> editDrinkButtonsController = new ArrayList<>();
    public static ArrayList<JButton> removeTableButtons = new ArrayList<>();
    public static ArrayList<JButton> removeTableButtonsController = new ArrayList<>();
    public static ArrayList<JButton> editWaiterButtons = new ArrayList<>();
    public static ArrayList<JButton> editwaiterButtonsController = new ArrayList<>();

    public static FoodClass editedFood;
    public static DrinkClass editedDrink;
    public static WaiterClass editedWaiter;

    private final FileManager fileEditor;


    public AdminMenu(ArrayList<WaiterSpecification> waiters, ArrayList<TableSpecification> tables, ArrayList<FoodClass> foods, ArrayList<DrinkClass> drinks) {

        initButtons();
        initFields();
        this.foods = foods;
        this.tables = tables;
        this.waiters = waiters;
        this.drinks = drinks;

        fileEditor = new FileManager();
        mainContainer = adminContainer();
        actionListenerAdder();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initButtons(){

        addWaiterButton = butonat.addWaiter(350,250,120,30);
        removeWaiterButton = butonat.removeWaiter(350,290,120,30);
        addTableButton =  butonat.addtable(10 , 250 , 120 ,30);
        removeTableButton =butonat.removeTable(10,290 , 120 ,30);
        addDrinkButton = butonat.addDrink(350,50,120,30);
        removeDrinkButton = butonat.removeDrink(350, 90 , 120,30);
        editDrinkButton = butonat.editDrink(350,130,120 ,30);
        addFoodButton = butonat.addFood(10 , 50,120,30);
        removeFoodButton = butonat.removeFood(10,90 , 120,30);
        editFoodButton = butonat.editFood(10, 130 , 120 ,30);
        addButton =     butonat.addButton(150,180,100,30);
        saveButtonW =butonat.saveButton(50,270,80,30);
        saveButtonF =butonat.saveButton(50,220,80,30);
        saveButtonD =butonat.saveButton(50,220,80,30);
        cancelButtonW = butonat.cancelButton(140,250,80,30);
        saveButton = butonat.saveButton(70,55,80,30);
        cancelButton  = butonat.cancelButton(160,55,80,30);
        returnButton = butonat.returnButton(0,0,80,30);
        okButton = butonat.okButton(50,70,80,30);
        saveButtonT = butonat.saveButton(50,150,80,30);
        saveButtonEditFood = butonat.saveButton(100,220,80,30);
        saveButtonEditDrink = butonat.saveButton(100,220,80,30);
        editWaiterButton = butonat.editWaiterButton(350,330,120,30);
        saveEditedWatierButton = butonat.saveButton(100,270,80,30);


    }

    public void initFields(){

        foodNameField = fushatETekstit.foodName(130,50,150,25);
        foodDescriptionField =fushatETekstit.foodDescription(130,80,150,25);
        foodSizeField =fushatETekstit.foodSize(130,110,150,25);
        foodPriceField = fushatETekstit.foodPrice(130,140,150,25);
        drinkNameField= fushatETekstit.drinkName(130,50,150,25);
        drinkDescriptionNameField = fushatETekstit.drinkDescription(130,80,150,25);
        drinkSizeField = fushatETekstit.drinkSize(130,110,150,25);
        drinkPriceField = fushatETekstit.drinkPrice(130,140,150,25);
        firstNameField = fushatETekstit.firstNameField(110,50,150,25);
        lastNameField = fushatETekstit.lastNameField(110,80,150,25);
        phoneNumberField = fushatETekstit.phoneNumberField(110,110,150,25);
        addresField  = fushatETekstit.addressField(110,140,150,25);
        emailField = fushatETekstit.emailField(110,170,150,25);
        waiterIDField = fushatETekstit.waiterIDField(110,200,150,25);
        waiterPasswordField = fushatETekstit.waiterPasswod(110,230,150,25);
        drinkIdField = fushatETekstit.drinkIDField(130,170,150,25);
        foodIDField = fushatETekstit.foodIDField(130,170,150,25);
        tableIDField = fushatETekstit.tableID(60,50,150,25);

    }


    public void actionListenerAdder(){
         addWaiterButton.addActionListener(this);
         removeWaiterButton.addActionListener(this);
         addTableButton.addActionListener(this);
         removeTableButton.addActionListener(this);
         addDrinkButton.addActionListener(this);
         removeDrinkButton.addActionListener(this);
         editDrinkButton.addActionListener(this);
         addFoodButton.addActionListener(this);
         removeFoodButton.addActionListener(this);
         editFoodButton.addActionListener(this);
         addButton.addActionListener(this);
         saveButtonW.addActionListener(this);
         saveButtonF.addActionListener(this);
         saveButtonD.addActionListener(this);
         cancelButtonW.addActionListener(this);
         saveButton.addActionListener(this);
         cancelButton.addActionListener(this);
         returnButton.addActionListener(this);
         okButton.addActionListener(this);
         saveButtonEditFood.addActionListener(this);
        saveButtonT.addActionListener(this);
        saveButtonEditDrink.addActionListener(this);
        editWaiterButton.addActionListener(this);
        saveEditedWatierButton.addActionListener(this);

         foodNameField.addActionListener(this);
         foodDescriptionField.addActionListener(this);
         foodSizeField.addActionListener(this);
         foodPriceField.addActionListener(this);
         drinkNameField.addActionListener(this);
         drinkDescriptionNameField.addActionListener(this);
         drinkSizeField.addActionListener(this);
         drinkPriceField.addActionListener(this);
         firstNameField.addActionListener(this);
         lastNameField.addActionListener(this);
         phoneNumberField.addActionListener(this);
         addresField.addActionListener(this);
         emailField.addActionListener(this);
         waiterIDField.addActionListener(this);
         drinkIdField.addActionListener(this);
         foodIDField.addActionListener(this);
        tableIDField.addActionListener(this);
        waiterPasswordField.addActionListener(this);
    }

    public Container adminContainer() {
        Container adminContainer = getContentPane();
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafe Management: Admin Menu");
        setLayout(null);

        adminContainer.add(labelat.waiterSettings(370,220,120,30));
        adminContainer.add(addWaiterButton);
        adminContainer.add(removeWaiterButton);
        adminContainer.add(labelat.tableSettings(30,220,120,30));
        adminContainer.add(addTableButton);
        adminContainer.add(removeTableButton);
        adminContainer.add(addDrinkButton);
        adminContainer.add(removeDrinkButton);
        adminContainer.add(editDrinkButton);
        adminContainer.add(labelat.drinksSettings(370 , 20,120,30));
        adminContainer.add(addFoodButton);
        adminContainer.add(editFoodButton);
        adminContainer.add(removeFoodButton);
        adminContainer.add(labelat.foodSettings(30,20, 120 ,30));
        adminContainer.add(editWaiterButton);
        adminContainer.add(labelat.emptyLabel(1,1,1,1));
        logOutButton = new JButton("Log Out");
        logOutButton.setBounds(10,330 , 120 ,30);
        logOutButton.addActionListener(this);
        logOutButton.setBackground(Color.red);
        adminContainer.add(logOutButton);

        return adminContainer;
    }

    ////////////////////////////////////////FOOD
    public Container addFood() {
        Container addFoodContainer = new Container();
        setSize(300,300);
        setTitle("Add Food");
        addFoodContainer.add(returnButton);
        addFoodContainer.add(foodNameField);
        addFoodContainer.add(labelat.addFood(10,50,120,30));
        addFoodContainer.add(foodDescriptionField);
        addFoodContainer.add(labelat.addFoodDescription(10,80 , 120, 30));
        addFoodContainer.add(foodSizeField);
        addFoodContainer.add(labelat.addFoodSize(10,110, 120,30));
        addFoodContainer.add(foodPriceField);
        addFoodContainer.add(labelat.addFoodPrice(10,140,120,30));
        addFoodContainer.add(labelat.foodIdLabel(10,170,120,30));
        addFoodContainer.add(foodIDField);
        addFoodContainer.add(saveButtonF);
        cancelButtonW.setBounds(140,220,80,30);
        addFoodContainer.add(cancelButtonW);
        addFoodContainer.add(labelat.emptyLabel(1,1,1,1));

        return addFoodContainer;
    }

    public Container editFoodContainer() {
        return itemContainer(editFoodButtons, editFoodButtonsController, "Edit Food");
    }

    public Container removeFoodContainer() {
        return itemContainer(removeFoodButtons, removeFoodButtonsController, "Remove Food");
    }

    public Container itemContainer(ArrayList<JButton> itemList, ArrayList<JButton> itemListController, String windowTitle) {
        setSize(300, 350);
        setTitle(windowTitle);
        JPanel pnMainPanel;

        JPanel itemPanel;
        JButton btReturnButton;

        pnMainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout(gbMainPanel);

        itemPanel = new JPanel();
        GridBagLayout gbItemPanel = new GridBagLayout();
        GridBagConstraints gbcItemPanel = new GridBagConstraints();
        itemPanel.setLayout(gbItemPanel);

        JScrollPane scpPanel1 = new JScrollPane(itemPanel);
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 1;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints(scpPanel1, gbcMainPanel);
        pnMainPanel.add(scpPanel1);

        btReturnButton = returnButton;
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 0;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTHWEST;
        gbMainPanel.setConstraints(btReturnButton, gbcMainPanel);
        pnMainPanel.add(btReturnButton);

        gbcItemPanel.gridx = 0;
        gbcItemPanel.gridy = 0;
        gbcItemPanel.gridwidth = 1;
        gbcItemPanel.gridheight = 1;
        gbcItemPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcItemPanel.weightx = 1;
        gbcItemPanel.weighty = 0;
        gbcItemPanel.anchor = GridBagConstraints.NORTH;

        for (JButton i : itemList) {
            if (!itemListController.contains(i)) {
                itemListController.add(i);
                gbItemPanel.setConstraints(i, gbcItemPanel);
                i.addActionListener(this);
                itemPanel.add(i);
                gbcItemPanel.gridy += 1;
            }
        }

        return (Container) new Container().add(pnMainPanel);
    }

    public Container itemAddedTab() {
        Container foodAddedTab = getContentPane();
        setSize(230, 140);
        setTitle("Success");
        foodAddedTab.add(okButton);
        foodAddedTab.add(labelat.foodAddedLabel(30,5,270,50));
        foodAddedTab.add(labelat.emptyLabel(1,1,1,1));

        return foodAddedTab;
    }

    public void addFoodItem() {
        FoodClass food = new FoodClass(foodNameText, foodDescriptionText, foodSizeText, foodPriceText, foodIDtext);
        fileEditor.writeFoodFile(food);
        foods.add(food);
        clearFoodParametes();
    }

    public void clearFoodParametes() {
        foodNameText = foodDescriptionText = foodSizeText = foodPriceText = foodIDtext = null;
        foodNameField.setText(null);
        foodSizeField.setText(null);
        foodDescriptionField.setText(null);
        foodPriceField.setText(null);
        foodIDField.setText(null);
        editedFood = null;
    }

    public Container editingFoodItem(FoodClass food) {
        Container addFoodContainer = new Container();
        addFoodContainer.setLayout(null);
        setSize(300, 300);
        setTitle("Editing Food");
        foodNameField.setText(food.getName());
        foodDescriptionField.setText(food.getDescription());
        foodSizeField.setText(food.getSize());
        foodPriceField.setText(food.getPrice());

        addFoodContainer.add(returnButton);
        addFoodContainer.add(foodNameField);
        addFoodContainer.add(labelat.addFood(10, 50, 120, 30));
        addFoodContainer.add(foodDescriptionField);
        addFoodContainer.add(labelat.addFoodDescription(10, 80, 120, 30));
        addFoodContainer.add(foodSizeField);
        addFoodContainer.add(labelat.addFoodSize(10, 110, 120, 30));
        addFoodContainer.add(foodPriceField);
        addFoodContainer.add(labelat.addFoodPrice(10, 140, 120, 30));
        addFoodContainer.add(labelat.foodIdLabel(10, 170, 120, 30));
        addFoodContainer.add(labelat.customLabel(130, 170, 120, 30, food.getID()));
        addFoodContainer.add(saveButtonEditFood);
        cancelButtonW.setBounds(140, 220, 80, 30);
        addFoodContainer.add(labelat.emptyLabel(1, 1, 1, 1));

        editedFood = food;
        return addFoodContainer;
    }

    public void removeFoodItem(int index) {
        foods.remove(index);
    }

    public void editFood(FoodClass food) {
        food.setName(foodNameText);
        food.setDescription(foodDescriptionText);
        food.setSize(foodSizeText);
        food.setPrice(foodPriceText);
        fileEditor.writeFoodFile(food);
        clearFoodParametes();
    }

    ///////////////////////////////////////////////////////DRINKS
    public Container addDrink() {
        Container addDrinkContainer = getContentPane();
        setSize(300, 300);
        setTitle("Add Drink");

        addDrinkContainer.add(returnButton);
        addDrinkContainer.add(drinkNameField);
        addDrinkContainer.add(labelat.addDrink(10, 50, 120, 30));
        addDrinkContainer.add(drinkDescriptionNameField);
        addDrinkContainer.add(labelat.addDrinkDescription(10, 80, 120, 30));
        addDrinkContainer.add(drinkSizeField);
        addDrinkContainer.add(labelat.addDrinkSize(10, 110, 120, 30));
        addDrinkContainer.add(drinkPriceField);
        addDrinkContainer.add(labelat.addDrinkPrice(10, 140, 120, 30));
        addDrinkContainer.add(labelat.drinkIdLabel(10, 170, 120, 30));
        addDrinkContainer.add(drinkIdField);
        addDrinkContainer.add(saveButtonD);
        cancelButtonW.setBounds(140, 220, 80, 30);
        addDrinkContainer.add(cancelButtonW);
        addDrinkContainer.add(labelat.emptyLabel(1, 1, 1, 1));

        return addDrinkContainer;
    }

    public Container editDrinkContainer() {
        return itemContainer(editDrinkButtons, editDrinkButtonsController, "Edit Drink");
    }

    public Container removeDrinkContainer() {
        return itemContainer(removeDrinkButtons, removeDrinkButtonsController, "Remove Drink");
    }

    public Container editingDrinkItem(DrinkClass drink) {
        Container addDrinkContainer = getContentPane();
        addDrinkContainer.setLayout(null);
        setSize(300, 300);
        setTitle("Edit Drink");
        drinkNameField.setText(drink.getName());
        drinkDescriptionNameField.setText(drink.getDescription());
        drinkSizeField.setText(drink.getSize());
        drinkPriceField.setText(drink.getPrice());

        addDrinkContainer.add(returnButton);
        addDrinkContainer.add(drinkNameField);
        addDrinkContainer.add(labelat.addDrink(10, 50, 120, 30));
        addDrinkContainer.add(drinkDescriptionNameField);
        addDrinkContainer.add(labelat.addDrinkDescription(10, 80, 120, 30));
        addDrinkContainer.add(drinkSizeField);
        addDrinkContainer.add(labelat.addDrinkSize(10, 110, 120, 30));
        addDrinkContainer.add(drinkPriceField);
        addDrinkContainer.add(labelat.addDrinkPrice(10, 140, 120, 30));
        addDrinkContainer.add(labelat.drinkIdLabel(10, 170, 120, 30));
        addDrinkContainer.add(labelat.customLabel(130, 170, 120, 30, drink.getID()));
        addDrinkContainer.add(saveButtonEditDrink);
        cancelButtonW.setBounds(140, 220, 80, 30);

        addDrinkContainer.add(labelat.emptyLabel(1, 1, 1, 1));
        editedDrink = drink;
        return addDrinkContainer;
    }

    public void addDrinkItem() {
        DrinkClass drink = new DrinkClass(drinkNameText, drinkDescriptionText, drinkSizeText, drinkPriceText, drinkIDtext);
        fileEditor.writeDrinkFile(drink);
        drinks.add(drink);
        clearDrinkParameters();
    }

    public void editDrink(DrinkClass drink) {
        drink.setName(drinkNameText);
        drink.setDescription(drinkDescriptionText);
        drink.setSize(drinkSizeText);
        drink.setPrice(drinkPriceText);
        clearDrinkParameters();
    }

    public void clearDrinkParameters() {
        drinkNameText = drinkDescriptionText = drinkSizeText = drinkPriceText = drinkIDtext = null;
        drinkNameField.setText(null);
        drinkDescriptionNameField.setText(null);
        drinkSizeField.setText(null);
        drinkPriceField.setText(null);
        drinkIdField.setText(null);
        editedDrink = null;
    }

    public void removeDrinkItem(int index) {
        drinks.remove(index);
    }

    ////////////////////////////////////////////WAITER
    public Container addWaiter() {
        Container addWaiterContainer = getContentPane();
        setSize(300, 370);
        setTitle("Add Waiter");

        addWaiterContainer.add(returnButton);
        addWaiterContainer.add(firstNameField);
        addWaiterContainer.add(labelat.nameLabel(10, 50, 120, 30));
        addWaiterContainer.add(labelat.lastNameLabel(10, 80, 120, 30));
        addWaiterContainer.add(lastNameField);
        addWaiterContainer.add(labelat.phoneNumberLabel(10, 110, 120, 30));
        addWaiterContainer.add(phoneNumberField);
        addWaiterContainer.add(labelat.addressLabel(10, 140, 120, 30));
        addWaiterContainer.add(addresField);
        addWaiterContainer.add(labelat.emailLabel(10, 170, 120, 30));
        addWaiterContainer.add(emailField);
        addWaiterContainer.add(labelat.waiterIdLabel(10, 200, 120, 30));
        addWaiterContainer.add(waiterIDField);
        addWaiterContainer.add(saveButtonW);
        addWaiterContainer.add(labelat.password(10, 230, 120, 30));
        addWaiterContainer.add(waiterPasswordField);
        cancelButtonW.setBounds(140, 270, 80, 30);
        addWaiterContainer.add(cancelButtonW);
        addWaiterContainer.add(labelat.emptyLabel(1, 1, 1, 1));

        return addWaiterContainer;
    }

    public Container removeWaiterContainer() {
        return itemContainer(removeWaiterButtons, removeWaiterButtonsController, "Remove Waiter");
    }

    public Container editWaiterContainer() {
        return itemContainer(editWaiterButtons, editwaiterButtonsController, "Edit Waiter");
    }

    public Container editingWaiterContainer(WaiterClass waiter) {
        Container addWaiterContainer = getContentPane();
        addWaiterContainer.setLayout(null);
        setSize(300, 370);
        setTitle("Edit Waiter");
        firstNameField.setText(waiter.getFirstName());
        lastNameField.setText(waiter.getLastName());
        phoneNumberField.setText(waiter.getPhoneNumber());
        addresField.setText(waiter.getAddress());
        emailField.setText(waiter.getEmail());
        waiterPasswordField.setText(waiter.getPassword());

        addWaiterContainer.add(returnButton);
        addWaiterContainer.add(firstNameField);
        addWaiterContainer.add(labelat.nameLabel(10, 50, 120, 30));
        addWaiterContainer.add(labelat.lastNameLabel(10, 80, 120, 30));
        addWaiterContainer.add(lastNameField);
        addWaiterContainer.add(labelat.phoneNumberLabel(10, 110, 120, 30));
        addWaiterContainer.add(phoneNumberField);
        addWaiterContainer.add(labelat.addressLabel(10, 140, 120, 30));
        addWaiterContainer.add(addresField);
        addWaiterContainer.add(labelat.emailLabel(10, 170, 120, 30));
        addWaiterContainer.add(emailField);
        addWaiterContainer.add(labelat.waiterIdLabel(10, 200, 120, 30));
        addWaiterContainer.add(labelat.customLabel(110, 200, 120, 30, waiter.getID()));
        addWaiterContainer.add(saveEditedWatierButton);
        addWaiterContainer.add(labelat.password(10, 230, 120, 30));
        addWaiterContainer.add(waiterPasswordField);
        cancelButtonW.setBounds(140, 270, 80, 30);
        addWaiterContainer.add(labelat.emptyLabel(1, 1, 1, 1));

        editedWaiter = waiter;
        return addWaiterContainer;
    }

    public void editWaiter(WaiterClass waiter) {
        waiter.setFirstName(firstNameText);
        waiter.setLastName(lastNameText);
        waiter.setAddress(addresText);
        waiter.setEmail(emailText);
        waiter.setPhoneNumber(phoneNumberText);
        waiter.setPassword(waiterPasswordText);
        fileEditor.writeWaiterFile(waiter);
        clearWaiterParameters();
    }

    public void addWaiterItem() {
        WaiterClass waiter = new WaiterClass(firstNameText, lastNameText, phoneNumberText, addresText, emailText, waiterIDtext, waiterPasswordText);
        fileEditor.writeWaiterFile(waiter);
        waiters.add(waiter);
        clearWaiterParameters();
    }

    public void clearWaiterParameters() {
        firstNameText = lastNameText = phoneNumberText = addresText = emailText = waiterIDtext = waiterPasswordText = null;
        firstNameField.setText(null);
        lastNameField.setText(null);
        phoneNumberField.setText(null);
        addresField.setText(null);
        emailField.setText(null);
        waiterIDField.setText(null);
        waiterPasswordField.setText(null);
        editedWaiter = null;
    }

    public void removeWaiterItem(int index) {
        waiters.remove(index);
    }

    ////////////////////////////////////////////////////////
    public Container addTable() {
        Container container = getContentPane();
        setSize(300, 250);
        setTitle("Add Table");
        container.add(returnButton);
        container.add(labelat.tableIdLbel(10, 50, 120, 30));
        container.add(saveButtonT);
        container.add(tableIDField);
        cancelButtonW.setBounds(150, 150, 80, 30);
        container.add(cancelButtonW);
        container.add(labelat.emptyLabel(1, 1, 1, 1));

        return container;
    }

    public Container removeTableContainer() {
        return itemContainer(removeTableButtons, removeTableButtonsController, "Remove Table");
    }

    public void addTableItem() {
        TableClass table = new TableClass(tableIdText);
        fileEditor.writeOrderFile(table);
        tables.add(table);
        clearTableParameters();
    }

    public void removeTableItem(int index) {
        tables.remove(index);
    }

    public void clearTableParameters() {
        tableIdText = null;
        tableIDField.setText(null);
    }

    /////////////////////////////////
    public void clearAllParameters() {
        clearFoodParametes();
        clearDrinkParameters();
        clearWaiterParameters();
        clearTableParameters();
    }

    public Container itemRemovedTab() {
        Container foodAddedTab = getContentPane();
        setSize(220, 140);
        setTitle("Success");
        foodAddedTab.add(okButton);
        foodAddedTab.add(labelat.itemRemoved(30, 5, 270, 50));
        foodAddedTab.add(labelat.emptyLabel(1, 1, 1, 1));
        return foodAddedTab;
    }

    public Container itemEditedTab() {
        Container itemEditedTab = getContentPane();
        setSize(220, 140);
        setTitle("Success");
        itemEditedTab.add(okButton);
        itemEditedTab.add(labelat.customLabel(30, 5, 270, 50, "Item updated successfully!"));
        itemEditedTab.add(labelat.emptyLabel(1, 1, 1, 1));

        return itemEditedTab;
    }

    public boolean foodIdChecker() {
        boolean checker = false;

        for (FoodClass i : foods) {
            if (i.getID().equals(foodIDtext)) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    public boolean drinkIdChecker() {
        boolean checker = false;
        for (DrinkClass i : drinks) {
            if (i.getID().equals(drinkIDtext)) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    public boolean tableIdChecker() {
        boolean checker = false;
        for (TableSpecification i : tables) {
            if (i.getID().equals(tableIdText)) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    public boolean waiterIdChecker() {
        boolean checker = false;
        for (WaiterSpecification i : waiters) {
            if (i.getID().equals(waiterIDtext)) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == returnButton || e.getSource() == okButton) {
            getContentPane().removeAll();
            setContentPane(adminContainer());
            clearAllParameters();
        }
        if (e.getSource() == logOutButton) {
            dispose();
            new StartUpPanel();
        }
        if (e.getSource() == addWaiterButton) {
            getContentPane().removeAll();
            setContentPane(addWaiter());
        }

        if (e.getSource() == removeWaiterButton) {
            for (WaiterSpecification i : waiters) {
                removeWaiterButtons.add(new JButton(i.getFirstName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(removeWaiterContainer());
        }
        for (JButton i : removeWaiterButtons) {
            if (e.getSource() == i) {
                for (int w = 0; w < waiters.size(); w++) {
                    if (i.getText().equals(waiters.get(w).getFirstName() + ":" + waiters.get(w).getID())) {
                        fileEditor.deleteWaiterFile((WaiterClass) waiters.get(w));
                        removeWaiterItem(waiters.indexOf(waiters.get(w)));
                        getContentPane().removeAll();
                        setContentPane(itemRemovedTab());
                    }
                }
            }
        }

        if (e.getSource() == editWaiterButton) {
            for (WaiterSpecification i : waiters) {
                editWaiterButtons.add(new JButton(i.getFirstName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(editWaiterContainer());
        }

        for (JButton i : editWaiterButtons) {
            if (e.getSource() == i) {
                for (WaiterSpecification waiter : waiters) {
                    if (i.getText().equals(waiter.getFirstName() + ":" + waiter.getID())) {
                        getContentPane().removeAll();
                        setContentPane(editingWaiterContainer((WaiterClass) waiter));
                    }
                }
            }
        }

        if (e.getSource() == saveEditedWatierButton) {
            firstNameText = firstNameField.getText();
            lastNameText = lastNameField.getText();
            phoneNumberText = phoneNumberField.getText();
            addresText = addresField.getText();
            emailText = emailField.getText();
            waiterPasswordText = waiterPasswordField.getText();

            if (!(firstNameText.trim().isEmpty() || lastNameText.trim().isEmpty() || phoneNumberText.trim().isEmpty() || addresText.trim().isEmpty() || emailText.trim().isEmpty() || waiterPasswordText.trim().isEmpty())) {
                editWaiter(editedWaiter);
                getContentPane().removeAll();
                setContentPane(itemEditedTab());
            }
        }

        if (e.getSource() == addTableButton) {
            getContentPane().removeAll();
            setContentPane(addTable());
        }
        if (e.getSource() == removeTableButton) {
            for (TableSpecification i : tables) {
                removeTableButtons.add(new JButton(i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(removeTableContainer());
        }

        for (JButton i : removeTableButtons) {
            if (e.getSource() == i) {
                for (int d = 0; d < tables.size(); d++) {
                    if (i.getText().equals(tables.get(d).getID())) {
                        fileEditor.deleteTableFile((TableClass) tables.get(d));
                        removeTableItem(tables.indexOf(tables.get(d)));
                        getContentPane().removeAll();
                        setContentPane(itemRemovedTab());
                    }
                }
            }
        }

        if (e.getSource() == saveButtonT) {
            tableIdText = tableIDField.getText();
            if (!(tableIdText.trim().isEmpty())) {
                if (tableIdChecker()) {
                    JOptionPane.showMessageDialog(null, "That ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    tableIDField.setText(null);
                } else {
                    addTableItem();
                    getContentPane().removeAll();
                    setContentPane(itemAddedTab());
                }
            }
        }

        if (e.getSource() == addDrinkButton) {
            getContentPane().removeAll();
            setContentPane(addDrink());
        }
        if (e.getSource() == removeDrinkButton) {
            for (DrinkClass i : drinks) {
                removeDrinkButtons.add(new JButton(i.getName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(new JScrollPane(removeDrinkContainer()));
        }

        for (JButton i : removeDrinkButtons) {
            if (e.getSource() == i) {
                for (int d = 0; d < drinks.size(); d++) {
                    if (i.getText().equals(drinks.get(d).getName() + ":" + drinks.get(d).getID())) {
                        fileEditor.deleteDrinkFile(drinks.get(d));
                        removeDrinkItem(drinks.indexOf(drinks.get(d)));
                        getContentPane().removeAll();
                        setContentPane(itemRemovedTab());
                    }
                }
            }
        }

        if (e.getSource() == editDrinkButton) {
            for (DrinkClass i : drinks) {
                editDrinkButtons.add(new JButton(i.getName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(editDrinkContainer());
        }

        for (JButton i : editDrinkButtons) {
            if (e.getSource() == i) {
                for (DrinkClass drink : drinks) {
                    if (i.getText().equals(drink.getName() + ":" + drink.getID())) {
                        getContentPane().removeAll();
                        setContentPane(editingDrinkItem(drink));
                    }
                }
            }
        }

        if (e.getSource() == saveButtonEditDrink) {
            drinkNameText = drinkNameField.getText();
            drinkDescriptionText = drinkDescriptionNameField.getText();
            drinkSizeText = drinkSizeField.getText();
            drinkPriceText = drinkPriceField.getText();
            drinkIDtext = drinkIdField.getText();
            if (!(drinkNameText.trim().isEmpty() || drinkDescriptionText.trim().isEmpty() || drinkSizeText.trim().isEmpty() || drinkPriceText.trim().isEmpty())) {
                editDrink(editedDrink);
                getContentPane().removeAll();
                setContentPane(itemEditedTab());
            }
        }

        if (e.getSource() == addFoodButton) {
            getContentPane().removeAll();
            setContentPane(addFood());
        }
        if (e.getSource() == removeFoodButton) {
            for (FoodClass i : foods) {
                removeFoodButtons.add(new JButton(i.getName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(removeFoodContainer());
        }

        for (JButton i : removeFoodButtons) {
            if (e.getSource() == i) {
                for (int fc = 0; fc < foods.size(); fc++) {
                    if (i.getText().equals(foods.get(fc).name + ":" + foods.get(fc).getID())) {
                        fileEditor.deleteFoodFile(foods.get(fc));
                        removeFoodItem(foods.indexOf(foods.get(fc)));
                        getContentPane().removeAll();
                        setContentPane(itemRemovedTab());
                    }
                }
            }
        }

        for (JButton i : editFoodButtons) {
            if (e.getSource() == i) {
                for (FoodClass food : foods) {
                    if (i.getText().equals(food.getName() + ":" + food.getID())) {
                        getContentPane().removeAll();
                        setContentPane(editingFoodItem(food));
                    }
                }
            }
        }

        if (e.getSource() == saveButtonEditFood) {
            foodNameText = foodNameField.getText();
            foodDescriptionText = foodDescriptionField.getText();
            foodSizeText = foodSizeField.getText();
            foodPriceText = foodPriceField.getText();
            if (!(foodNameText.trim().isEmpty() || foodDescriptionText.trim().isEmpty() || foodSizeText.trim().isEmpty() || foodPriceText.trim().isEmpty())) {
                editFood(editedFood);
                getContentPane().removeAll();
                setContentPane(itemEditedTab());
            }
        }

        if (e.getSource() == editFoodButton) {
            for (FoodClass i : foods) {
                editFoodButtons.add(new JButton(i.getName() + ":" + i.getID()));
            }
            getContentPane().removeAll();
            setContentPane(editFoodContainer());
        }


        if (e.getSource() == saveButtonF) {
            foodNameText = foodNameField.getText();
            foodDescriptionText = foodDescriptionField.getText();
            foodSizeText = foodSizeField.getText();
            foodPriceText = foodPriceField.getText();
            foodIDtext = foodIDField.getText();
            if (!(foodNameText.trim().isEmpty() || foodDescriptionText.trim().isEmpty() || foodSizeText.trim().isEmpty() || foodPriceText.trim().isEmpty() || foodIDtext.trim().isEmpty())) {
                if (foodIdChecker()) {
                    JOptionPane.showMessageDialog(null, "That ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    foodIDField.setText(null);
                } else {
                    addFoodItem();
                    getContentPane().removeAll();
                    setContentPane(itemAddedTab());
                }
            }
        }
        if (e.getSource() == saveButtonD) {
            drinkNameText = drinkNameField.getText();
            drinkDescriptionText = drinkDescriptionNameField.getText();
            drinkSizeText = drinkSizeField.getText();
            drinkPriceText = drinkPriceField.getText();
            drinkIDtext = drinkIdField.getText();

            if (!(drinkNameText.trim().isEmpty() || drinkDescriptionText.trim().isEmpty() || drinkSizeText.trim().isEmpty() || drinkPriceText.trim().isEmpty() || drinkIDtext.trim().isEmpty())) {
                if (drinkIdChecker()) {
                    JOptionPane.showMessageDialog(null, "That ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    drinkIdField.setText(null);
                } else {
                    addDrinkItem();
                    getContentPane().removeAll();
                    setContentPane(itemAddedTab());
                }
            }
        }
        if (e.getSource() == saveButtonW) {
            firstNameText = firstNameField.getText();
            lastNameText = lastNameField.getText();
            phoneNumberText = phoneNumberField.getText();
            addresText = addresField.getText();
            emailText = emailField.getText();
            waiterIDtext = waiterIDField.getText();
            waiterPasswordText = waiterPasswordField.getText();

            if (!(firstNameText.trim().isEmpty() || lastNameText.trim().isEmpty() || phoneNumberText.trim().isEmpty() || addresText.trim().isEmpty() || emailText.trim().isEmpty() || waiterIDtext.trim().isEmpty() || waiterPasswordText.trim().isEmpty())) {
                if (waiterIdChecker()) {
                    JOptionPane.showMessageDialog(null, "That ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    waiterIDField.setText(null);
                } else {
                    addWaiterItem();
                    getContentPane().removeAll();
                    setContentPane(itemAddedTab());
                }
            }
        }

    }
}