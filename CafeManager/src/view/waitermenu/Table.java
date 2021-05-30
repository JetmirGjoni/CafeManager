package view.waitermenu;

import model.DrinkClass;
import model.FoodClass;
import model.Item;
import model.TableClass;
import model.filemanager.FileManager;
import view.customcomponents.TableButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JDialog implements ActionListener
{
   private TableButton tableButton;
   private JPanel pnMainPanel;

   private JPanel pnItemPanel;
   private JButton btPaymentButton;
   private JButton btCloseButton;
   private JButton btEditOrdersButton;
   private TableClass table;
   private ArrayList<Item> orders;
   private JLabel lbTotal;
   private GridBagLayout gbItemPanel;
   private GridBagConstraints gbcItemPanel;

   private JRadioButton rbAvaliableRadioButton;
   private JRadioButton rbReservedRadioButton;
   private JRadioButton rbOccupiedRadioButton;

   private ArrayList<FoodClass> foods;
   private ArrayList<DrinkClass> drinks;

   private FileManager fileWriter;

   public Table(){

   }

   public Table(TableButton tableButton, ArrayList<FoodClass> foods, ArrayList<DrinkClass> drinks)
   {
      this.table = tableButton.getTable();
      this.tableButton = tableButton;
      this.foods = foods;
      this.drinks = drinks;

      init();

      updateOrders();

      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
      setContentPane( pnMainPanel );
      setTitle("Table: " + table.getID());
      setLocationByPlatform(true);
      setMinimumSize(new Dimension(400,400));
      setLocationRelativeTo(null);
      setVisible(true);

   }
   private void init() {

      fileWriter = new FileManager();

      ButtonGroup rgbTableState = new ButtonGroup();

      pnMainPanel = new JPanel();
      pnMainPanel.setBorder( BorderFactory.createTitledBorder( "" ) );
      GridBagLayout gbMainPanel = new GridBagLayout();
      GridBagConstraints gbcMainPanel = new GridBagConstraints();
      pnMainPanel.setLayout( gbMainPanel );

      pnItemPanel = new JPanel();
      pnItemPanel.setBorder( BorderFactory.createTitledBorder( "" ) );
      gbItemPanel = new GridBagLayout();
      gbcItemPanel = new GridBagConstraints();
      pnItemPanel.setLayout( gbItemPanel );

      JScrollPane scpItemPanel = new JScrollPane( pnItemPanel );
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 0;
      gbcMainPanel.gridwidth = 2;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 1;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( scpItemPanel, gbcMainPanel );
      pnMainPanel.add( scpItemPanel );

      lbTotal = new JLabel();
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 1;
      gbcMainPanel.gridwidth = 2;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.HORIZONTAL;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints(lbTotal, gbcMainPanel );
      pnMainPanel.add(lbTotal);

      rbAvaliableRadioButton = new JRadioButton( "Avaliable"  );
      rbAvaliableRadioButton.setSelected(table.isAvaliable());
      rbAvaliableRadioButton.addActionListener(this);
      rgbTableState.add( rbAvaliableRadioButton );
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 2;
      gbcMainPanel.gridwidth = 1;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( rbAvaliableRadioButton, gbcMainPanel );
      pnMainPanel.add( rbAvaliableRadioButton );

      rbReservedRadioButton = new JRadioButton( "Reserved"  );
      rbReservedRadioButton.setSelected(table.isReserved());
      rbReservedRadioButton.addActionListener(this);
      rgbTableState.add( rbReservedRadioButton );
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 3;
      gbcMainPanel.gridwidth = 1;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( rbReservedRadioButton, gbcMainPanel );
      pnMainPanel.add( rbReservedRadioButton );

      rbOccupiedRadioButton = new JRadioButton( "Occupied"  );
      rbOccupiedRadioButton.setSelected( true );
      rbOccupiedRadioButton.addActionListener(this);
      rgbTableState.add( rbOccupiedRadioButton );
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 4;
      gbcMainPanel.gridwidth = 1;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( rbOccupiedRadioButton, gbcMainPanel );
      pnMainPanel.add( rbOccupiedRadioButton );

      btEditOrdersButton = new JButton("Edit Orders");
      btEditOrdersButton.addActionListener(this);
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 5;
      gbcMainPanel.gridwidth = 2;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( btEditOrdersButton, gbcMainPanel );
      pnMainPanel.add( btEditOrdersButton );

      btPaymentButton = new JButton( "Payment"  );
      btPaymentButton.setEnabled(!table.getOrder().isEmpty());
      btPaymentButton.addActionListener(this);
      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 6;
      gbcMainPanel.gridwidth = 1;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( btPaymentButton, gbcMainPanel );
      pnMainPanel.add( btPaymentButton );

      btCloseButton = new JButton( "Close"  );
      btCloseButton.addActionListener(this);
      gbcMainPanel.gridx = 1;
      gbcMainPanel.gridy = 6;
      gbcMainPanel.gridwidth = 1;
      gbcMainPanel.gridheight = 1;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( btCloseButton, gbcMainPanel );
      pnMainPanel.add( btCloseButton );

      gbcItemPanel.gridx = 0;
      gbcItemPanel.gridy = 2;
      gbcItemPanel.gridwidth = 1;
      gbcItemPanel.gridheight = 1;
      gbcItemPanel.fill = GridBagConstraints.NONE;
      gbcItemPanel.weightx = 1;
      gbcItemPanel.weighty = 1;
      gbcItemPanel.anchor = GridBagConstraints.NORTH;

   }

   public void updateOrders(){
      pnItemPanel.removeAll();
      orders = table.getOrder();

      JLabel lbItemLabel = new JLabel("Items:");
      gbcItemPanel.gridx = 0;
      gbcItemPanel.gridy = 0;
      gbcItemPanel.gridwidth = 1;
      gbcItemPanel.gridheight = 1;
      gbcItemPanel.fill = GridBagConstraints.NONE;
      gbcItemPanel.weightx = 1;
      gbcItemPanel.weighty = 0;
      gbcItemPanel.anchor = GridBagConstraints.NORTH;
      gbItemPanel.setConstraints(lbItemLabel, gbcItemPanel );
      pnItemPanel.add(lbItemLabel);

      JLabel lbPriceLabel = new JLabel("Price:");
      gbcItemPanel.gridx = 1;
      gbcItemPanel.gridy = 0;
      gbcItemPanel.gridwidth = 1;
      gbcItemPanel.gridheight = 1;
      gbcItemPanel.fill = GridBagConstraints.NONE;
      gbcItemPanel.weightx = 1;
      gbcItemPanel.weighty = 0;
      gbcItemPanel.anchor = GridBagConstraints.NORTH;
      gbItemPanel.setConstraints(lbPriceLabel, gbcItemPanel );
      pnItemPanel.add(lbPriceLabel);

      groupOrders();//grouping orders by ID

      JLabel emptyLabel = new JLabel("");
      gbcItemPanel.gridwidth = 2;
      gbcItemPanel.weighty = 1;
      gbcItemPanel.anchor = GridBagConstraints.SOUTH;
      gbcItemPanel.gridx = 0;
      gbItemPanel.setConstraints(emptyLabel, gbcItemPanel);
      pnItemPanel.add(emptyLabel);

      lbTotal.setText("Total: " + table.getTotalOrder());

      pnItemPanel.repaint();
   }

   public void groupOrders(){
      gbcItemPanel.gridx = 0;
      gbcItemPanel.gridy = 1;
      gbcItemPanel.gridwidth = 1;
      gbcItemPanel.gridheight = 1;
      gbcItemPanel.fill = GridBagConstraints.NONE;
      gbcItemPanel.weightx = 1;
      gbcItemPanel.weighty = 0;
      gbcItemPanel.anchor = GridBagConstraints.NORTH;

      ArrayList<Item> tempOrder = new ArrayList<>(orders);
      for(int i = 0; i < tempOrder.size(); i++){
         Item item1 = tempOrder.get(i);
         int numOfOrders = 1;
         for(int j = i + 1; j < tempOrder.size(); j++){
            Item item2 = tempOrder.get(j);
            //check if items are foods or drinks
            if(item1 instanceof DrinkClass == item2 instanceof DrinkClass){
               if(item1.getID().equals(item2.getID())){
                  ++numOfOrders;
                  tempOrder.remove(j);
                  j--;
               }
            }
         }

         tempOrder.remove(i);
         i--;

         JLabel itemName = new JLabel(item1.getName() + " x " + numOfOrders);
         gbcItemPanel.gridx = 0;
         gbItemPanel.setConstraints(itemName, gbcItemPanel);
         pnItemPanel.add(itemName);

         JLabel itemPrice = new JLabel(item1.getPrice() + " x " + numOfOrders);
         gbcItemPanel.gridx = 1;
         gbItemPanel.setConstraints(itemPrice, gbcItemPanel);
         pnItemPanel.add(itemPrice);

         gbcItemPanel.gridx = 0;
         gbcItemPanel.gridy += 1;
      }
   }

   public void payment(){
      int decision = JOptionPane.showConfirmDialog(null, "You are proceeding to do the payment!\nConfirm:");
      if(decision == 0){
         table.setAvaliable();
         updateOrders();
         tableButton.updateState();
         rbAvaliableRadioButton.setSelected(true);
         fileWriter.writeOrderFile(table);
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      if(e.getSource() == rbAvaliableRadioButton){
         if(!orders.isEmpty()){
            JOptionPane.showMessageDialog(null, "Table has orders. Unable to complete action!");
            rbOccupiedRadioButton.setSelected(true);
         }
         else {
            table.setAvaliable();
            btPaymentButton.setEnabled(!orders.isEmpty());
            tableButton.updateState();
         }
      }

      else if(e.getSource() == rbReservedRadioButton){
         if(!orders.isEmpty()){
            JOptionPane.showMessageDialog(null, "Table has orders. Unable to complete action!");
            rbOccupiedRadioButton.setSelected(true);
         }
         else {
            table.setReserved();
            btPaymentButton.setEnabled(!orders.isEmpty());
            tableButton.updateState();
         }
      }

      else if(e.getSource() == rbOccupiedRadioButton){
         table.setOccupied();
         btPaymentButton.setEnabled(!orders.isEmpty());
         tableButton.updateState();
      }

      else if(e.getSource() == btCloseButton){
         dispose();
      }

      else if(e.getSource() == btPaymentButton){
         payment();
         btPaymentButton.setEnabled(!orders.isEmpty());
      }

      else if(e.getSource() == btEditOrdersButton){
         dispose();
         new EditOrders(tableButton, foods, drinks);
      }
   }

   public TableClass getTable(){
      return table;
   }
}