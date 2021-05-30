package view.customcomponents;

import javax.swing.*;

public class Butonat {

    public JButton administrator(int x , int y , int width , int height){
        JButton administrator = new JButton("Admin");
                administrator.setBounds(x,y,width,height);
        //kodi per modifikimin e pamjes se butonit
        return  administrator;
    }

    public JButton waiterMenuButton(int x , int y , int width , int height){
        JButton waiter = new JButton("Waiter");
                waiter.setBounds(x,y,width,height);
        return  waiter;
    }

    public JButton table(){ //Panel
        JButton table = new JButton("Table");
                //kodi per modifikimin e pamjes se butonit
        return table;
    }

    public JButton addtable(int x , int y , int width , int height){
        JButton addTable = new JButton("Add Table");
        //kodi per modifikimin e pamjes se butonit
        addTable.setBounds(x,y,width,height);
        return addTable;
    }

    public JButton removeTable(int x , int y , int width , int height){
        JButton removeTable = new JButton("Remove Table");
        //kodi per modifikimin e pamjes se butonit
        removeTable.setBounds(x,y,width,height);
        return removeTable;
    }

    public JButton transferTable(){
        JButton TransferTable = new JButton("Transfer Table");
        //kodi per modifikimin e pamjes se butonit
        return TransferTable;
    }

    public JButton drinks(){ //Panel
        JButton pijet = new JButton("Drinks");
        //kodi per modifikimin e pamjes se butonit
        return pijet;
    }

    public JButton addDrink(int x , int y , int width , int height){
        JButton addDrink = new JButton("Add Drink");
        addDrink.setBounds(x,y,width,height);
        //kodi per modifikimin e pamjes se butonit
        return  addDrink;
    }

    public JButton editDrink(int x , int y , int width , int height){
        JButton button = new JButton("Edit Drink");
        button.setBounds(x,y,width,height);
        return  button;

    }

    public JButton removeDrink(int x , int y , int width , int height){
        JButton removeDrink = new JButton("Remove Drink");
        //kodi per modifikimin e pamjes se butonit
        removeDrink.setBounds(x,y,width,height);
        return removeDrink;
    }

    public JButton setPrice(){
        JButton setPrice = new JButton("Set Price");
        //kodi per modifikimin e pamjes se butonit
        return  setPrice;
    }

    public JButton waiters(){//Panel
        JButton waiter = new JButton("Waiters");
        //kodi per modifikimin e pamjes se butonit
        return waiter;
    }

    public JButton addWaiter(int x , int y , int width , int height){
        JButton addWaiter = new JButton("Add Waiter");
        addWaiter.setBounds(x,y,width,height);
        //kodi per modifikimin e pamjes se butonit
        return addWaiter;
    }

    public JButton removeWaiter(int x , int y , int width , int height){
        JButton removeWaiter = new JButton("Remove Waiter");
        removeWaiter.setBounds(x,y,width,height);
        //kodi per modifikimin e pamjes se butonit
        return removeWaiter;
    }

    public JButton addFood(int x , int y , int width , int height){
        JButton button = new JButton("Add Food");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton removeFood(int x , int y , int width , int height){
        JButton button = new JButton("Remove Food");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton editFood(int x , int y , int width , int height){
        JButton button = new JButton("Edit Food");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton waiterLogIn(){
        JButton waiterLogIn = new JButton("Log In");
        //kodi per modifikimin e pamjes se butonit
        return waiterLogIn;
    }

    public JButton waiterLogOut(){
        JButton waiterLogOut = new JButton("Log Out");
        //kodi per modifikimin e pamjes se butonit
        return waiterLogOut;
    }

    public JButton saveButton(int x , int y , int width , int height){
        JButton save = new JButton("Save");
        //kodi per modifikimin e pamjes se butonit
        save.setBounds(x,y,width,height);
        return save;
    }

    public JButton cancelButton(int x , int y , int width , int height){
        JButton cancelButton = new JButton("Clear");
        //kodi per modifikimin e pamjes se butonit
        cancelButton.setBounds(x,y,width,height);
        return cancelButton;
    }

    public JButton exitButton(){
        JButton exit = new JButton("Exit");
        //kodi per modifikimin e pamjes se butonit
        return exit;
    }

    public JButton createAccount(){
        JButton createAccount = new JButton("Create account");
        //kodi per modifikimin e pamjes se butonit
        return createAccount;
    }

    public JButton signIn(){
        JButton singIn = new JButton("Sign In");
        //kodi per modifikimin e pamjes se butonit
        return  singIn;
    }

    public JButton logIn(int x , int y , int width , int height){
        JButton logIn = new JButton("Log In");
        logIn.setBounds(x,y,width,height);
        //kodi per modifikimin e pamjes se butonit
        return  logIn;
    }

    public JButton addButton(int x , int y , int width , int height){
        JButton button = new JButton("Add");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton returnButton(int x , int y , int width , int height){
        JButton button = new JButton("Return");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton okButton(int x , int y , int width , int height){
        JButton button = new JButton("OK");
        button.setBounds(x,y,width,height);
        return button;
    }

    public JButton editWaiterButton(int x , int y , int width , int height){
        JButton button = new JButton("Edit Waiter");
        button.setBounds(x,y,width,height);
        return button;
    }

}
