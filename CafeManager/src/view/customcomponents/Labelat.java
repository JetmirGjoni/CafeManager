package view.customcomponents;

import javax.swing.*;
import java.awt.*;

public class Labelat {

    public JLabel username(int x , int y , int width , int height){
        JLabel username = new JLabel("ID: ");
        username.setBounds(x,y,width,height);
        return username;
    }

    public JLabel password(int x , int y , int width , int height){
        JLabel password = new JLabel("Password: ");
        password.setBounds(x,y,width,height);
        return password;
    }

    public JLabel waiterMenuText(int x , int y , int width , int height){
        JLabel waiterMenuText=new JLabel("Waiter Log In");
        waiterMenuText.setBounds(x,y,width , height);
        waiterMenuText.setFont(new Font("Serif" , Font.PLAIN , 60));
        return waiterMenuText;
    }

    public JLabel adminMenuText(int x , int y , int width , int height){
        JLabel waiterMenuText=new JLabel("Admin Log In");
        waiterMenuText.setBounds(x,y,width , height);
        waiterMenuText.setFont(new Font("Serif" , Font.PLAIN , 60));
        return waiterMenuText;
    }

    public JLabel saveChangesText(int x , int y , int width , int height){
        JLabel saveChange = new JLabel("Are you sure you want " +
                "to save these changes?");
        saveChange.setBounds(x,y,width,height);
        return saveChange;
    }

    public JLabel waiterSettings(int x , int y , int width , int height){
        JLabel waiterSettings = new JLabel("Waiter Settings");
        waiterSettings.setBounds(x,y,width,height);
        return  waiterSettings;
    }

    public JLabel tableSettings(int x , int y , int width , int height){
        JLabel tableSettings = new JLabel("Table Settings");
        tableSettings.setBounds(x,y,width,height);
        return tableSettings;
    }

    public JLabel drinksSettings(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink Settings");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel foodSettings(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food Settings");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addFood(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food Name:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addFoodDescription(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food Description:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addFoodSize(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food Size:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addFoodPrice(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food Price:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addDrink(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink Name:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addDrinkDescription(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink Description:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addDrinkSize(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink Size:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addDrinkPrice(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink Price:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel nameLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("First Name:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel lastNameLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Last Name:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel phoneNumberLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Phone Number:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel addressLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Address:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel emailLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("E-mail:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel emptyLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel foodAddedLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Item added successfully!");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel foodIdLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Food ID:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel drinkIdLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Drink ID:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel waiterIdLabel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Waiter ID:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel itemRemoved(int x , int y , int width , int height){
        JLabel label  = new JLabel("Item removed successfully!");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel tableIdLbel(int x , int y , int width , int height){
        JLabel label  = new JLabel("Table ID:");
        label.setBounds(x,y,width,height);
        return label;
    }

    public JLabel customLabel(int x , int y , int width , int height , String labelText){
        JLabel label  = new JLabel(labelText);
        label.setBounds(x,y,width,height);
        return label;
    }



}
