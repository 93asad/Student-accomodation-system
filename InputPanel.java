import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputPanel extends JPanel implements View
{   
    private Tower tower;
    private TextField nameField;
    private JButton addButton; 
    private JButton moveButton;

    public InputPanel(Tower tower)
    {   
        this.tower = tower;
        tower.attach(this);
        setup();
        build();
    }

    private void setup()
    {   
        setLayout(new GridLayout(2, 1));
    }

    private void build()
    {   
        Box field = Box.createVerticalBox();
        field.add(new JLabel("Student"));
        field.add(nameField = new TextField(15));
        Box buttons = Box.createHorizontalBox();
        buttons.add(addButton = button("Add", new AddListener()));
        buttons.add(Box.createHorizontalStrut(5));
        buttons.add(moveButton = button("Move", new MoveListener()));
        add(field);
        add(buttons); 
        update();
    }

    private JButton button(String label, ActionListener listener)
    {   
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    public void update()
    {   
        nameField.setText("");   
    }

    private class AddListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {   
            tower.add(nameField.getText());
        }
    }

    private class MoveListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {   
            tower.move(nameField.getText());
        }
    }
}