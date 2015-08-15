import model.*;

import java.awt.*;
import javax.swing.*;

public class AptWindow extends JFrame
{   
    AptWindow(Tower tower, Apt apt)
    {   
        setup(apt);
        build(tower, apt);
        pack();
        setVisible(true);
    }

    private void setup(Apt apt)
    {   
        setLocation(900, 500);
        setTitle("Apartment " + apt.id());
    }
    
    private void build(Tower tower, Apt apt)
    {   
        add(new AptPanel(tower, apt));
    }
}