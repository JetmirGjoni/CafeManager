package view.waitermenu;

import model.DrinkClass;
import model.FoodClass;
import model.Item;
import model.TableClass;
import model.filemanager.FileManager;
import view.customcomponents.DrinkButton;
import view.customcomponents.FoodButton;
import view.customcomponents.ItemCheckBox;
import view.customcomponents.TableButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditOrders extends JDialog implements ActionListener {

    private final int buttonColumns;

    private JPanel pnMainPanel;
    private JButton btRemoveSelectedItems;
    private JButton btInvertSelection;
    private JSplitPane sppItemPanel;
    private JPanel pnSelectionPanel;
    private JPanel pnFoodPanel;
    private final FileManager fileWriter;

    private final TableClass table;
    private final TableButton tableButton;

    GridBagConstraints gbcSelectionPanel;
    GridBagLayout gbSelectionPanel;

    private ArrayList<FoodButton> foodButtons;
    private ArrayList<DrinkButton> drinkButtons;
    private ArrayList<ItemCheckBox> selectedItems;

    public EditOrders(TableButton tableButton, ArrayList<FoodClass> foods, ArrayList<DrinkClass> drinks){
        this.table = tableButton.getTable();
        this.tableButton = tableButton;

        init();
        buttonColumns = 4;
        addFoodButtons(foods);
        addDrinkButtons(drinks);
        addOrderItems(table.getOrder());
        fileWriter = new FileManager();

        setTitle("Edit Orders: Table " + table.getID());
        setMinimumSize(new Dimension(600,400));
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setContentPane( pnMainPanel );
        setMinimumSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        setVisible( true );

    }

    private void init(){
        pnMainPanel = new JPanel();
        pnMainPanel.setBorder( BorderFactory.createTitledBorder( "" ) );
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout( gbMainPanel );

        JSplitPane sppMainPanel = new JSplitPane();
        sppMainPanel.setDividerLocation( 300 );
        sppMainPanel.setForeground( new Color( 0,0,0 ) );
        sppMainPanel.setLastDividerLocation( 214 );

        JPanel pnOrderPanel = new JPanel();
        pnOrderPanel.setBorder( BorderFactory.createTitledBorder( "Orders" ) );
        GridBagLayout gbOrderPanel = new GridBagLayout();
        GridBagConstraints gbcOrderPanel = new GridBagConstraints();
        pnOrderPanel.setLayout( gbOrderPanel );

        btRemoveSelectedItems = new JButton( "Remove Selected Items"  );
        btRemoveSelectedItems.addActionListener(this);
        gbcOrderPanel.gridx = 0;
        gbcOrderPanel.gridy = 2;
        gbcOrderPanel.gridwidth = 2;
        gbcOrderPanel.gridheight = 1;
        gbcOrderPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcOrderPanel.weightx = 1;
        gbcOrderPanel.weighty = 0;
        gbcOrderPanel.anchor = GridBagConstraints.SOUTH;
        gbOrderPanel.setConstraints( btRemoveSelectedItems, gbcOrderPanel );
        pnOrderPanel.add( btRemoveSelectedItems );

        btInvertSelection = new JButton( "Invert Selection"  );
        btInvertSelection.addActionListener(this);
        gbcOrderPanel.gridx = 0;
        gbcOrderPanel.gridy = 1;
        gbcOrderPanel.gridwidth = 2;
        gbcOrderPanel.gridheight = 1;
        gbcOrderPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcOrderPanel.weightx = 1;
        gbcOrderPanel.weighty = 0;
        gbcOrderPanel.anchor = GridBagConstraints.SOUTH;
        gbOrderPanel.setConstraints( btInvertSelection, gbcOrderPanel );
        pnOrderPanel.add( btInvertSelection );

        pnSelectionPanel = new JPanel();
        GridBagLayout gbSelectionPanel = new GridBagLayout();
        pnSelectionPanel.setLayout( gbSelectionPanel );
        JScrollPane scpSelectionPanel = new JScrollPane( pnSelectionPanel );
        gbcOrderPanel.gridx = 0;
        gbcOrderPanel.gridy = 0;
        gbcOrderPanel.gridwidth = 2;
        gbcOrderPanel.gridheight = 1;
        gbcOrderPanel.fill = GridBagConstraints.BOTH;
        gbcOrderPanel.weightx = 1;
        gbcOrderPanel.weighty = 1;
        gbcOrderPanel.anchor = GridBagConstraints.NORTH;
        gbOrderPanel.setConstraints( scpSelectionPanel, gbcOrderPanel );
        pnOrderPanel.add( scpSelectionPanel );
        sppMainPanel.setLeftComponent(pnOrderPanel);

        JPanel pnItemPanel = new JPanel();
        GridBagLayout gbItemPanel = new GridBagLayout();
        GridBagConstraints gbcItemPanel = new GridBagConstraints();
        pnItemPanel.setLayout( gbItemPanel );

        sppItemPanel = new JSplitPane( );
        sppItemPanel.setDividerLocation( 190 );
        sppItemPanel.setForeground( new Color( 0,0,0 ) );
        sppItemPanel.setLastDividerLocation( 190 );
        sppItemPanel.setOrientation( 0 );

        pnFoodPanel = new JPanel();
        pnFoodPanel.setBorder( BorderFactory.createTitledBorder( "Foods" ) );
        GridBagLayout gbFoodPanel = new GridBagLayout();
        pnFoodPanel.setLayout( gbFoodPanel );
        sppItemPanel.setRightComponent(pnFoodPanel);
        gbcItemPanel.gridx = 0;
        gbcItemPanel.gridy = 0;
        gbcItemPanel.gridwidth = 1;
        gbcItemPanel.gridheight = 1;
        gbcItemPanel.fill = GridBagConstraints.BOTH;
        gbcItemPanel.weightx = 1;
        gbcItemPanel.weighty = 1;
        gbcItemPanel.anchor = GridBagConstraints.NORTH;
        gbItemPanel.setConstraints( sppItemPanel, gbcItemPanel );
        pnItemPanel.add( sppItemPanel );
        sppMainPanel.setRightComponent(pnItemPanel);
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 0;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints(sppMainPanel, gbcMainPanel );
        pnMainPanel.add(sppMainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btInvertSelection){
            for(ItemCheckBox selectedItem : selectedItems){
                selectedItem.setSelected(!selectedItem.isSelected());
            }
            revalidate();
        }

        if(e.getSource() == btRemoveSelectedItems){
            for(ItemCheckBox selectedItem : selectedItems){
                if(selectedItem.isSelected()){
                    table.removeOrder(selectedItem.getItem());
                    fileWriter.writeOrderFile(table);
                }
            }
            tableButton.updateState();
            dispose();
        }

        for(FoodButton foodButton : foodButtons){
            if(e.getSource() == foodButton){
                table.addOrder(foodButton.getFood());
                tableButton.updateState();
                addOrderItem(foodButton.getFood());
                fileWriter.writeOrderFile(table);
            }
        }

        for(DrinkButton drinkButton : drinkButtons){
            if(e.getSource() == drinkButton){
                table.addOrder(drinkButton.getDrink());
                tableButton.updateState();
                addOrderItem(drinkButton.getDrink());
                fileWriter.writeOrderFile(table);
            }
        }

    }

    private void addOrderItems(ArrayList<Item> orders){
        selectedItems = new ArrayList<>();

        gbcSelectionPanel = new GridBagConstraints();
        gbSelectionPanel = new GridBagLayout();
        gbcSelectionPanel.gridx = 0;
        gbcSelectionPanel.gridy = 0;
        gbcSelectionPanel.fill = GridBagConstraints.NONE;
        gbcSelectionPanel.anchor = GridBagConstraints.NORTH;
        gbcSelectionPanel.weighty = 0;
        gbcSelectionPanel.weightx = 1;

        for(Item item: orders){
            addOrderItem(item);
        }
    }

    private void addOrderItem(Item order){
        ItemCheckBox orderBox = new ItemCheckBox(order);
        pnSelectionPanel.setLayout(gbSelectionPanel);
        selectedItems.add(orderBox);
        gbcSelectionPanel.gridx = 0;
        gbSelectionPanel.setConstraints(orderBox, gbcSelectionPanel);
        pnSelectionPanel.add(orderBox);

        gbcSelectionPanel.gridx = 1;
        JLabel itemName = new JLabel(order.getName());
        gbSelectionPanel.setConstraints(itemName, gbcSelectionPanel);
        pnSelectionPanel.add(itemName);

        gbcSelectionPanel.gridx = 2;
        JLabel itemPrice = new JLabel(order.getPrice());
        gbSelectionPanel.setConstraints(itemPrice, gbcSelectionPanel);
        pnSelectionPanel.add(itemPrice);

        gbcSelectionPanel.gridy += 1;

        pnSelectionPanel.revalidate();
    }

    private void addDrinkButtons(ArrayList<DrinkClass> drinks){
        drinkButtons = new ArrayList<>();
        JPanel pnDrinkPanel = new JPanel();
        pnDrinkPanel.setBorder( BorderFactory.createTitledBorder( "Drinks" ) );
        GridBagLayout gbDrinkPanel = new GridBagLayout();
        GridBagConstraints gbcDrinkPanel = new GridBagConstraints();
        pnDrinkPanel.setLayout( gbDrinkPanel );
        sppItemPanel.setLeftComponent(new JScrollPane(pnDrinkPanel));
        sppItemPanel.setOneTouchExpandable(true);

        gbcDrinkPanel.weightx = 1;
        gbcDrinkPanel.gridwidth = 1;
        gbcDrinkPanel.gridheight = 1;
        gbcDrinkPanel.weighty = 1;
        gbcDrinkPanel.gridx = 0;
        gbcDrinkPanel.gridy = 0;
        gbcDrinkPanel.fill = GridBagConstraints.NONE;
        gbcDrinkPanel.anchor = GridBagConstraints.NORTH;

        for(DrinkClass drink: drinks){
            DrinkButton drinkButton = new DrinkButton(drink);
            drinkButton.addActionListener(this);
            gbDrinkPanel.setConstraints(drinkButton, gbcDrinkPanel);
            pnDrinkPanel.add(drinkButton);
            drinkButtons.add(drinkButton);
            gbcDrinkPanel.gridx += 1;
            if(gbcDrinkPanel.gridx >= buttonColumns){
                gbcDrinkPanel.gridx = 0;
                gbcDrinkPanel.gridy += 1;
            }
        }
    }

    private void addFoodButtons(ArrayList<FoodClass> foods){
        foodButtons = new ArrayList<>();
        pnFoodPanel = new JPanel();
        pnFoodPanel.setBorder( BorderFactory.createTitledBorder( "Foods" ) );
        GridBagLayout gbFoodPanel = new GridBagLayout();
        GridBagConstraints gbcFoodPanel = new GridBagConstraints();
        pnFoodPanel.setLayout( gbFoodPanel );
        sppItemPanel.setRightComponent(new JScrollPane(pnFoodPanel));

        gbcFoodPanel.weightx = 1;
        gbcFoodPanel.weighty = 1;
        gbcFoodPanel.gridy = 0;
        gbcFoodPanel.gridx = 0;
        gbcFoodPanel.fill = GridBagConstraints.NONE;
        gbcFoodPanel.anchor = GridBagConstraints.NORTH;

        for(FoodClass food: foods){
            FoodButton foodButton = new FoodButton(food);
            foodButton.addActionListener(this);
            gbFoodPanel.setConstraints(foodButton, gbcFoodPanel);
            pnFoodPanel.add(foodButton);
            foodButtons.add(foodButton);
            gbcFoodPanel.gridx += 1;
            if(gbcFoodPanel.gridx >= buttonColumns){
                gbcFoodPanel.gridx = 0;
                gbcFoodPanel.gridy += 1;
            }
        }
    }
}