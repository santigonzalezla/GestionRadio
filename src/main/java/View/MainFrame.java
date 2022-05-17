package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("EL CHIRINGUITO");
        initComponents();
    }

    private void initComponents()
    {
        setLayout(null);

        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
