import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class AptPanel extends JPanel implements View
{   
    private Apt apt;
    private TableModel model; 
    private JTable table;
    private Tower tower;

    AptPanel(Tower tower, Apt apt)
    {   
        this.tower = tower;
        this.apt = apt;
        setup();
        build();
        tower.attach(this);
    }

    private void setup()
    {   
        setPreferredSize(new Dimension(250, 100));
        setBorder(BorderFactory.createLineBorder(Color.green));
    }

    private void build()
    {   
        model = new TableModel();
        table = new JTable(model);
        add(table.getTableHeader());
        add(table);
    }

    public void update()
    {   
        model.fireTableDataChanged();
    }

    private class TableModel extends AbstractTableModel
    {   
        private final int COLS = 2; 
        private final String[] headers = {"Bed", "Student"};

        public int getRowCount()
        {   
            return apt.size();  
        }

        public int getColumnCount()
        {   
            return COLS;
        }

        public String getColumnName(int col)
        {
            return headers[col]; 
        }

        public Object getValueAt(int row, int col)
        {   
            Room room = apt.rooms().get(row);
            switch (col) 
            { 
                case 0: return room.id(); 
                case 1: if (room.isUsed())
                            return room.student().name();  
                default: return ""; 
            }
        }
    }
}