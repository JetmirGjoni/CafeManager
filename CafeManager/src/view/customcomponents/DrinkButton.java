package view.customcomponents;

import model.DrinkClass;

import javax.swing.JButton;

public class DrinkButton extends JButton {
    private DrinkClass drink;
    public DrinkButton(DrinkClass drink){
        super(drink.getName());
        this.drink = drink;
    }
    public DrinkClass getDrink(){
        return drink;
    }
}
