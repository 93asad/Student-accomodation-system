import model.*;

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;

public class AptListDisplay extends JPanel implements View
{   
    private Tower tower;
    private DefaultListModel listModel = new DefaultListModel();
    private JList list = new JList (listModel);

    public AptListDisplay(Tower tower)
    {   
        this.tower = tower;
        tower.attach(this);
        setup();
        build();
    }

    private void setup()
    {   
        setPreferredSize(new Dimension(200, 200)); 
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setBackground(Color.white);
        list.setFixedCellWidth(198);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListListener());
    } 

    private void build()
    {   
        add(list);
        update();
    }

    public void update()
    {   
        listModel.clear();
        for (String apartment: tower.used())
            listModel.addElement(apartment);
    }
    
    private class ListListener implements ListSelectionListener
    {   
        public void valueChanged(ListSelectionEvent e)
        {       
            if (e.getValueIsAdjusting())
                return;
            int selection = list.getSelectedIndex();
            if (selection == -1)     
                return;
            String aptID = (String)list.getSelectedValue();
            Apt apt = tower.apt(Integer.parseInt(aptID)); 
            new AptWindow(tower, apt);      //Since AptPanel needs to be updated, tower is passed to attach AptPanel
        }
    }
}