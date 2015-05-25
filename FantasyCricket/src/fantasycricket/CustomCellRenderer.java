/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasycricket;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *@author Sunildev Birbal
 *@registration number 12/0719/2653 
 */
public class CustomCellRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent
    (JList list, Object value, int index,
     boolean isSelected,boolean cellHasFocus) {
     Component component = (Component)value;
     component.setBackground
      (isSelected ? Color.red : Color.white);
     component.setForeground
      (isSelected ? Color.red : Color.black);
     return component;
     }
   
    
   

}
