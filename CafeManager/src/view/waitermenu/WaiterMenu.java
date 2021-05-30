package view.waitermenu;

import model.*;
import view.adminmenu.StartUpPanel;
import view.customcomponents.ClockLabel;
import view.customcomponents.TableButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WaiterMenu extends JFrame implements ActionListener {
    private Table displayedTable;
    private JSplitPane sppSplitPane;
    private static ArrayList<TableButton> tableButtons;
    private static ArrayList<FoodClass> foods;
    private static ArrayList<DrinkClass> drinks;
    private ClockLabel lbClockLabel;

    private JButton btLockButton;
    private JButton btLogOutButton;

    private final WaiterClass waiter;

    public WaiterMenu(WaiterSpecification waiter, ArrayList<TableSpecification> tables, ArrayList<FoodClass> foods, ArrayList<DrinkClass> drinks) {
        super("Cafe Management: Waiter Menu");

        WaiterMenu.foods = foods;
        WaiterMenu.drinks = drinks;
        this.waiter = (WaiterClass) waiter;

        init(tables);

        displayedTable = new Table();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lbClockLabel.updateClock();

        setContentPane(sppSplitPane);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void init(ArrayList<TableSpecification> tables) {

        sppSplitPane = new JSplitPane();
        sppSplitPane.setDividerLocation(400);
        sppSplitPane.setForeground(new Color(0, 0, 0));
        sppSplitPane.setLastDividerLocation(24);

        JPanel pnTablesPanel = new JPanel();
        pnTablesPanel.setBorder(BorderFactory.createTitledBorder("Tables"));
        GridBagLayout gbTablesPanel = new GridBagLayout();
        GridBagConstraints gbcTablesPanel = new GridBagConstraints();
        pnTablesPanel.setLayout(gbTablesPanel);
        sppSplitPane.setLeftComponent(new JScrollPane(pnTablesPanel));

        JPanel pnFunctionsPanel = new JPanel();
        pnFunctionsPanel.setBorder(BorderFactory.createTitledBorder("Functions"));
        GridBagLayout gbFunctionsPanel = new GridBagLayout();
        GridBagConstraints gbcFunctionsPanel = new GridBagConstraints();
        pnFunctionsPanel.setLayout(gbFunctionsPanel);
        sppSplitPane.setRightComponent(pnFunctionsPanel);


        lbClockLabel = new ClockLabel("CLOCK");
        lbClockLabel.setFont(new Font(null, Font.PLAIN, 25));
        gbcFunctionsPanel.gridx = 0;
        gbcFunctionsPanel.gridy = 0;
        gbcFunctionsPanel.anchor = GridBagConstraints.NORTH;
        gbcFunctionsPanel.weighty = 0;
        gbcFunctionsPanel.weightx = 1;
        gbcFunctionsPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcFunctionsPanel.insets = new Insets(20, 20, 20, 20);
        gbFunctionsPanel.setConstraints(lbClockLabel, gbcFunctionsPanel);
        pnFunctionsPanel.add(lbClockLabel);

        JPanel pnTransferTablesPanel = new JPanel();
        pnTransferTablesPanel.setBorder(BorderFactory.createTitledBorder("Transfer Tables"));
        GridBagLayout gbTransferTablesPanel = new GridBagLayout();
        GridBagConstraints gbcTransferTablesPanel = new GridBagConstraints();
        pnTransferTablesPanel.setLayout(gbTransferTablesPanel);

        JTextField tfTable1IDField = new JTextField();
        gbcTransferTablesPanel.gridx = 1;
        gbcTransferTablesPanel.gridy = 0;
        gbcTransferTablesPanel.gridwidth = 1;
        gbcTransferTablesPanel.gridheight = 1;
        gbcTransferTablesPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcTransferTablesPanel.weightx = 0;
        gbcTransferTablesPanel.weighty = 1;
        gbcTransferTablesPanel.anchor = GridBagConstraints.NORTH;
        gbcTransferTablesPanel.insets = new Insets(3, 0, 8, 0);
        gbTransferTablesPanel.setConstraints(tfTable1IDField, gbcTransferTablesPanel);
        pnTransferTablesPanel.add(tfTable1IDField);

        JTextField tfTable2IDField = new JTextField();
        gbcTransferTablesPanel.gridx = 1;
        gbcTransferTablesPanel.gridy = 1;
        gbcTransferTablesPanel.gridwidth = 1;
        gbcTransferTablesPanel.gridheight = 1;
        gbcTransferTablesPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcTransferTablesPanel.weightx = 0;
        gbcTransferTablesPanel.weighty = 1;
        gbcTransferTablesPanel.anchor = GridBagConstraints.NORTH;
        gbTransferTablesPanel.setConstraints(tfTable2IDField, gbcTransferTablesPanel);
        pnTransferTablesPanel.add(tfTable2IDField);

        JLabel lbTable1IDLabel = new JLabel("From:");
        gbcTransferTablesPanel.gridx = 0;
        gbcTransferTablesPanel.gridy = 0;
        gbcTransferTablesPanel.gridwidth = 1;
        gbcTransferTablesPanel.gridheight = 1;
        gbcTransferTablesPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcTransferTablesPanel.weightx = 0;
        gbcTransferTablesPanel.weighty = 1;
        gbcTransferTablesPanel.anchor = GridBagConstraints.CENTER;
        gbcTransferTablesPanel.insets = new Insets(4, 3, 10, 10);
        gbTransferTablesPanel.setConstraints(lbTable1IDLabel, gbcTransferTablesPanel);
        pnTransferTablesPanel.add(lbTable1IDLabel);

        JLabel lbTable2IDLabel = new JLabel("To:");
        gbcTransferTablesPanel.gridx = 0;
        gbcTransferTablesPanel.gridy = 1;
        gbcTransferTablesPanel.gridwidth = 1;
        gbcTransferTablesPanel.gridheight = 1;
        gbcTransferTablesPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcTransferTablesPanel.weightx = 0;
        gbcTransferTablesPanel.weighty = 1;
        gbcTransferTablesPanel.anchor = GridBagConstraints.EAST;
        gbcTransferTablesPanel.insets = new Insets(0, 15, 0, 0);
        gbTransferTablesPanel.setConstraints(lbTable2IDLabel, gbcTransferTablesPanel);
        pnTransferTablesPanel.add(lbTable2IDLabel);

        JButton btTransferButton = new JButton("Transfer");
        btTransferButton.addActionListener(this);
        gbcTransferTablesPanel.gridx = 0;
        gbcTransferTablesPanel.gridy = 2;
        gbcTransferTablesPanel.gridwidth = 2;
        gbcTransferTablesPanel.gridheight = 1;
        gbcTransferTablesPanel.fill = GridBagConstraints.NONE;
        gbcTransferTablesPanel.weightx = 1;
        gbcTransferTablesPanel.weighty = 0;
        gbcTransferTablesPanel.anchor = GridBagConstraints.SOUTH;
        gbcTransferTablesPanel.insets = new Insets(5, 0, 0, 0);
        gbTransferTablesPanel.setConstraints(btTransferButton, gbcTransferTablesPanel);
        pnTransferTablesPanel.add(btTransferButton);

        gbcFunctionsPanel.gridx = 0;
        gbcFunctionsPanel.gridy = 2;
        gbcFunctionsPanel.gridwidth = 1;
        gbcFunctionsPanel.gridheight = 2;
        gbcFunctionsPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcFunctionsPanel.weightx = 1;
        gbcFunctionsPanel.weighty = 1;
        gbcFunctionsPanel.insets = new Insets(0, 5, 0, 5);
        gbcFunctionsPanel.anchor = GridBagConstraints.NORTH;
        gbFunctionsPanel.setConstraints(pnTransferTablesPanel, gbcFunctionsPanel);
        pnFunctionsPanel.add(pnTransferTablesPanel);
        sppSplitPane.setOneTouchExpandable(true);
        sppSplitPane.setRightComponent(pnFunctionsPanel);

        JLabel waiterInfo = new JLabel("Waiter: " + waiter.getFirstName() + " " + waiter.getLastName());
        gbcFunctionsPanel.gridx = 0;
        gbcFunctionsPanel.gridy = 3;
        gbcFunctionsPanel.fill = GridBagConstraints.NONE;
        gbcFunctionsPanel.gridheight = 1;
        gbcFunctionsPanel.weighty = 1;
        gbcFunctionsPanel.weightx = 1;
        gbcFunctionsPanel.anchor = GridBagConstraints.SOUTH;
        gbFunctionsPanel.setConstraints(waiterInfo, gbcFunctionsPanel);
        pnFunctionsPanel.add(waiterInfo);

        btLockButton = new JButton("Lock");
        btLockButton.addActionListener(this);
        gbcFunctionsPanel.gridx = 0;
        gbcFunctionsPanel.gridy = 4;
        gbcFunctionsPanel.fill = GridBagConstraints.NONE;
        gbcFunctionsPanel.weighty = 0;
        gbcFunctionsPanel.weightx = 1;
        gbcFunctionsPanel.anchor = GridBagConstraints.SOUTH;
        gbFunctionsPanel.setConstraints(btLockButton, gbcFunctionsPanel);
        pnFunctionsPanel.add(btLockButton);

        btLogOutButton = new JButton("Log Out");
        btLogOutButton.setBackground(Color.RED);
        btLogOutButton.addActionListener(this);
        gbcFunctionsPanel.gridx = 0;
        gbcFunctionsPanel.gridy = 5;
        gbcFunctionsPanel.fill = GridBagConstraints.NONE;
        gbcFunctionsPanel.weighty = 0;
        gbcFunctionsPanel.weightx = 1;
        gbcFunctionsPanel.anchor = GridBagConstraints.SOUTH;
        gbcFunctionsPanel.insets = new Insets(10, 0, 20, 0);
        gbFunctionsPanel.setConstraints(btLogOutButton, gbcFunctionsPanel);
        pnFunctionsPanel.add(btLogOutButton);

        gbcTablesPanel.gridx = gbcTablesPanel.gridy = 0;
        gbcTablesPanel.anchor = GridBagConstraints.NORTH;
        gbcTablesPanel.fill = GridBagConstraints.NONE;
        gbcTablesPanel.weightx = 1;
        gbcTablesPanel.weighty = 1;
        int columns = 5;

        tableButtons = new ArrayList<>();
        for (TableSpecification t : tables) {
            TableButton tableButton = new TableButton((TableClass) t);
            tableButtons.add(tableButton);
            gbTablesPanel.setConstraints(tableButton, gbcTablesPanel);
            tableButton.addActionListener(this);
            pnTablesPanel.add(tableButton);
            gbcTablesPanel.gridx += 1;
            if (gbcTablesPanel.gridx == columns) {
                gbcTablesPanel.gridy += 1;
                gbcTablesPanel.gridx = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (TableButton tableButton : tableButtons) {
            if (e.getSource() == tableButton) {
                displayedTable.dispose();
                displayedTable = new Table(tableButton, foods, drinks);
            }
        }

        if (e.getSource() == btLockButton) {
            setVisible(false);
            lock();
        }

        if (e.getSource() == btLogOutButton) {
            dispose();
            new StartUpPanel();
        }
    }

    private void lock() { new LockScreen(waiter, this); }

}