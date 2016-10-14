package net.gavrilyuk.countries_ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 *
 * Created by Igor Gavryliuk on 11.10.2016.
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    private ImageIcon getScaledImage(ImageIcon srcImg, int w, int h){
        Image image = srcImg.getImage(); // transform it
        Image newImg = image.getScaledInstance(w,h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newImg); // transform it back
    }


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        //lbl.setText((String) value);
        JLabel label = new JLabel();
        if (value != null) {
            label.setHorizontalAlignment(JLabel.CENTER);
            //value is parameter which filled by country code
            ImageIcon flag = new ImageIcon("res/flags/" + String.valueOf(value) + ".gif");
            //System.out.println("res/flags/"+String.valueOf(value)+".gif");
            label.setIcon(getScaledImage(flag, 128, 84));

        }
        return label;
    }
}
