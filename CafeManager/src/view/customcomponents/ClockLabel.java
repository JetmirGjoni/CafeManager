package view.customcomponents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockLabel extends JLabel {
    private SimpleDateFormat clockFormatter;
    private Calendar cal;
    private String clockString;
    private Timer timer;

    public ClockLabel(String text){
        super(text, SwingConstants.CENTER);
        clockFormatter = new SimpleDateFormat("hh:mm");

        Action updateClock = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClock();
            }
        };

        timer = new Timer(5000, updateClock);
        timer.setRepeats(true);
        timer.start();
    }

    public void updateClock() {
        cal = Calendar.getInstance();
        clockString = clockFormatter.format(cal.getTime());
        if(cal.get(Calendar.AM_PM) == 0)
            clockString += " AM";
        else
            clockString += " PM";

        setText(clockString);
        revalidate();
    }
}
