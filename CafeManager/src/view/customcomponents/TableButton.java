package view.customcomponents;

import model.TableClass;

import javax.swing.JButton;
import java.awt.*;

public class TableButton extends JButton {

    private TableClass table;
    public TableButton(TableClass table){
        super(table.getID());
        this.table = table;
        updateState();
    }

    public TableClass getTable(){
        return table;
    }

    public void updateState(){
        //table is reserved
        if(table.isReserved()){
            setBackground(Color.ORANGE);
        }
        //table is free
        else if(table.isAvaliable()){
            setBackground(Color.GREEN);
        }
        //table is taken
        else{
            setBackground(Color.RED);
        }
        this.revalidate();
    }
}
