package View;

import Controller.Controller;
import javazoom.jlgui.basicplayer.BasicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MusicFrame extends JFrame implements ActionListener
{
    private Controller controller;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel musicPanel;
    private JScrollPane musicScrollPane;
    private JLabel logophotoLbl;
    private JLabel titleLbl;
    private JLabel songNameLbl;
    private JLabel artistNameLbl;
    private JProgressBar songProgressBar;
    private JProgressBar volumeProgressBar;
    private ArrayList<JButton> broadcastBtnList;
    private JButton homeBtn;
    private JButton searchBtn;
    private JButton createBroadcastBtn;
    private JButton previousSongBtn;
    private JButton playBtn;
    private JButton nextSongBtn;
    private JButton muteBtn;
    private JButton backBtn;
    private BasicPlayer musicPlayer;

    public MusicFrame()
    {
        super("TRENDYBEATS");
        initComponents();
    }

    private void initComponents()
    {
        setLayout(null);
        setDefaultLookAndFeelDecorated(true);
        setResizable(false);

        //Prepare JFrame
        this.setSize(1300,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Initialize Components
        controller = new Controller();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        bottomPanel = new JPanel();
        musicPanel = new JPanel();
        musicScrollPane = new JScrollPane();
        logophotoLbl = new JLabel();
        titleLbl = new JLabel("How you doin!?");
        songNameLbl = new JLabel("Song Name");
        artistNameLbl = new JLabel("Artist Name");
        songProgressBar = new JProgressBar();
        volumeProgressBar = new JProgressBar();
        broadcastBtnList = new ArrayList<>();
        homeBtn = new JButton("Home");
        searchBtn = new JButton("Search");
        createBroadcastBtn = new JButton("Create Broadcast");
        previousSongBtn = new JButton("Previous Song");
        playBtn = new JButton("Play");
        nextSongBtn = new JButton("Next Song");
        muteBtn = new JButton("Mute");
        backBtn = new JButton("\uD83E\uDC68");
        musicPlayer = new BasicPlayer();

        //Add Components
        add(leftPanel);
        add(rightPanel);
        add(bottomPanel);

        //Edit JPanels
        leftPanel.setBounds(0,0,250,700);
        bottomPanel.setBounds(0,700,1300,100);
        rightPanel.setBounds(250,0,1050,700);

        //Prepare Left Panel
        prepareLeftPanel();

        //Prepare Right Panel
        prepareRightPanel();

        //Prepare Bottom Panel
        prepareBottomPanel();


        //Edit Components
        leftPanel.setBackground(Color.decode("#2B0548"));
        rightPanel.setBackground(Color.decode("#220129"));
        bottomPanel.setBackground(Color.decode("#300C4C"));

        backBtn.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == playBtn)
        {
            try
            {
                openFile("src/music/music.mp3");
                playMusic();
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }

        }

        if (e.getSource() == backBtn)
        {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            this.dispose();
        }
    }

    private void prepareLeftPanel()
    {
        //Edit Left Panel
        leftPanel.setLayout(null);

        //Add Left Panel Components
        leftPanel.add(backBtn);
        leftPanel.add(logophotoLbl);
        leftPanel.add(homeBtn);
        leftPanel.add(searchBtn);
        leftPanel.add(createBroadcastBtn);

        //Edit Left Panel Components
        backBtn.setBounds(0,0,40,40);
        logophotoLbl.setBounds(0,100,250,60);
        homeBtn.setBounds(0,160,250,60);
        searchBtn.setBounds(0,220,250,60);
        createBroadcastBtn.setBounds(0,320,250,60);

        homeBtn.setForeground(Color.white);
        homeBtn.setFont(new Font("Montserrart Bold", 0, 17));
        homeBtn.setContentAreaFilled(false);
        homeBtn.setBorderPainted(false);

        searchBtn.setForeground(Color.white);
        searchBtn.setFont(new Font("Montserrart Bold", 0, 17));
        searchBtn.setContentAreaFilled(false);
        searchBtn.setBorderPainted(false);

        createBroadcastBtn.setForeground(Color.white);
        createBroadcastBtn.setFont(new Font("Montserrart Bold", 0, 17));
        createBroadcastBtn.setContentAreaFilled(false);
        createBroadcastBtn.setBorderPainted(false);

        backBtn.setForeground(Color.white);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);

        try
        {
            /*
            logophotoLbl.setIcon(new ImageIcon("src/main/java/Images/LOGO RADIO.jpg"));
            ImageIcon homeIcon = new ImageIcon("src/main/java/Images/home.png");
            homeBtn.setIcon(homeIcon);
            JOptionPane.showMessageDialog(null, "Home Icon: "+ homeIcon.getIconHeight() + "x" + homeIcon.getIconWidth());
            ImageIcon searchIcon = new ImageIcon("src/main/java/Images/search.png");
            searchBtn.setIcon(searchIcon);
             */
        }
        catch (Exception e)
        {

        }
    }

    private void prepareRightPanel()
    {
        //Edit Right Panel
        rightPanel.setLayout(null);

        //Add Right Panel Components
        rightPanel.add(titleLbl);
        rightPanel.add(musicScrollPane);

        //Edit Right Panel Components
        titleLbl.setBounds(30,50,1050,50);
        musicScrollPane.setBounds(0,120,1040,580);
        musicScrollPane.setViewportView(musicPanel);
        musicScrollPane.getViewport().setView(musicPanel);
        musicScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        musicScrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#220129")));
        musicPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        musicPanel.setPreferredSize(new Dimension(1050,580));
        musicPanel.setBackground(Color.decode("#220129"));

        titleLbl.setForeground(Color.white);
        titleLbl.setFont(new Font("Montserrat Bold", 0,32));

        prepareMusicPanel();
    }

    private void prepareBottomPanel()
    {
        //Edit Bottom Panel
        bottomPanel.setLayout(null);

        //Add Bottom Panel Components
        bottomPanel.add(songNameLbl);
        bottomPanel.add(artistNameLbl);
        bottomPanel.add(songProgressBar);
        bottomPanel.add(volumeProgressBar);
        bottomPanel.add(previousSongBtn);
        bottomPanel.add(playBtn);
        bottomPanel.add(nextSongBtn);
        bottomPanel.add(muteBtn);
        //bottomPanel.add(new JLabel("Copyright © 2022 TrendyBeats"));
        //bottomPanel.add(new JButton("About"));

        //Edit Bottom Panel Components
        songNameLbl.setBounds(610,0,250,30);
        artistNameLbl.setBounds(610,10,250,40);
        songProgressBar.setBounds(420,40,450,10);
        volumeProgressBar.setBounds(1100,30,150,10);
        previousSongBtn.setBounds(70,10,40,40);
        playBtn.setBounds(120,10,40,40);
        nextSongBtn.setBounds(170,10,40,40);
        muteBtn.setBounds(1070,25,20,20);

        songNameLbl.setForeground(Color.white);
        songNameLbl.setFont(new Font("Montserrart", Font.BOLD, 12));

        artistNameLbl.setForeground(Color.white);
        artistNameLbl.setFont(new Font("Montserrart", 0, 12));
    }

    private void prepareMusicPanel()
    {
        for (String broadcastList: controller.showBroadcastStation())
        {
            String parts[] = broadcastList.split(";");
            ImageIcon homeIcon = new ImageIcon(parts[1]);
            broadcastBtnList.add(new JButton(homeIcon + " " + parts[0]));
        }

        for (JButton btn : broadcastBtnList)
        {
            musicPanel.add(btn);
        }
    }

    private void playMusic() throws Exception
    {
        musicPlayer.play();
    }

    private void openFile(String ruta) throws Exception
    {
        musicPlayer.open(new File(ruta));
    }

    private void pauseMusic() throws Exception
    {
        musicPlayer.pause();
    }

    private void resumeMusic() throws Exception
    {
        musicPlayer.resume();
    }

    private void stopMusic() throws Exception
    {
        musicPlayer.stop();
    }
}
