package Model.Dao;

import Model.Dto.BroadcastStationDto;
import Model.Dto.MusicProgramDto;
import Model.StationManager;
import Persistance.Persistance;

import java.util.ArrayList;

public class MusicProgramDao implements StationManager
{
    private ArrayList<MusicProgramDto> musicProgramList;
    private Persistance fileManager;

    public MusicProgramDao()
    {
        try
        {
            fileManager = new Persistance();
            fileManager.initInput("MusicProgram");
            musicProgramList = (ArrayList<MusicProgramDto>) fileManager.readSerializable();
            fileManager.closeReaderSerializable();
        }
        catch (Exception e)
        {
            musicProgramList = new ArrayList<>();
        }
    }

    @Override
    public void saveInstance(Object o)
    {
        musicProgramList.add((MusicProgramDto) o);
        fileManager.initOutput("MusicProgram");
        fileManager.writeSerializable(musicProgramList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void deleteInstance(Object o)
    {
        musicProgramList.remove((int) o);
        fileManager.initOutput("MusicProgram");
        fileManager.writeSerializable(musicProgramList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void updateInstance(Object o)
    {
        MusicProgramDto aux = (MusicProgramDto) o;
        for (int i = 0; i < musicProgramList.size(); i++)
        {
            if (true) //(musicProgramList.get(i).getId().equals(aux.getId()))
            {
                musicProgramList.remove(i);
                musicProgramList.add(i, aux);
            }
        }

        fileManager.initOutput("MusicProgram");
        fileManager.writeSerializable(musicProgramList);
        fileManager.closeWriterSerializable();
    }
}
