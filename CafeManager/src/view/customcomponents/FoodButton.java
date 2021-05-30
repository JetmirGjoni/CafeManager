package view.customcomponents;

import model.FoodClass;

import javax.swing.JButton;

public class FoodButton extends JButton {
    private FoodClass food;
    public FoodButton(FoodClass food){
        super(food.getName());
        this.food = food;
    }
    public FoodClass getFood(){
        return food;
    }
}
