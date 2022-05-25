package Model.Dao;

import Model.Dto.BroadcastStationDto;
import Model.StationManager;
import Persistance.Persistance;

import java.util.ArrayList;

public class BroadcastStationDao implements StationManager
{
    private ArrayList<BroadcastStationDto> broadcastStationList;
    private Persistance fileManager;

    public BroadcastStationDao()
    {
        try
        {
            fileManager = new Persistance();
            fileManager.initInput("BroadcastStation");
            broadcastStationList = (ArrayList<BroadcastStationDto>) fileManager.readSerializable();
            fileManager.closeReaderSerializable();
        }
        catch (Exception e)
        {
            broadcastStationList = new ArrayList<>();
        }
    }

    @Override
    public void saveInstance(Object o)
    {
        broadcastStationList.add((BroadcastStationDto) o);
        fileManager.initOutput("BroadcastStation");
        fileManager.writeSerializable(broadcastStationList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void deleteInstance(Object o)
    {
        broadcastStationList.remove((int) o);
        fileManager.initOutput("BroadcastStation");
        fileManager.writeSerializable(broadcastStationList);
        fileManager.closeWriterSerializable();
    }

    @Override
    public void updateInstance(Object o)
    {
        BroadcastStationDto aux = (BroadcastStationDto) o;
        for (int i = 0; i < broadcastStationList.size(); i++)
        {
            if (broadcastStationList.get(i).getNameBroadcastStation().equals(aux.getNameBroadcastStation()))
            {
                broadcastStationList.remove(i);
                broadcastStationList.add(i, aux);
            }
        }
        fileManager.initOutput("BroadcastStation");
        fileManager.writeSerializable(broadcastStationList);
        fileManager.closeWriterSerializable();
    }

    public ArrayList<String> showBroadcastList()
    {
        ArrayList<String> aux = new ArrayList<>();

        for (int i = 0; i < broadcastStationList.size(); i++)
        {
            aux.add(broadcastStationList.get(i).getNameBroadcastStation() +";" + broadcastStationList.get(i).getImageBroadcastStation());
        }

        return aux;
    }
}
