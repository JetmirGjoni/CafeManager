package view.adminmenu;

import model.*;
import model.filemanager.FileLoader;
import view.customcomponents.Butonat;
import view.customcomponents.FushatETekstit;
import view.customcomponents.Labelat;
import view.waitermenu.WaiterMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * The type Start up panel.
 */
public class StartUpPanel extends JFrame implements ActionListener {

    /**
     * The Butonat.
     */
    public Butonat butonat = new Butonat();
    /**
     * The Labelat.
     */
    public Labelat labelat = new Labelat();
    /**
     * The Fushat e tekstit.
     */
    public FushatETekstit fushatETekstit = new FushatETekstit();

    /**
     * The Log in button.
     */
    public JButton logInButton = butonat.logIn(200,200,70,30);
    /**
     * The Admin panel button.
     */
    public JButton adminPanelButton = butonat.administrator(0,0,70,30);
    /**
     * The Waiter panel button.
     */
    public JButton waiterPanelButton = butonat.waiterMenuButton(70,0,70,30);
    /**
     * The User name field.
     */
    public JTextField userNameField = fushatETekstit.userName(165 , 125 , 150,25);
    /**
     * The Password field.
     */
    public JPasswordField passwordField =fushatETekstit.password(165 , 160 , 150 ,25);

    /**
     * The Tables.
     */
    static ArrayList<TableSpecification> tables;
    /**
     * The Drinks.
     */
    static ArrayList<DrinkClass> drinks;
    /**
     * The Waiters.
     */
    static ArrayList<WaiterSpecification> waiters;
    /**
     * The Foods.
     */
    static ArrayList<FoodClass> foods;

    private boolean adminPanelOpened;

    /**
     * Instantiates a new Start up panel.
     */
    public StartUpPanel(){
        FileLoader fileLoader = new FileLoader();
        tables = fileLoader.loadOrders();
        foods = fileLoader.loadFoods();
        drinks = fileLoader.loadDrinks();
        waiters = fileLoader.loadWaiters();

        setContentPane(waiterLogInPaenl());
        actionListenerAdder();
        setTitle("Cafe Management: Log In");
        setSize(500,600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Action listener adder.
     */
    public void actionListenerAdder(){
        logInButton.addActionListener(this);
        adminPanelButton.addActionListener(this);
        waiterPanelButton.addActionListener(this);
        userNameField.addActionListener(this);
        passwordField.addActionListener(this);
    }

    /**
     * Clear parameters.
     */
    public void clearParameters(){
        userNameField.setText(null);
        passwordField.setText(null);
    }

    /**
     * Admin log in panel container.
     *
     * @return the container
     */
    public Container adminLogInPanel(){
        Container p1 = getContentPane();

        p1.add(adminPanelButton);
        p1.add(waiterPanelButton);
        p1.add(userNameField);
        p1.add(passwordField);
        p1.add(labelat.username(100,125,70,25));
        p1.add(labelat.password(100,160,70,25));
        p1.add(labelat.adminMenuText(80, -50,400,200));
        p1.add(logInButton);

        p1.add(labelat.emptyLabel(1,1,1,1));
        adminPanelOpened = true;

        return p1;
    }

    /**
     * Waiter log in paenl container.
     *
     * @return the container
     */
    public Container waiterLogInPaenl(){
        Container p1 = getContentPane();

        p1.add(adminPanelButton);
        p1.add(waiterPanelButton);
        p1.add(userNameField);
        p1.add(passwordField);
        p1.add(labelat.username(100,125,70,25));
        p1.add(labelat.password(100,160,70,25));
        p1.add(labelat.waiterMenuText(80, -50,400,200));
        p1.add(logInButton);
        p1.add(labelat.emptyLabel(1,1,1,1));

        adminPanelOpened = false;

        return p1;
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==logInButton) {
            login();
        }
        if(e.getSource()==adminPanelButton){
            getContentPane().removeAll();
            setContentPane(adminLogInPanel());
            clearParameters();
        }
        if(e.getSource()==waiterPanelButton){
            getContentPane().removeAll();
            setContentPane(waiterLogInPaenl());
            clearParameters();
        }

    }

    /**
     * Login.
     */
    public void login(){
        String id = userNameField.getText();
        String password = passwordField.getText();
        if(adminPanelOpened){
            if(id.equals("admin") && password.equals("admin")){
                JOptionPane.showMessageDialog(null, "Login Successful.");
                new AdminMenu(waiters, tables, foods, drinks);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect login data. Try again!");
                clearParameters();
            }
        }
        else{
            for(WaiterSpecification waiter: waiters){
                //if login successful
                if(waiter.getID().equals(id) && waiter.getPassword().equals(password)){

                    JOptionPane.showMessageDialog(null, "Login Successful.");
                    new WaiterMenu(waiter, tables, foods, drinks);
                    dispose();

                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect id or password. Try again!");
                    clearParameters();
                }
            }
        }
    }

}
