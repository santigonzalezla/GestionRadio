package Util;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

import java.util.Map;

public class Player implements BasicPlayerListener
{
    public BasicPlayer player = new BasicPlayer();
    public BasicController controller = (BasicController) player;

    public Player()
    {
        player.addBasicPlayerListener(this);
    }

    @Override
    public void opened(Object o, Map properties)
    {
        System.out.println("opened: "+ properties.toString());
    }

    @Override
    public void progress(int i,long l, byte [] bytes,Map properties)
    {
        System.out.println("progress : "+properties.toString());
    }

    @Override
    public void stateUpdated(BasicPlayerEvent evt)
    {

    }

    @Override
    public void setController(BasicController controller)
    {

    }
}
