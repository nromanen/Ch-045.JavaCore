package net.gavrilyuk.employee;

import javax.swing.*;

/**
 *
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class EmployeeManager {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeWindow("Employee Manager").setVisible(true);
            }
        });
    }
}
