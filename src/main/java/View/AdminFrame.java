package View;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminFrame extends JFrame implements ActionListener
{
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel welcomeLbl;
    private JLabel infoLbl;
    private JLabel rightphotoLbl;

    private JLabel broadcastCreateLbl;
    private JLabel broadcastNameLbl;
    private JLabel broadcastDescriptionLbl;
    private JLabel broadcastTypeLbl;
    private JLabel broadcastMusicLbl;

    private JLabel musicCreateLbl;
    private JLabel musicNameLbl;
    private JLabel musicArtistLbl;
    private JLabel musicGenreLbl;
    private JLabel musicFileLbl;

    private JLabel broadcastListLbl;
    private JLabel musicListLbl;

    private JTextField broadcastNameTxt;
    private JTextField broadcastDescriptionTxt;
    private JTextField broadcastTypeTxt;
    private JTextField broadcastMusicTxt;

    private JTextField musicNameTxt;
    private JTextField musicArtistTxt;
    private JTextField musicGenreTxt;
    private JTextField musicFileTxt;

    private JComboBox broadcastCombobox;
    private JComboBox musicCombobox;

    private JButton broadcastBtn;
    private JButton musicBtn;
    private JButton programBtn;
    private JButton createBtn;
    private JButton addBroadcastBtn;
    private JButton addMusicBtn;
    private JButton backBtn;

    private int option;

    public AdminFrame()
    {
        super("TRENDYBEATS");
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 2));
        setDefaultLookAndFeelDecorated(true);
        setResizable(false);

        //Prepare JFrame
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Initialize Components
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        welcomeLbl = new JLabel("Welcome Admin");
        infoLbl = new JLabel("<html><body align='justify'>Please select an option to continue. To create a new broadcast click the broadcast option. If you want to create a new program, please click on the program button. To add a new song press the music button. If you select the broadcast button you will need to add the name, the type of transmition and, the musical genre. In case you chose the music button, create each song and select the file to add it to the application. If the program button is selected at least one song has to be added for you to create a program.</body></html>");
        rightphotoLbl = new JLabel();

        broadcastCreateLbl = new JLabel("Create your Broadcast!");
        broadcastNameLbl = new JLabel("Broadcast Name:");
        broadcastDescriptionLbl = new JLabel("Broadcast Description:");
        broadcastTypeLbl = new JLabel("Broadcast Type:");
        broadcastMusicLbl = new JLabel("Broadcast Music:");

        musicCreateLbl = new JLabel("Create your Music!");
        musicNameLbl = new JLabel("Music Name:");
        musicArtistLbl = new JLabel("Music Artist:");
        musicGenreLbl = new JLabel("Music Genre:");
        musicFileLbl = new JLabel("Music File:");

        broadcastListLbl = new JLabel("Broadcast List:");
        musicListLbl = new JLabel("Music List:");

        broadcastNameTxt = new JTextField();
        broadcastDescriptionTxt = new JTextField();
        broadcastTypeTxt = new JTextField();
        broadcastMusicTxt = new JTextField();

        musicNameTxt = new JTextField();
        musicArtistTxt = new JTextField();
        musicGenreTxt = new JTextField();
        musicFileTxt = new JTextField();

        broadcastCombobox = new JComboBox();
        musicCombobox = new JComboBox();

        broadcastBtn = new JButton("Broadcast");
        musicBtn = new JButton("Music");
        programBtn = new JButton("Program");
        createBtn = new JButton("Create");
        addBroadcastBtn = new JButton("Add Broadcast");
        addMusicBtn = new JButton("Add Music");
        backBtn = new JButton("\uD83E\uDC68");

        option = 0;

        //Add Components
        add(leftPanel);
        add(rightPanel);

        //Prepare Left Panel
        leftPanel.setLayout(null);

        //Prepare Right Panel
        rightPanel.setLayout(null);

        //Add Left Panel Components
        leftPanel.add(welcomeLbl);
        leftPanel.add(infoLbl);
        leftPanel.add(broadcastBtn);
        leftPanel.add(musicBtn);
        leftPanel.add(programBtn);
        leftPanel.add(backBtn);

        //Add Right Panel Components
        rightPanel.add(rightphotoLbl);

        //Edit Components
        leftPanel.setBackground(Color.white);
        rightPanel.setBackground(Color.decode("#2B0548"));

        //Edit Left Panel Components
        welcomeLbl.setBounds(90,20,300,100);
        infoLbl.setBounds(80,80,350,200);
        broadcastBtn.setBounds(80,305,350,40);
        musicBtn.setBounds(80,350,350,40);
        programBtn.setBounds(80,395,350,40);

        welcomeLbl.setFont(new Font("Montserrat", Font.BOLD, 20));
        welcomeLbl.setForeground(Color.decode("#2B0548"));
        infoLbl.setFont(new Font("Montserrat", Font.PLAIN, 12));

        broadcastBtn.setForeground(Color.white);
        broadcastBtn.setBackground(Color.decode("#2B0548"));
        broadcastBtn.setFont(new Font("Montserrat", Font.BOLD, 17));
        musicBtn.setForeground(Color.white);
        musicBtn.setBackground(Color.decode("#2B0548"));
        musicBtn.setFont(new Font("Montserrat", Font.BOLD, 17));
        programBtn.setForeground(Color.white);
        programBtn.setBackground(Color.decode("#2B0548"));
        programBtn.setFont(new Font("Montserrat", Font.BOLD, 17));
        backBtn.setBounds(0,0,40,40);
        backBtn.setForeground(Color.decode("#2B0548"));
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);

        //Edit Right Panel Components
        rightphotoLbl.setBounds(50,50,400,400);

        //Button Listeners
        broadcastBtn.addActionListener(this);
        musicBtn.addActionListener(this);
        programBtn.addActionListener(this);
        createBtn.addActionListener(this);
        addBroadcastBtn.addActionListener(this);
        addMusicBtn.addActionListener(this);
        broadcastCombobox.addActionListener(this);
        musicCombobox.addActionListener(this);
        backBtn.addActionListener(this);

        //Mouse Listener
        broadcastCombobox.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }
        });

        musicCombobox.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }
        });

        //Adding photos
        try
        {
            /*
            BufferedImage bufferedImage = ImageIO.read(new File("src/main/java/Images/LOGO.png"));
            Image image = bufferedImage.getScaledInstance(rightphotoLbl.getWidth(), rightphotoLbl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            rightphotoLbl.setIcon(icon);
             */
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        if (e.getSource() == backBtn)
        {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == createBtn)
        {
            if (option == 1)
            {
                //Create Broadcast
                JOptionPane.showMessageDialog(null, "Broadcast Created");
                option = 0;
            }
            else if(option == 2)
            {
                //Create Music
                JOptionPane.showMessageDialog(null, "Music Created");
                option = 0;
            }
            else if(option == 3)
            {
                //Create Program
                JOptionPane.showMessageDialog(null, "Program Created");
                option = 0;
            }
        }

        if(option == 0)
        {
            if(e.getSource() == broadcastBtn)
            {
                rightPanel.removeAll();
                rightPanel.repaint();
                fillbroadcastPanel();
                option = 1;
            }

            if (e.getSource() == musicBtn)
            {
                rightPanel.removeAll();
                rightPanel.repaint();
                fillmusicPanel();
                option = 2;
            }

            if (e.getSource() == programBtn)
            {
                rightPanel.removeAll();
                rightPanel.repaint();
                fillprogramPanel();
                option = 3;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please finish the current instance before starting a new one.");
        }
    }

    private void fillbroadcastPanel()
    {
        rightPanel.add(broadcastCreateLbl);
        rightPanel.add(broadcastNameLbl);
        rightPanel.add(broadcastDescriptionLbl);
        rightPanel.add(broadcastTypeLbl);
        rightPanel.add(broadcastMusicLbl);
        rightPanel.add(broadcastNameTxt);
        rightPanel.add(broadcastDescriptionTxt);
        rightPanel.add(broadcastTypeTxt);
        rightPanel.add(broadcastMusicTxt);
        rightPanel.add(createBtn);

        broadcastCreateLbl.setBounds(130,60,400,25);
        broadcastNameLbl.setBounds(80, 110, 350, 20);
        broadcastDescriptionLbl.setBounds(80, 180, 350, 20);
        broadcastTypeLbl.setBounds(80, 250, 350, 20);
        broadcastMusicLbl.setBounds(80, 320, 350, 20);

        broadcastNameTxt.setBounds(80, 130, 350, 40);
        broadcastDescriptionTxt.setBounds(80, 200, 350, 40);
        broadcastTypeTxt.setBounds(80, 270, 350, 40);
        broadcastMusicTxt.setBounds(80, 340, 350, 40);
        createBtn.setBounds(80, 410, 350, 40);

        broadcastCreateLbl.setFont(new Font("Montserrat", Font.BOLD, 20));
        broadcastNameLbl.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastDescriptionLbl.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastTypeLbl.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastMusicLbl.setFont(new Font("Montserrat Bold", 0, 17));

        broadcastNameTxt.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastDescriptionTxt.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastTypeTxt.setFont(new Font("Montserrat Bold", 0, 17));
        broadcastMusicTxt.setFont(new Font("Montserrat Bold", 0, 17));

        broadcastCreateLbl.setForeground(Color.white);
        broadcastNameLbl.setForeground(Color.white);
        broadcastDescriptionLbl.setForeground(Color.white);
        broadcastTypeLbl.setForeground(Color.white);
        broadcastMusicLbl.setForeground(Color.white);

        createBtn.setForeground(Color.white);
        createBtn.setBackground(Color.decode("#2B0548"));
        createBtn.setFont(new Font("Montserrat", Font.BOLD, 17));
    }

    private void fillmusicPanel()
    {
        rightPanel.add(musicCreateLbl);
        rightPanel.add(musicNameLbl);
        rightPanel.add(musicArtistLbl);
        rightPanel.add(musicGenreLbl);
        rightPanel.add(musicFileLbl);
        rightPanel.add(musicNameTxt);
        rightPanel.add(musicArtistTxt);
        rightPanel.add(musicGenreTxt);
        rightPanel.add(musicFileTxt);
        rightPanel.add(createBtn);

        musicCreateLbl.setBounds(150,60,400,25);
        musicNameLbl.setBounds(80, 110, 350, 20);
        musicArtistLbl.setBounds(80, 180, 350, 20);
        musicGenreLbl.setBounds(80, 250, 350, 20);
        musicFileLbl.setBounds(80, 320, 350, 20);

        musicNameTxt.setBounds(80, 130, 350, 40);
        musicArtistTxt.setBounds(80, 200, 350, 40);
        musicGenreTxt.setBounds(80, 270, 350, 40);
        musicFileTxt.setBounds(80, 340, 350, 40);
        createBtn.setBounds(80, 410, 350, 40);

        musicCreateLbl.setFont(new Font("Montserrat", Font.BOLD, 20));
        musicNameLbl.setFont(new Font("Montserrat Bold", 0, 17));
        musicArtistLbl.setFont(new Font("Montserrat Bold", 0, 17));
        musicGenreLbl.setFont(new Font("Montserrat Bold", 0, 17));
        musicFileLbl.setFont(new Font("Montserrat Bold", 0, 17));

        musicNameTxt.setFont(new Font("Montserrat Bold", 0, 17));
        musicArtistTxt.setFont(new Font("Montserrat Bold", 0, 17));
        musicGenreTxt.setFont(new Font("Montserrat Bold", 0, 17));
        musicFileTxt.setFont(new Font("Montserrat Bold", 0, 17));

        musicCreateLbl.setForeground(Color.white);
        musicNameLbl.setForeground(Color.white);
        musicArtistLbl.setForeground(Color.white);
        musicGenreLbl.setForeground(Color.white);
        musicFileLbl.setForeground(Color.white);

        createBtn.setForeground(Color.white);
        createBtn.setBackground(Color.decode("#2B0548"));
        createBtn.setFont(new Font("Montserrat", Font.BOLD, 17));
    }

    private void fillprogramPanel()
    {
        rightPanel.add(broadcastListLbl);
        rightPanel.add(musicListLbl);
        rightPanel.add(broadcastCombobox);
        rightPanel.add(musicCombobox);
        rightPanel.add(addBroadcastBtn);
        rightPanel.add(addMusicBtn);

        broadcastCombobox.setMaximumRowCount(4);
        musicCombobox.setMaximumRowCount(4);

        broadcastListLbl.setBounds(80, 80, 350, 20);
        musicListLbl.setBounds(80, 300, 350, 20);

        broadcastCombobox.setBounds(80, 105, 350, 40);
        musicCombobox.setBounds(80, 325, 350, 40);

        addBroadcastBtn.setBounds(300, 150, 130, 30);
        addMusicBtn.setBounds(300, 370, 130, 30);

        broadcastListLbl.setFont(new Font("Montserrat Bold", 0, 17));
        musicListLbl.setFont(new Font("Montserrat Bold", 0, 17));

        broadcastListLbl.setForeground(Color.white);
        musicListLbl.setForeground(Color.white);

        broadcastCombobox.setBackground(Color.decode("#2B0548"));
        broadcastCombobox.setForeground(Color.white);
        broadcastCombobox.getEditor().getEditorComponent().setBackground(Color.decode("#2B0548"));
        broadcastCombobox.setFont(new Font("Montserrat", 0, 17));

        musicCombobox.setBackground(Color.decode("#2B0548"));
        musicCombobox.setForeground(Color.white);
        musicCombobox.setFont(new Font("Montserrat", 0, 17));

        addBroadcastBtn.setForeground(Color.white);
        addBroadcastBtn.setBackground(Color.decode("#2B0548"));
        addBroadcastBtn.setFont(new Font("Montserrat", Font.BOLD, 12));

        addMusicBtn.setForeground(Color.white);
        addMusicBtn.setBackground(Color.decode("#2B0548"));
        addMusicBtn.setFont(new Font("Montserrat", Font.BOLD, 12));
    }

    public void fillmusicCombobox(ArrayList<String> musicList)
    {
        for (String music : musicList)
        {
            musicCombobox.addItem(music);
        }
    }

    public void fillbroadcastCombobox(ArrayList<String> broadcastList)
    {
        for (String broadcast : broadcastList)
        {
            broadcastCombobox.addItem(broadcast);
        }
    }
}
