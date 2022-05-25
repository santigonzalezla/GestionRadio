package Controller;

import Model.Dao.*;
import Model.Dto.*;
import View.MainFrame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller
{
    private MusicalTrackDao musicalTrackDao;
    private MusicProgramDao musicProgramDao;
    private BroadcastStationDao broadcastStationDao;

    public Controller()
    {
        musicalTrackDao = new MusicalTrackDao();
        musicProgramDao = new MusicProgramDao();
        broadcastStationDao = new BroadcastStationDao();
    }

    public void saveObject(Object o)
    {
        if (o instanceof BroadcastStationDto)
        {
            broadcastStationDao.saveInstance((BroadcastStationDto) o);
        }
        else if (o instanceof MusicalTrackDto)
        {
            musicalTrackDao.saveInstance((MusicalTrackDto) o);
            musicProgramDao.saveInstance((MusicalTrackDto) o);
        }
        else if(o instanceof MusicProgramDto)
        {
            musicProgramDao.saveInstance((MusicProgramDto) o);
        }
    }

    public void deleteObject(Object o,Integer index)
    {
        if (o instanceof BroadcastStationDto)
        {
            broadcastStationDao.deleteInstance(index);
        }
        else if (o instanceof MusicalTrackDto)
        {
            musicalTrackDao.deleteInstance(index);
        }
        else if(o instanceof MusicProgramDto)
        {
            musicProgramDao.deleteInstance(index);
        }
    }

    public String showMusicProgram()
    {
        StringBuilder salida = new StringBuilder();
        salida.append(musicProgramDao.showList());
        return salida.toString();
    }

    public ArrayList<String> showBroadcastStation()
    {
        return broadcastStationDao.showBroadcastList();
    }
}

