package net.students;


import net.students.ui.StudentsWindow;

import javax.swing.*;

/**
 *
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class StudentsManager {
    public static void main(String[] args) {
        //logger
       /* try {
            LogManager.getLogManager().readConfiguration(
                    StudentsManager.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new StudentsWindow("Students Manager").setVisible(true);
            }
        });

    }
}
