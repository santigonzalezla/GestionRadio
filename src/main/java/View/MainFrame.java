package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener
{
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel rightphotoLbl;
    private JLabel leftphotologoLbl;
    private JLabel welcomeLbl;
    private JLabel introLbl;
    private JPasswordField passwordTextField;
    private JButton musicaccessBtn;
    private JButton adminaccessBtn;

    public MainFrame()
    {
        super("TRENDYBEATS");
        setDefaultLookAndFeelDecorated(true);
        initComponents();
    }

    private void initComponents()
    {
        setLayout(new GridLayout(1, 2));
        setResizable(false);

        //Prepare JFrame
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Initialize Components
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        rightphotoLbl = new JLabel();
        leftphotologoLbl = new JLabel();
        welcomeLbl = new JLabel("Welcome Back");
        introLbl = new JLabel("<html><body align='justify'>Please enter your password to open the admin section of TrendyBeats application. To listen to music, please click the music access button.</body></html>");
        passwordTextField = new JPasswordField();
        musicaccessBtn = new JButton("Listen To Music!");
        adminaccessBtn = new JButton("Go To Admin Panel");

        //Add Components
        add(leftPanel);
        add(rightPanel);

        //Edit Components
        leftPanel.setBackground(Color.white);
        rightPanel.setBackground(Color.decode("#2B0548"));

        //Prepare Right JPanel
        rightPanel.setLayout(null);
        rightPanel.add(rightphotoLbl);
        rightphotoLbl.setBounds(55,5,600,600);

        //Prepare Left JPanel
        leftPanel.setLayout(null);
        //leftPanel.setDefaultLookAndFeelDecorated(true);
        leftPanel.add(leftphotologoLbl);
        leftPanel.add(welcomeLbl);
        leftPanel.add(introLbl);
        leftPanel.add(passwordTextField);
        leftPanel.add(musicaccessBtn);
        leftPanel.add(adminaccessBtn);

        welcomeLbl.setBounds(115,110,500,100);
        introLbl.setBounds(80,170,350,100);
        leftphotologoLbl.setBounds(200,30,100,100);
        passwordTextField.setBounds(80,260,350,40);
        adminaccessBtn.setBounds(80,305,350,40);
        musicaccessBtn.setBounds(80,400,350,40);

        welcomeLbl.setFont(new Font("Montserrat Bold", 0,32));
        welcomeLbl.setForeground(Color.decode("#2B0548"));
        introLbl.setFont(new Font("Montserrat", 0,12));
        passwordTextField.setFont(new Font("Montserrat Bold", Font.BOLD,20));
        adminaccessBtn.setFont(new Font("Montserrat Bold", 0,17));
        musicaccessBtn.setFont(new Font("Montserrat Bold", 0,17));

        adminaccessBtn.setForeground(Color.white);
        adminaccessBtn.setBackground(Color.decode("#2B0548"));

        musicaccessBtn.setForeground(Color.white);
        musicaccessBtn.setBackground(Color.decode("#2B0548"));

        //Button Listeners
        musicaccessBtn.addActionListener(this);
        adminaccessBtn.addActionListener(this);

        //Adding photos
        try
        {
            /*
            BufferedImage bufferedImage = ImageIO.read(new File("src/main/java/Images/MUSIC3.png"));
            Image image = bufferedImage.getScaledInstance(rightphotoLbl.getWidth()-200, rightphotoLbl.getHeight()-200, Image.SCALE_AREA_AVERAGING);
            ImageIcon icon = new ImageIcon(image);
            rightphotoLbl.setIcon(icon);

            BufferedImage bufferedImage2 = ImageIO.read(new File("src/main/java/Images/LOGO.png"));
            Image image2 = bufferedImage2.getScaledInstance(leftphotologoLbl.getWidth(), leftphotologoLbl.getHeight(), Image.SCALE_AREA_AVERAGING);
            ImageIcon icon2 = new ImageIcon(image2);
            leftphotologoLbl.setIcon(icon2);
            */
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //Button Package
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == musicaccessBtn)
        {
            MusicFrame musicFrame = new MusicFrame();
            musicFrame.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == adminaccessBtn)
        {
            if (passwordTextField.getText().equals(""))
            {
                AdminFrame adminFrame = new AdminFrame();
                adminFrame.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong Password", "#404", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
