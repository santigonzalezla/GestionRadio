package View;

import Controller.Controller;
import Model.Dto.MusicProgramDto;
import Model.Dto.MusicalTrackDto;
import Util.List;
import Util.Node;
import Util.Player;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
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
    private ArrayList<JButton> musicBtnList;
    private JButton homeBtn;
    private JButton searchBtn;
    private JButton createBroadcastBtn;
    private JButton previousSongBtn;
    private JButton playBtn;
    private JButton nextSongBtn;
    private JButton muteBtn;
    private JButton backBtn;
    private Boolean isPlaying;
    private int optionPause;
    private Player player;
    private JFileChooser jFileChooser;
    private List reproductionList;
    private Node actual;
    private ArrayList <MusicProgramDto> musicProgramList;
    private ArrayList <MusicalTrackDto> musicList;
    /**
     * Constructor de la clase
     */
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
        volumeSlider = new JSlider();
        broadcastBtnList = new ArrayList<>();
        musicBtnList = new ArrayList<>();
        homeBtn = new JButton("Home");
        searchBtn = new JButton("Search");
        createBroadcastBtn = new JButton("Create Broadcast");
        previousSongBtn = new JButton("Previous Song");
        playBtn = new JButton("Play");
        nextSongBtn = new JButton("Next Song");
        muteBtn = new JButton("Mute");
        backBtn = new JButton("\uD83E\uDC68");
        isPlaying = false;
        optionPause = 0;

        reproductionList = new List();
        player = new Player();

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

        playBtn.addActionListener(this);
        nextSongBtn.addActionListener(this);
        previousSongBtn.addActionListener(this);
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
            if (optionPause == 0)
            {
                pauseActionPerformed(e);
                ImageIcon playIcon = new ImageIcon("src/main/java/Images/PlayIcon.png");
                Image playImg = playIcon.getImage();
                Image newplayImg = playImg.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
                playIcon = new ImageIcon(newplayImg);
                playBtn.setIcon(playIcon);
                optionPause = 1;
                }
            else
            {
                resumeActionPerformed(e);
                ImageIcon playIcon = new ImageIcon("src/main/java/Images/PauseIcon.png");
                Image playImg = playIcon.getImage();
                Image newplayImg = playImg.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
                playIcon = new ImageIcon(newplayImg);
                playBtn.setIcon(playIcon);
                JOptionPane.showMessageDialog(null, "Playing" + isPlaying);
                optionPause = 0;
            }
        }

        if (e.getSource() == nextSongBtn)
        {
            nextSongActionPerformed(e);
        }

        if (e.getSource() == previousSongBtn)
        {
            previousActionPerformed(e);
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
        musicPanel.setLayout(new GridLayout(10,2));
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
        bottomPanel.add(volumeSlider);
        bottomPanel.add(previousSongBtn);
        bottomPanel.add(playBtn);
        bottomPanel.add(nextSongBtn);
        bottomPanel.add(muteBtn);
        //bottomPanel.add(new JLabel("Copyright © 2022 TrendyBeats"));
        //bottomPanel.add(new JButton("About"));

        volumeSlider.setMaximum(1);
        volumeSlider.setMinimum(0);
        volumeSlider.setEnabled(true);

        //Edit Bottom Panel Components
        songNameLbl.setBounds(610,0,250,30);
        artistNameLbl.setBounds(610,10,250,40);
        songProgressBar.setBounds(420,40,450,10);
        volumeSlider.setBounds(1100,30,150,10);
        previousSongBtn.setBounds(70,10,40,40);
        playBtn.setBounds(120,10,40,40);
        nextSongBtn.setBounds(170,10,40,40);
        muteBtn.setBounds(1070,25,20,20);

        playBtn.setContentAreaFilled(false);
        playBtn.setBorderPainted(false);
        previousSongBtn.setContentAreaFilled(false);
        previousSongBtn.setBorderPainted(false);
        nextSongBtn.setContentAreaFilled(false);
        nextSongBtn.setBorderPainted(false);
        muteBtn.setContentAreaFilled(false);
        muteBtn.setBorderPainted(false);

        songNameLbl.setForeground(Color.white);
        songNameLbl.setFont(new Font("Montserrart", Font.BOLD, 12));

        artistNameLbl.setForeground(Color.white);
        artistNameLbl.setFont(new Font("Montserrart", 0, 12));


        ImageIcon playIcon = new ImageIcon("src/main/java/Images/PlayIcon.png");
        Image playImg = playIcon.getImage();
        Image newplayImg = playImg.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
        playIcon = new ImageIcon(newplayImg);
        playBtn.setIcon(playIcon);

        ImageIcon previousIcon = new ImageIcon("src/main/java/Images/BackIcon.png");
        Image previousImg = previousIcon.getImage();
        Image previousnewIcon = previousImg.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
        previousIcon = new ImageIcon(previousnewIcon);
        previousSongBtn.setIcon(previousIcon);

        ImageIcon nextIcon = new ImageIcon("src/main/java/Images/NextIcon.png");
        Image nextImage = nextIcon.getImage();
        Image newnextImg = nextImage.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
        nextIcon = new ImageIcon(newnextImg);
        nextSongBtn.setIcon(nextIcon);

        ImageIcon musicIcon = new ImageIcon("src/main/java/Images/SongIcon.png");
        Image image = musicIcon.getImage();
        Image newimg = image.getScaledInstance(15, 15,  Image.SCALE_AREA_AVERAGING);
        musicIcon = new ImageIcon(newimg);
        muteBtn.setIcon(musicIcon);

        volumeSlider.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                try
                {
                    player.controller.setGain(volumeSlider.getValue());
                }
                catch (Exception exception)
                {

                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
    }

    private void prepareMusicPanel()
    {
        for (String broadcastList: controller.showBroadcastStation())
        {
            String parts[] = broadcastList.split(";");
            broadcastBtnList.add(new JButton(parts[0]));
        }

        for (JButton btn : broadcastBtnList)
        {
            btn.setSize(new Dimension(450,40));
            btn.setBackground(Color.decode("#220129"));
            btn.setForeground(Color.white);
            btn.setFont(new Font("Montserrat Bold", 0, 20));
            musicPanel.add(btn);

            btn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (e.getSource() == btn)
                    {
                        musicPanel.removeAll();
                        musicPanel.repaint();
                        fillmusicPanel(btn.getText());
                    }
                }
            });
        }
    }
    /**
     * Método para asignar las listas de canciones de los Daos
     */
    private void fillmusicPanel(String broadcastName)
    {
        for (int i = 0; i < controller.musicProgramDao.musicProgramList.size(); i++)
        {
            if(controller.musicProgramDao.musicProgramList.get(i).getNameBroadcastProgram().equals(broadcastName))
            {
                musicList = controller.musicProgramDao.musicProgramList.get(i).getTracksMusicProgram();
            }
        }

        for (String broadcastList: controller.showMusicalTrack())
        {
            musicBtnList.add(new JButton(broadcastList));
        }

        for (JButton btn : musicBtnList)
        {
            btn.setSize(new Dimension(450,40));
            btn.setBackground(Color.decode("#220129"));
            btn.setForeground(Color.white);
            btn.setFont(new Font("Montserrat Bold", 0, 20));
            musicPanel.add(btn);

            btn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (e.getSource() == btn)
                    {
                        playActionPerformed(e);
                    }
                }
            });
        }

        for(int i = 0; i < musicList.size(); i++)
        {
            reproductionList.insertar(musicList.get(i).getNameMusicalTrack(),musicList.get(i).getFileMusicalTrack());
        }
    }
    /**
     * Método para reproducir música
     */
    private void playActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (reproductionList.IsEmpty())
        {
            JOptionPane.showMessageDialog(null, "No hay canciones");
        }
        else
        {
            ImageIcon playIcon = new ImageIcon("src/main/java/Images/PauseIcon.png");
            Image playImg = playIcon.getImage();
            Image newplayImg = playImg.getScaledInstance(30, 30,  Image.SCALE_AREA_AVERAGING);
            playIcon = new ImageIcon(newplayImg);
            playBtn.setIcon(playIcon);

            if (actual == null)
            {
                actual = reproductionList.first;
            }

            try
            {
                player.controller.open(new URL("file:///" + actual.direccion));
                player.controller.play();
                songNameLbl.setText(actual.nombre);
            }
            catch (Exception e)
            {

            }
        }
    }
    /**
     * Método para pasar a la siguiente canción
     */
    //Siguiente
    private void nextSongActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(actual==null)
        {
            return;
        }
        actual = actual.siguiente;
        playActionPerformed(evt);
    }
    /**
     *Método para reproducir la canción anterior
     */
    //Anterior
    private void previousActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(actual == null)
        {
            return;
        }
        actual = actual.anterior;
        playActionPerformed(evt);
    }
}
