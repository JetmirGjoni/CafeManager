package view.waitermenu;

import model.WaiterClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LockScreen extends JFrame {

    private WaiterClass waiter;

    private JPanel pnLockPanel;

    private JPanel pnLogInPanel;
    private JLabel lbUserPhotoLabel;
    private JLabel lbWaiterNameLabel;
    private JTextField tfPasswordField;
    private JButton btLogInButton;

    public LockScreen(WaiterClass waiter, JFrame waiterMenu){

        waiterMenu.setVisible(false);

        setWaiter(waiter);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);

        Action logInAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfPasswordField.getText().equals(waiter.getPassword())){
                    dispose();
                    waiterMenu.setVisible(true);
                }
                else{
                    tfPasswordField.setText("");
                    JOptionPane.showMessageDialog(null, "Wrong password. Try again!");
                }
            }
        };

        btLogInButton.addActionListener(logInAction);
        tfPasswordField.addActionListener(logInAction);
    }

    private void setWaiter(WaiterClass waiter){
        this.waiter = waiter;

        pnLockPanel = new JPanel();
        GridBagLayout gbLockPanel = new GridBagLayout();
        GridBagConstraints gbcLockPanel = new GridBagConstraints();
        pnLockPanel.setLayout( gbLockPanel );

        pnLogInPanel = new JPanel();
        GridBagLayout gbLogInPanel = new GridBagLayout();
        GridBagConstraints gbcLogInPanel = new GridBagConstraints();
        pnLogInPanel.setLayout( gbLogInPanel );
        lbUserPhotoLabel = new JLabel( new ImageIcon("resources/util/images/User Photo.png")  , SwingConstants.CENTER);
        gbcLogInPanel.gridx = 3;
        gbcLogInPanel.gridy = 0;
        gbcLogInPanel.gridwidth = 4;
        gbcLogInPanel.gridheight = 4;
        gbcLogInPanel.fill = GridBagConstraints.BOTH;
        gbcLogInPanel.weightx = 1;
        gbcLogInPanel.weighty = 1;
        gbcLogInPanel.anchor = GridBagConstraints.CENTER;
        gbLogInPanel.setConstraints( lbUserPhotoLabel, gbcLogInPanel );
        pnLogInPanel.add( lbUserPhotoLabel );

        lbWaiterNameLabel = new JLabel( waiter.getFirstName() ,SwingConstants.CENTER );
        lbWaiterNameLabel.setFont(new Font(null, 0,20));
        gbcLogInPanel.gridx = 1;
        gbcLogInPanel.gridy = 4;
        gbcLogInPanel.gridwidth = 15;
        gbcLogInPanel.gridheight = 1;
        gbcLogInPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcLogInPanel.weightx = 1;
        gbcLogInPanel.weighty = 1;
        gbcLogInPanel.anchor = GridBagConstraints.CENTER;
        gbcLogInPanel.insets = new Insets(20,10,10,10);
        gbLogInPanel.setConstraints( lbWaiterNameLabel, gbcLogInPanel );
        pnLogInPanel.add( lbWaiterNameLabel );

        tfPasswordField = new JPasswordField( );
        gbcLogInPanel.gridx = 0;
        gbcLogInPanel.gridy = 5;
        gbcLogInPanel.gridwidth = 8;
        gbcLogInPanel.gridheight = 1;
        gbcLogInPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcLogInPanel.weightx = 1;
        gbcLogInPanel.weighty = 1;
        gbcLogInPanel.anchor = GridBagConstraints.EAST;
        gbcLogInPanel.insets = new Insets(10,0,15, 43);
        gbLogInPanel.setConstraints( tfPasswordField, gbcLogInPanel );
        tfPasswordField.requestFocus();
        pnLogInPanel.add( tfPasswordField );

        btLogInButton = new JButton( "→"  );
        gbcLogInPanel.gridx = 6;
        gbcLogInPanel.gridy = 5;
        gbcLogInPanel.gridwidth = 1;
        gbcLogInPanel.gridheight = 1;
        gbcLogInPanel.fill = GridBagConstraints.NONE;
        gbcLogInPanel.weightx = 0;
        gbcLogInPanel.weighty = 1;
        gbcLogInPanel.anchor = GridBagConstraints.EAST;
        gbcLogInPanel.insets = new Insets(10,0,15,0);
        gbLogInPanel.setConstraints( btLogInButton, gbcLogInPanel );
        pnLogInPanel.add( btLogInButton );

        gbcLockPanel.gridx = 0;
        gbcLockPanel.gridy = 0;
        gbcLockPanel.gridwidth = 1;
        gbcLockPanel.gridheight = 1;
        gbcLockPanel.fill = GridBagConstraints.NONE;
        gbcLockPanel.weightx = 1;
        gbcLockPanel.weighty = 1;
        gbcLockPanel.anchor = GridBagConstraints.CENTER;
        gbLockPanel.setConstraints( pnLogInPanel, gbcLockPanel );
        pnLockPanel.add( pnLogInPanel );
        pnLockPanel.setBackground(Color.lightGray);
        pnLogInPanel.setBackground(pnLockPanel.getBackground());

        setContentPane(pnLockPanel);
        revalidate();
    }
}
