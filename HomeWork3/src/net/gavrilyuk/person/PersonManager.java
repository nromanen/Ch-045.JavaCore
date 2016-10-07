package net.gavrilyuk.person;


import javax.swing.*;

/**
 * Person Manager Class
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class PersonManager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new PersonWindow("Person Manager").setVisible(true);
            }
        });

    }
}
