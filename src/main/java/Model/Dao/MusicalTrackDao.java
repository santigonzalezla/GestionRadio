package Model.Dao;

import Model.Dto.BroadcastStationDto;
import Model.Dto.MusicalTrackDto;
import Model.StationManager;
import Persistance.Persistance;

import java.util.ArrayList;

public class MusicalTrackDao implements StationManager
{
    public ArrayList<MusicalTrackDto> musicalTrackList;
    private Persistance fileManager;

    public MusicalTrackDao()
    {
        try
        {
            fileManager = new Persistance();
            fileManager.initInput("MusicalTrack");
            musicalTrackList = (ArrayList<MusicalTrackDto>) fileManager.readSerializable();
            fileManager.closeReaderSerializable();
        }
        catch (Exception e)
        {
            musicalTrackList = new ArrayList<>();
        }
    }

    @Override
    public void saveInstance(Object o)
    {
        musicalTrackList.add((MusicalTrackDto) o);
        fileManager.initOutput("MusicalTrack");
        fileManager.writeSerializable(musicalTrackList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void deleteInstance(Object o)
    {
        musicalTrackList.remove((int) o);
        fileManager.initOutput("MusicalTrack");
        fileManager.writeSerializable(musicalTrackList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void updateInstance(Object o)
    {
        MusicalTrackDto aux = (MusicalTrackDto) o;
        for (int i = 0; i < musicalTrackList.size(); i++)
        {
            if (musicalTrackList.get(i).getNameMusicalTrack() == aux.getNameMusicalTrack())
            {
                musicalTrackList.remove(i);
                musicalTrackList.set(i, aux);
            }
        }
        fileManager.initOutput("MusicalTrack");
        fileManager.writeSerializable(musicalTrackList);
        fileManager.closeWriterSerializable();
    }
}
