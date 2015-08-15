import model.*;

import java.awt.*;
import javax.swing.*;

public class Root extends JFrame 
{   public static void main(String[] args)
    {  
        new Root(new Tower());   
    }

    public Root(Tower tower)
    {   setup();
        build(tower);
        pack();
        setVisible(true);  
    }

    private void setup()
    {   
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build(Tower tower)
    {   
        add(new Panel(tower));
    }

    public class Panel extends JPanel 
    {   
        public Panel(Tower tower)
        {   
            setup();
            build(tower);
        }

        private void setup()
        {   
            setLayout(new FlowLayout());
        }

        private void build(Tower tower)
        {   
            add(new InputPanel(tower));
            add(new AptListDisplay(tower));
        }
    }
}
