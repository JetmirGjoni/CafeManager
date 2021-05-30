package view.customcomponents;

import model.Item;

import javax.swing.JCheckBox;

public class ItemCheckBox extends JCheckBox {
    private Item item;
    public ItemCheckBox(Item item){
        this.item = item;
    }
    public Item getItem(){
        return item;
    }
}
