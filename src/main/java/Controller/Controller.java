package Controller;

import Model.Dao.BroadcastStationDao;
import Model.Dao.MusicProgramDao;
import Model.Dao.MusicalTrackDao;
import Model.Dto.BroadcastStationDto;
import Model.Dto.MusicalTrackDto;
import View.MainFrame;

public class Controller
{
    private MainFrame mainFrame;
    private MusicalTrackDao musicalTrackDao;
    private MusicProgramDao musicProgramDao;
    private BroadcastStationDao broadcastStationDao;

    public Controller()
    {
        mainFrame = new MainFrame();
        musicalTrackDao = new MusicalTrackDao();
        musicProgramDao = new MusicProgramDao();
        broadcastStationDao = new BroadcastStationDao();
    }

    public void start()
    {
        mainFrame.setVisible(true);
    }

    public void saveObject(Object o){
        if (o instanceof BroadcastStationDto){
            broadcastStationDao.saveInstance((BroadcastStationDto) o);
        }else if (o instanceof MusicalTrackDto){

        }
    }
}
